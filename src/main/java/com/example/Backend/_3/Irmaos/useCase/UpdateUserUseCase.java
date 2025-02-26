package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.ports.input.UpdateUserInputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchUserOutputPort;
import com.example.Backend._3.Irmaos.ports.output.UpdateUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase implements UpdateUserInputPort {

    @Autowired
    private UpdateUserOutputPort updateUserOutputPort;

    @Autowired
    private FetchUserOutputPort fetchUserOutputPort;

    public String updateUserById(User user, String id) {

        User antes = fetchUserOutputPort.fetchUserById(id);

        updateUserOutputPort.updateUserById(user, id);

        User depois = fetchUserOutputPort.fetchUserById(id);

        if (antes != depois) {
            return "Produto foi atualizado com sucesso!";
        }
        return "Produto não foi atualizado!";
    }

    public String updateUserByEmail(User user, String email) {

        User antes = fetchUserOutputPort.fetchUserByEmail(email);

        updateUserOutputPort.updateUserByEmail(user, email);

        User depois = fetchUserOutputPort.fetchUserByEmail(email);

        if (antes != depois) {
            return "Produto foi atualizado com sucesso!";
        }
        return "Produto não foi atualizado!";
    }

}
