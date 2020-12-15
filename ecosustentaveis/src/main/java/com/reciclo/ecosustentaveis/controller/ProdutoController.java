package com.reciclo.ecosustentaveis.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclo.ecosustentaveis.model.ProdutoTable;
import com.reciclo.ecosustentaveis.repository.ProdutoRepository;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ProdutoController{

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping ("/produto/all")
	public List<ProdutoTable> findAll(){
		return repository.findAll();
	}
	
	@GetMapping ("/produto/id/{id}")
	public ResponseEntity<ProdutoTable> getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/produto/nome/{produtoNome}")
    public List<ProdutoTable> buscarNome(@PathVariable String produtoNome){
        return repository.findByprodutoNome(produtoNome);
    }
	
	 @PostMapping("/produto")
	    public ProdutoTable criar (@RequestBody ProdutoTable objetoProd) 
	 {
	    	repository.save(objetoProd);
	    	return objetoProd;
	    	
	 }
	 
	 @PutMapping("/produto/{id}")
	    public ProdutoTable atualizar (@PathVariable Long id, @RequestBody ProdutoTable model) 
	 {
	    model.setIdProduto(id);
	    repository.save(model);
	    return model;
	 }
	 
	 @DeleteMapping ("/produto/{id}")
	    public void delete (@PathVariable Long id) 
	 {
	    	repository.deleteById(id);
	 }
	 
}
