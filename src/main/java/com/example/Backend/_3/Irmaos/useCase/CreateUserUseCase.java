package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.ports.input.CreateUserInputPort;
import com.example.Backend._3.Irmaos.ports.output.CreateUserOutputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements CreateUserInputPort {

    @Autowired
    private CreateUserOutputPort createUserOutputPort;

    @Autowired
    private FetchUserOutputPort fetchUserOutputPort;

    public ResponseEntity<String> createUser(User request) {
        if (fetchUserOutputPort.fetchUserByEmail(request.getEmail()) != null) {
            return ResponseEntity.status(409).body("User já existente!");
        }

        request.setSaldo(1000.00);

        createUserOutputPort.createUser(request);
        return ResponseEntity.status(201).body("User criado com sucesso!");
    }
}