package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.User;

public interface FetchUserInputPort {

    User fetchUserById(String id);

    User fetchUserByEmail(String email);

}
