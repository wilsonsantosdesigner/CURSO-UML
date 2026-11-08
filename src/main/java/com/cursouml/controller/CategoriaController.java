package com.cursouml.controller;

import com.cursouml.model.Categoria;
import com.cursouml.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> findAll() {
        return service.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = service.findById(id);

        if (categoria == null) {
            return ResponseEntity.noContent().build(); // Retorna 204
        }
        return ResponseEntity.ok().body(categoria);

    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria){
        Categoria novaCategoria = service.create(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria).getBody();
    }

    @PutMapping("/{id}")
    public Categoria update(@RequestBody Categoria categoria, @PathVariable Long id){
        Categoria novaCategoria = service.findById(id);
        if (novaCategoria == null) {
            ResponseEntity.notFound().build();
        }

        novaCategoria.setNome(categoria.getNome());
        return service.update(novaCategoria);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Categoria novaCategoria = service.findById(id);
        if (novaCategoria == null) {
            ResponseEntity.notFound().build();
        }

        service.delete(id);

    }

}
