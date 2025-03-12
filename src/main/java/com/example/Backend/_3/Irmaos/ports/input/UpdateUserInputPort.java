package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.User;

public interface UpdateUserInputPort {

    String updateUserById(User user, String id);

    String updateUserByEmail(User user, String email);

    String updateCarrinhoFromUserById(String user_id, String produto_id);

    String makePurchase(String id, Double valor);

}
