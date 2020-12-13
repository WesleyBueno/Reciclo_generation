package com.reciclo.ecosustentaveis.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reciclo.ecosustentaveis.model.DetalhePedido;
import com.reciclo.ecosustentaveis.model.DetalhePedidoId;
import com.reciclo.ecosustentaveis.repository.IDetalhePedidoRepository;

@RestController
@RequestMapping("/detalhe")
@CrossOrigin("*")
public class DetalhePedidoController {

	/*
	 
	Em razão de regras de negocio, o detalhe do pedido n possui
	delete e update no CRUD. 

	
	{
        "pedidoPreco": 10.0,
        "pedidoQtd": 10,
        "detalhePedidoId": 
        {
            "produtoId": 2,
            "pedidoId": 3
        }
	}
	 
	 */
	
	@Autowired
	IDetalhePedidoRepository iDetalhePedido;

	@GetMapping("/all")
	public List<DetalhePedido> getAll()
	{
		return iDetalhePedido.findAll();
	}	
	
	//Pegar pedido que tenha o produto mais caro
	@GetMapping("/preco")
	public DetalhePedido getTheHigherPrice()
	{
		return iDetalhePedido.findByPreco();
	}
	
	@PostMapping
	public DetalhePedido post(@RequestBody DetalhePedido detalhePedido) 
	{
		return iDetalhePedido.save(detalhePedido);
	}
	
	
}
