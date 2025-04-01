package com.example.Backend._3.Irmaos.adapter;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.ports.output.UpdateUserOutputPort;
import com.example.Backend._3.Irmaos.repository.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UpdateUserAdapter implements UpdateUserOutputPort {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    public void updateUserById(User user, String email) {
        userRepositoryCustom.updateUserByEmail(email, user);
    }

    public void updateCarrinhoByEmail(ArrayList<User.ProdutoCarrinho> produtoCarrinho, String email) {
        userRepositoryCustom.updateCarrinhoByEmail(produtoCarrinho, email);
    }

    public void updateUserByEmail(User user, String email) {
        userRepositoryCustom.updateUserByEmail(email, user);
    }

}
