package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.ports.input.DeleteUserInputPort;
import com.example.Backend._3.Irmaos.ports.output.DeleteUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCase implements DeleteUserInputPort {

    @Autowired
    private DeleteUserOutputPort deleteUserOutputPort;

    public String deleteUserById(String id) {
        if (deleteUserOutputPort.deleteUserById(id)) {
            return "Produto com id="+id+" foi deletado com sucesso!";
        }
        return "Produto com id="+id+" não foi deletado!";
    }

    public String deleteUserByEmail(String email) {
        if (deleteUserOutputPort.deleteUserByEmail(email)) {
            return "Produto com id="+email+" foi deletado com sucesso!";
        }
        return "Produto com id="+email+" não foi deletado!";
    }


}
