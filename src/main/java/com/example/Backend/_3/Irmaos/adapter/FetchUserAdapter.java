package com.example.Backend._3.Irmaos.adapter;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.ports.output.FetchUserOutputPort;
import com.example.Backend._3.Irmaos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FetchUserAdapter implements FetchUserOutputPort {

    @Autowired
    private UserRepository userRepository;

    public User fetchUserById(String id) {
        return userRepository.findUserById(id);
    }

    public User fetchUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

}
