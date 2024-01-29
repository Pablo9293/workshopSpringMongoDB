package com.pablocupertino.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pablocupertino.workshopmongo.domain.User;
import com.pablocupertino.workshopmongo.services.UserService;

//Recurso Rest usar a anotacion abaixo
@RestController
@RequestMapping(value = "/users") // caminho do endpoint
public class UserResource {
	
	//injetar o serviço
	
	@Autowired
	private UserService service;
	
	//metodo que retorna uma lista de usuarios
	@RequestMapping(method = RequestMethod.GET)//Get obtem informações no padrao rest
	public ResponseEntity <List<User>> findAll() { // Retorna atraves do encapsulamento informaçoes cabeçalhos do tipo http
		
		//criando uma nova lista de usuarios
		List <User> list = service.findAll(); //busca os usuarios no banco e guarda na lista
		return ResponseEntity.ok().body(list); // Devolve a lista na resposta da requisição
	}

}
