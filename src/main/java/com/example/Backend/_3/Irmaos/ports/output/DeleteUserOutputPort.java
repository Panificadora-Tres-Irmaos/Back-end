package com.example.Backend._3.Irmaos.ports.output;

public interface DeleteUserOutputPort {

    boolean deleteUserById(String id);

    boolean deleteUserByEmail(String email);

}
