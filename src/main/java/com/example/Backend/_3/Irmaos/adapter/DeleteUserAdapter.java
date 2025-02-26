package com.example.Backend._3.Irmaos.adapter;

import com.example.Backend._3.Irmaos.ports.output.DeleteUserOutputPort;
import com.example.Backend._3.Irmaos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserAdapter implements DeleteUserOutputPort {

    @Autowired
    private UserRepository userRepository;

    public boolean deleteUserById(String id) {
        long deletedCount = userRepository.deleteUserById(id);
        return deletedCount > 0;
    }

    public boolean deleteUserByEmail(String email) {
        long deleteCount = userRepository.deleteUserByEmail(email);
        return deleteCount > 0;
    }


}
