package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.exception.NotFoundException;
import com.example.Backend._3.Irmaos.ports.input.FetchUserInputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchUserUseCase implements FetchUserInputPort {

    @Autowired
    private FetchUserOutputPort fetchUserOutputPort;

    public User fetchUserById(String id) {
        User user = fetchUserOutputPort.fetchUserById(id);

        if (user == null) {
            throw new NotFoundException("Usuário não encontrado!");
        }

        return user;
    }

    public User fetchUserByEmail(String email) {
        User user = fetchUserOutputPort.fetchUserByEmail(email);

        if (user == null) {
            throw new NotFoundException("Usuário não encontrado!");
        }

        return user;
    }

}
