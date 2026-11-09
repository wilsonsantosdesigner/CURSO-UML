package com.cursouml.service;

import com.cursouml.model.Produto;
import com.cursouml.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Produto create(Produto categoria){
        return repository.save(categoria);
    }

    public Produto update(Produto produto){
        return repository.save(produto);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
