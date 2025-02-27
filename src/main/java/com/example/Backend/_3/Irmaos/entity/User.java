package com.example.Backend._3.Irmaos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String id;

    private String nome;

    private String sobrenome;

    private String senha;

    private String email;

    private Cartao cartao;

    public static class Cartao {
        private String num_cartao;

        private Double saldo;

        public Cartao(String num_cartao, Double saldo) {
            this.num_cartao = num_cartao;
            this.saldo = saldo;
        }

        public String getNum_cartao() {
            return num_cartao;
        }

        public void setNum_cartao(String num_cartao) {
            this.num_cartao = num_cartao;
        }

        public Double getSaldo() {
            return saldo;
        }

        public void setSaldo(Double saldo) {
            this.saldo = saldo;
        }

        @Override
        public String toString() {
            return "Cartao{" +
                    "num_cartao='" + num_cartao + '\'' +
                    ", saldo=" + saldo +
                    '}';
        }
    }

    public User(String id, String nome, String sobrenome, String email, Cartao cartao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cartao = cartao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", cartao=" + cartao +
                '}';
    }
}
