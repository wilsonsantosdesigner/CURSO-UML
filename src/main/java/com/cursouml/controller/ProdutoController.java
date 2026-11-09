package com.cursouml.controller;

import com.cursouml.model.Categoria;
import com.cursouml.model.Produto;
import com.cursouml.service.CategoriaService;
import com.cursouml.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> findAll() {
        return service.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto produto = service.findById(id);

        if (produto == null) {
            return ResponseEntity.noContent().build(); // Retorna 204
        }
        return ResponseEntity.ok().body(produto);

    }

    @PostMapping
    public Produto create(@RequestBody Produto produto){
        Produto novoProduto = service.create(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto).getBody();

    }

    @PutMapping("/{id}")
    public Produto update(@RequestBody Produto produto, @PathVariable Long id){
        Produto novoProduto = service.findById(id);
        if (novoProduto == null) {
            ResponseEntity.notFound().build();
        }

        novoProduto.setNome(produto.getNome());
        novoProduto.setPreco(produto.getPreco());
        novoProduto.setCategorias(produto.getCategorias());

        return service.update(novoProduto);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Produto produto = service.findById(id);
        if (produto == null) {
            ResponseEntity.notFound().build();
        }
        service.delete(id);

    }

}