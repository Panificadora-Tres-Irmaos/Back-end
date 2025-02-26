package com.example.Backend._3.Irmaos.controller;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.ports.input.DeleteUserInputPort;
import com.example.Backend._3.Irmaos.ports.input.FetchUserInputPort;
import com.example.Backend._3.Irmaos.ports.input.UpdateUserInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private FetchUserInputPort fetchUserInputPort;

    @Autowired
    private UpdateUserInputPort updateUserInputPort;

    @Autowired
    private DeleteUserInputPort deleteUserInputPort;

    @GetMapping("/find_user_id")
    public User fetchUserById(@RequestParam String id) {
        return fetchUserInputPort.fetchUserById(id);
    }

    @GetMapping("/find_user_email")
    public User fetchUserByEmail(@RequestParam String email) {
        return fetchUserInputPort.fetchUserByEmail(email);
    }

    @PutMapping("/update_user_id")
    public String updateUserById(@RequestBody User user, @RequestParam String id) {
        return updateUserInputPort.updateUserById(user, id);
    }

    @PutMapping("/update_user_email")
    public String updateUserByEmail(@RequestBody User user, @RequestParam String email) {
        return updateUserInputPort.updateUserByEmail(user, email);
    }

    @DeleteMapping("/delete_user_id")
    public String deleteUserById(@RequestParam String id) {
        return deleteUserInputPort.deleteUserById(id);
    }

    @DeleteMapping("/delete_user_email")
    public String deleteUserByEmail(@RequestParam String email) {
        return deleteUserInputPort.deleteUserByEmail(email);
    }

}
