package com.cursouml.service;

import com.cursouml.exception.ObjectNotFoundException;
import com.cursouml.model.Categoria;
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
        var produto = repository.findById(id);
        if(produto.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado, ID:"+ id +". Tipo Classe: "+ Produto.class.getName());
        }

        return produto.get();
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
