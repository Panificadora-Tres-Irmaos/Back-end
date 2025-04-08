package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.ports.input.DeleteUserInputPort;
import com.example.Backend._3.Irmaos.ports.output.DeleteUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCase implements DeleteUserInputPort {

    @Autowired
    private DeleteUserOutputPort deleteUserOutputPort;

    public String deleteUserByEmail(String email) {
        if (deleteUserOutputPort.deleteUserByEmail(email)) {
            return "User com id="+email+" foi deletado com sucesso!";
        }
        return "User com id="+email+" não foi deletado!";
    }


}
