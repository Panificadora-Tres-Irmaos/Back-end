package com.example.Backend._3.Irmaos.controller;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.entity.request.RequestLogin;
import com.example.Backend._3.Irmaos.ports.input.CreateUserInputPort;
import com.example.Backend._3.Irmaos.ports.input.DeleteUserInputPort;
import com.example.Backend._3.Irmaos.ports.input.FetchUserInputPort;
import com.example.Backend._3.Irmaos.ports.input.UpdateUserInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = {"http://10.10.10.230", "http://10.10.11.19", "http://172.28.16.1", "http://localhost:5173", "http://localhost:5174"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private FetchUserInputPort fetchUserInputPort;

    @Autowired
    private CreateUserInputPort createUserInputPort;

    @Autowired
    private UpdateUserInputPort updateUserInputPort;

    @Autowired
    private DeleteUserInputPort deleteUserInputPort;

    //CRUD

    @GetMapping("/find_user_id")
    public User fetchUserById(@RequestParam String id) {
        return fetchUserInputPort.fetchUserById(id);
    }

    @PostMapping("/login")
    public User fetchUserByEmail(@RequestBody RequestLogin request) {
        return fetchUserInputPort.fetchUserByEmail(request.getEmail(), request.getSenha());
    }

    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return createUserInputPort.createUser(user);
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

    // Funções do Cliente no Site

    @PutMapping("/update_carrinho")
    public String updateCarrinho(@RequestParam String user_id, @RequestParam List<User.ProdutoCarrinho> carrinho) {
        return updateUserInputPort.updateCarrinhoFromUserById(user_id, carrinho);
    }

    @GetMapping("/list_carrinho_id")
    public List<User.ProdutoCarrinho> listProdutosCarrinho(@RequestParam String id) {
        return fetchUserInputPort.listProdutos(id);
    }

    @PutMapping("/make_purchase")
    public String makePurchase(@RequestParam String id, @RequestParam Double valor) {
        return updateUserInputPort.makePurchase(id, valor);
    }

}
