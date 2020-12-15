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

import com.reciclo.ecosustentaveis.model.PedidoTable;

import com.reciclo.ecosustentaveis.repository.PedidoRepository;


@RestController
@RequestMapping
@CrossOrigin("*")
public class PedidoController {
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping ("/pedido")
	public List<PedidoTable> findAll(){
		return repository.findAll();
	}
	@GetMapping ("/pedido/{idPedido}")
	public ResponseEntity<PedidoTable> getById(@PathVariable Long idPedido){
		return repository.findById(idPedido).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

    
    @PostMapping("/pedido")
    public PedidoTable criar (@RequestBody PedidoTable objetoPed) {
    	repository.save(objetoPed);
    	return objetoPed;
    	
    }
    
    @PutMapping("/pedido/{idPedido}")
    public PedidoTable atualizar (@PathVariable Long idPedido, @RequestBody PedidoTable modelPed) {
    modelPed.setIdPedido(idPedido);
    repository.save(modelPed);
    return modelPed;
    }
    
    @DeleteMapping ("/pedido/{idPedido}")
    public void delete (@PathVariable Long idPedido) {
    	repository.deleteById(idPedido);
    }
    

}
