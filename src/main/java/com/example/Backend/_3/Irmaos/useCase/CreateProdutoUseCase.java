package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.ports.input.CreateProdutoInputPort;
import com.example.Backend._3.Irmaos.ports.output.CreateProdutoOutputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProdutoUseCase implements CreateProdutoInputPort {

    @Autowired
    private CreateProdutoOutputPort createProdutoOutputPort;

    @Autowired
    private FetchProdutoOutputPort fetchProdutoOutputPort;

    public String createProduto(Produto request) {
        if (fetchProdutoOutputPort.fetchProdutoById(request.getId()) != null) {
            return "Produto já existente!";
        }

        createProdutoOutputPort.createProduto(request);
        return "Produto criado com sucesso!";
    }

}
