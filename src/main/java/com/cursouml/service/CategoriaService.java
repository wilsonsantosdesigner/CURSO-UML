package com.cursouml.service;

import com.cursouml.exception.ObjectNotFoundException;
import com.cursouml.model.Categoria;
import com.cursouml.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria findById(Long id){
        var categoria = repository.findById(id);
        if(categoria.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado, ID:"+ id +". Tipo Classe: "+ Categoria.class.getName());
        }

        return categoria.get();
    }

    public Categoria create(Categoria categoria){
        return repository.save(categoria);
    }

    public Categoria update(Categoria categoria){
        return repository.save(categoria);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
