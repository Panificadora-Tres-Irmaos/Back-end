package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.User;

import java.util.List;

public interface UpdateUserInputPort {

    String updateUserById(User user, String id);

    String updateUserByEmail(User user, String email);

    String updateCarrinhoFromUserById(String user_id, List<User.ProdutoCarrinho> carrinho);

    String makePurchase(String id, Double valor);

}
