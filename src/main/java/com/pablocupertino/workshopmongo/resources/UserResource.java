package com.pablocupertino.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pablocupertino.workshopmongo.domain.User;

//Recurso Rest usar a anotacion abaixo
@RestController
@RequestMapping(value = "/users") // caminho do endpoint
public class UserResource {
	
	//metodo que retorna uma lista de usuarios
	@RequestMapping(method = RequestMethod.GET)//Get obtem informações no padrao rest
	public ResponseEntity <List<User>> findAll() { // Retorna atraves do encapsulamento informaçoes cabeçalhos do tipo http
		User Isis = new User("1", "Isis Cupertino", "isis@gmail.com");
		User Pablo = new User("2", "Pablo Cupertino", "pablo@gmail.com");
		
		//criando uma nova lista de usuarios
		List <User> list = new ArrayList<>();
		//adicionando os usuarios a lista
		
		list.addAll(Arrays.asList(Isis,Pablo)); // adiciona automaticamente os objetos entre parenteses
		return ResponseEntity.ok().body(list);
	}

}
