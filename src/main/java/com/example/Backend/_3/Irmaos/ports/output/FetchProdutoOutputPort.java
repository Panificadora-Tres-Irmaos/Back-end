package com.example.Backend._3.Irmaos.ports.output;

import com.example.Backend._3.Irmaos.entity.Produto;

import java.util.Optional;

public interface FetchProdutoOutputPort {

    Produto fetchProdutoById(String id);

    Produto fetchProdutoByNome(String nome);

}
