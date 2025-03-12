package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.ports.input.CreateUserInputPort;
import com.example.Backend._3.Irmaos.ports.output.CreateUserOutputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements CreateUserInputPort {

    @Autowired
    private CreateUserOutputPort createUserOutputPort;

    @Autowired
    private FetchUserOutputPort fetchUserOutputPort;

    public String createUser(User request) {
        if (fetchUserOutputPort.fetchUserById(request.getId()) != null) {
            return "Produto já existente!";
        }

        createUserOutputPort.createUser(request);
        return "Produto criado com sucesso!";
    }
}
