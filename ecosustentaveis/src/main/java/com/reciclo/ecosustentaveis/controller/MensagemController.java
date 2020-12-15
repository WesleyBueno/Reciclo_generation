package com.reciclo.ecosustentaveis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.reciclo.ecosustentaveis.model.Mensagem;
import com.reciclo.ecosustentaveis.repository.MensagemRepository;

@RestController
@RequestMapping
@CrossOrigin("*")
public class MensagemController {
	
	@Autowired
	private MensagemRepository repository;
			
	@GetMapping ("/mensagem")
	public List<Mensagem> findAll(){
		return repository.findAll();
	}
	@GetMapping ("/mensagem/{id}")
	public Optional<Mensagem>findAll(@PathVariable Long id ){
		return repository.findById(id);
	}
	
	@PostMapping("/mensagem")
	public Mensagem criar (@RequestBody Mensagem msn) {
		repository.save(msn);
		return msn;
	}
	    
	@DeleteMapping ("/mensagem/{mensagemId}")
	public void delete (@PathVariable Long mensagemId) {
		repository.deleteById(mensagemId);
	}
	    
	

}
