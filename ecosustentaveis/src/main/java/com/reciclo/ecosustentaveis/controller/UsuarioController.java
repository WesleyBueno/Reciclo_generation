package com.reciclo.ecosustentaveis.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.reciclo.ecosustentaveis.model.UserLoginTable;
import com.reciclo.ecosustentaveis.model.UsuarioTable;
import com.reciclo.ecosustentaveis.repository.UsuarioRepository;
import com.reciclo.ecosustentaveis.service.UsuarioService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioService usuarioService;	
	
	@GetMapping ("/usuario")
	public List<UsuarioTable> findAll(){
		return repository.findAll();
	}
	@GetMapping ("/usuario/{usuarioId}")
	public ResponseEntity<UsuarioTable> getById(@PathVariable Long usuarioId){
		return repository.findById(usuarioId).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/usuario/busca/{usuarioEmail}")
    public Optional<UsuarioTable> buscarEmail(@PathVariable String usuarioEmail){
        return repository.findByusuarioEmail(usuarioEmail);
    }
    
	@GetMapping("/usuario/email/{usuarioEmail}")
	public UsuarioTable findIdByEmail(@PathVariable String usuarioEmail) 
	{
		return repository.findIdByEmail(usuarioEmail);
	}
	
    @PostMapping("/usuario")
    public UsuarioTable criar (@RequestBody UsuarioTable objetoUser) {
    	repository.save(objetoUser);
    	return objetoUser;
    	
    }
    
    @PostMapping("usuario/logar")
    public ResponseEntity<UserLoginTable> aut(@RequestBody Optional<UserLoginTable> user)
    {
    	try 
    	{
    		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    	}
    	catch(Exception e) 
    	{
    		return null;
    	}
    }
    
	@PostMapping("usuario/cadastrar")
	public ResponseEntity<UsuarioTable> Post(@RequestBody UsuarioTable usuario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}

    
    @PutMapping("/usuario/{usuarioId}")
    public UsuarioTable atualizar (@PathVariable Long usuarioId, @RequestBody UsuarioTable model) {
    model.setId(usuarioId);
    repository.save(model);
    return model;
    }
    
    @DeleteMapping ("/usuario/{usuarioId}")
    public void delete (@PathVariable Long usuarioId) {
    	repository.deleteById(usuarioId);
    }

}
