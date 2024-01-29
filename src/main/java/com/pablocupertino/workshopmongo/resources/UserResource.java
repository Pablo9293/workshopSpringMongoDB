package com.pablocupertino.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pablocupertino.workshopmongo.domain.User;
import com.pablocupertino.workshopmongo.dto.UserDTO;
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
	public ResponseEntity <List<UserDTO>> findAll() { // Retorna atraves do encapsulamento informaçoes cabeçalhos do tipo http
		
		//criando uma nova lista de usuarios
		List <User> list = service.findAll(); //busca os usuarios no banco e guarda na lista
		//Converte a lista de User para UserDTO
		List<UserDTO> listDto = list.stream().map(x ->new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto); // Devolve a lista na resposta da requisição
	}

}
