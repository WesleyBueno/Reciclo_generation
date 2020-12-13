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

import com.reciclo.ecosustentaveis.model.CategoriaTable;
import com.reciclo.ecosustentaveis.repository.CategoriaRepository;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping ("/categoria")
	public List<CategoriaTable>findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/categoria/id/{id}")
	public ResponseEntity<CategoriaTable> getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/categoria/{categoriaNome}")
    public List<CategoriaTable> buscarNome(@PathVariable String categoriaNome){
        return repository.findBycategoriaNome(categoriaNome);
    }
    @PostMapping("/categoria")
	public CategoriaTable criar (@RequestBody CategoriaTable objetoCat) {
    	repository.save(objetoCat);
    	return objetoCat;
    }
    @PutMapping("/categoria/{id}")
    public CategoriaTable atualizar (@PathVariable Long id, @RequestBody CategoriaTable modelCat) {
    modelCat.setIdCategoria(id);
    repository.save(modelCat);
    return modelCat;
    }
    
    @DeleteMapping ("/categoria/{id}")
    public void delete (@PathVariable Long id) {
    	repository.deleteById(id);
    }

    
}
