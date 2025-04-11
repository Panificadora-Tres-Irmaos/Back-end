package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UpdateUserInputPort {

    String updateUserByEmail(User user, String email);

    String updateCarrinhoFromUserByEmail(String user_email, ArrayList<User.ProdutoCarrinho> carrinho);

    String deleteProduto(String user_email, String produto_id);

    String insertProduto(String user_email, User.ProdutoCarrinho produto);

    String makePurchase(String id, Double valor);

}
