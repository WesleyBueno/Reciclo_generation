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

import com.reciclo.ecosustentaveis.model.AvaliacaoTable;
import com.reciclo.ecosustentaveis.repository.AvaliacaoRepository;



@RestController
@RequestMapping
@CrossOrigin("*")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoRepository repository;
	
	@GetMapping ("/avaliacao")
	public List<AvaliacaoTable>findAll(){
		return repository.findAll();
	}
	
	
	@GetMapping ("/avaliacao/{idAvaliacao}")
	public ResponseEntity<AvaliacaoTable> getById(@PathVariable Long idAvaliacao){
		return repository.findById(idAvaliacao).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}


	@GetMapping("avaliacao/busca/{avaliacaoNota}")
    public List<AvaliacaoTable> buscarNota(@PathVariable int avaliacaoNota ){
        return repository.findByAvaliacaoNota(avaliacaoNota);
    }
    
    @PostMapping("/avaliacao")
    public AvaliacaoTable criar (@RequestBody AvaliacaoTable objetoAva) {
    	repository.save(objetoAva);
    	return objetoAva;
    	
    }
    
    @PutMapping("/avaliacao/{id}")
    public AvaliacaoTable atualizar (@PathVariable long id, @RequestBody AvaliacaoTable modelAva) {
    modelAva.setIdAvaliacao(id);
    repository.save(modelAva);
    return modelAva;
    }

    @DeleteMapping ("/avaliacao/{idAvaliacao}")
    public void delete (@PathVariable Long idAvaliacao) {
    	repository.deleteById(idAvaliacao);
    }

    
    
}

