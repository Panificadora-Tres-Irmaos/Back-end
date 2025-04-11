package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.exception.NotFoundException;
import com.example.Backend._3.Irmaos.exception.NullPointerException;
import com.example.Backend._3.Irmaos.exception.SameValuesException;
import com.example.Backend._3.Irmaos.exception.InsuficientFundsException;
import com.example.Backend._3.Irmaos.ports.input.UpdateUserInputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchProdutoOutputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchUserOutputPort;
import com.example.Backend._3.Irmaos.ports.output.UpdateUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UpdateUserUseCase implements UpdateUserInputPort {

    @Autowired
    private UpdateUserOutputPort updateUserOutputPort;

    @Autowired
    private FetchUserOutputPort fetchUserOutputPort;

    @Autowired
    private FetchProdutoOutputPort fetchProdutoOutputPort;

    public String updateUserByEmail(User user, String email) {

        User antes = fetchUserOutputPort.fetchUserByEmail(email);

        updateUserOutputPort.updateUserByEmail(user, email);

        User depois = fetchUserOutputPort.fetchUserByEmail(email);

        if (antes != depois) {
            return "Produto foi atualizado com sucesso!";
        }
        return "Produto não foi atualizado!";
    }

    public String updateCarrinhoFromUserByEmail(String user_email, ArrayList<User.ProdutoCarrinho> carrinho) {

        User user_antes = fetchUserOutputPort.fetchUserByEmail(user_email);

        user_antes.setCarrinho(carrinho);

        updateUserOutputPort.updateUserById(user_antes, user_email);

        User user_depois = fetchUserOutputPort.fetchUserByEmail(user_email);

        if (user_antes.getCarrinho() != user_depois.getCarrinho()) {
            return "Carrinho foi atualizado com sucesso!";
        }
        return "Carrinho não foi atualizado!";

    }

    public String insertProduto(String user_email, User.ProdutoCarrinho produto) {

        User user_antes = fetchUserOutputPort.fetchUserByEmail(user_email);

        ArrayList<User.ProdutoCarrinho> carrinho = user_antes.getCarrinho();
        if (carrinho == null) {
            carrinho = new ArrayList<>();
        }

        Optional<User.ProdutoCarrinho> produtoEncontrado = carrinho.stream()
                .filter(p -> p.getId().equals(produto.getId()))
                .findFirst();

        if (produtoEncontrado.isPresent()) {
            User.ProdutoCarrinho p = produtoEncontrado.get();
            p.setQuantidade(p.getQuantidade() + produto.getQuantidade());
        } else {
            carrinho.add(produto);
        }

        user_antes.setCarrinho(carrinho);
        updateUserOutputPort.updateCarrinhoByEmail(carrinho, user_email);

        User user_depois = fetchUserOutputPort.fetchUserByEmail(user_email);

        System.out.println("Antes: " + user_antes);
        System.out.println("Depois: " + user_depois);

        if (!user_antes.getCarrinho().equals(user_depois.getCarrinho())) {
            return "Carrinho foi atualizado com sucesso!";
        }
        return "Carrinho não foi atualizado!";
    }

    public String deleteProduto(String user_email, String produto_id) {

        User user_antes = fetchUserOutputPort.fetchUserByEmail(user_email);

        List<User.ProdutoCarrinho> carrinhoAntes = new ArrayList<>(user_antes.getCarrinho());
        ArrayList<User.ProdutoCarrinho> carrinho = user_antes.getCarrinho();

        if (carrinho == null) {
            throw new NullPointerException("Carrinho é vazio!");
        }

        boolean removido = carrinho.removeIf(p -> p.getId().equals(produto_id));

        if (!removido) {
            throw new NullPointerException("Produto não encontrado!");
        }

        user_antes.setCarrinho(carrinho);
        updateUserOutputPort.updateCarrinhoByEmail(carrinho, user_email);

        User user_depois = fetchUserOutputPort.fetchUserByEmail(user_email);

        System.out.println("Antes: " + carrinhoAntes);
        System.out.println("Depois: " + user_depois.getCarrinho());

        if (!carrinhoAntes.equals(user_depois.getCarrinho())) {
            return "Carrinho foi atualizado com sucesso!";
        }
        return "Carrinho não foi atualizado!";
    }


    public String makePurchase(String email, Double valor) {

        User antes = fetchUserOutputPort.fetchUserByEmail(email);

        if (antes.getSaldo() < valor) {
            throw new InsuficientFundsException("Saldo insuficiente");
        }

        System.out.println("Saldo Antes: "+antes.getSaldo());

        Double antigoSaldo = antes.getSaldo();

        antes.setSaldo(antigoSaldo - valor);
        antes.setCarrinho(new ArrayList<>());

        updateUserOutputPort.updateUserById(antes, email);

        User depois = fetchUserOutputPort.fetchUserByEmail(email);

        System.out.println("Saldo Depois: " + depois.getSaldo());

        double epsilon = 0.00001; // tolerância

        if (Math.abs(antigoSaldo - depois.getSaldo()) < epsilon) {
            throw new SameValuesException("Compra não foi efetuada!");
        }
        return "Compra foi efetuada com sucesso!";
    }

}
