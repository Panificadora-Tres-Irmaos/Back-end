package com.example.Backend._3.Irmaos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class User {

    private String nome;

    private String sobrenome;

    private String senha;

    @Id
    private String email;

    private ArrayList<ProdutoCarrinho> carrinho;

    private Double saldo;

    public static class ProdutoCarrinho {

        private String id;

        private String nome;

        private int quantidade;

        private Double valor;

        public ProdutoCarrinho(String id, String nome, int quantidade, Double valor) {
            this.id = id;
            this.nome = nome;
            this.quantidade = quantidade;
            this.valor = valor;
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

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public Double getValor() {
            return valor;
        }

        public void setValor(Double valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "ProdutoCarrinho{" +
                    "id='" + id + '\'' +
                    ", nome='" + nome + '\'' +
                    ", valor=" + valor +
                    '}';
        }

    }

    public User(Double saldo, ArrayList<ProdutoCarrinho> carrinho, String email, String senha, String sobrenome, String nome) {
        this.saldo = saldo;
        this.carrinho = carrinho;
        this.email = email;
        this.senha = senha;
        this.sobrenome = sobrenome;
        this.nome = nome;
    }

    public User(String nome, String sobrenome, String email, Double saldo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.saldo = saldo;
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

    public String getSenha() {
        return senha;
    }

    public ArrayList<ProdutoCarrinho> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<ProdutoCarrinho> carrinho) {
        this.carrinho = carrinho;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", carrinho=" + carrinho +
                ", saldo=" + saldo +
                '}';
    }
}
