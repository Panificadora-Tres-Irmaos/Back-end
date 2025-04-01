package com.example.Backend._3.Irmaos.ports.output;

import com.example.Backend._3.Irmaos.entity.User;

import java.util.ArrayList;

public interface UpdateUserOutputPort {

    void updateUserById(User user, String id);

    void updateUserByEmail(User user, String email);

    void updateCarrinhoByEmail(ArrayList<User.ProdutoCarrinho> produtoCarrinho, String email);

}
