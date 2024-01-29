package com.pablocupertino.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablocupertino.workshopmongo.domain.User;
import com.pablocupertino.workshopmongo.repository.UserRepository;

@Service// serviços injetaveis em outras classes
public class UserService {
	
	//Instanciar um objeto do tipo userRepository automaticamente com a anotação Autowired
	
	@Autowired
	private UserRepository rep; // mecanismo de injeção de dependencia automatica do spring
	
	
	public List<User> findAll(){ //findAll responsavel por retornar todos os usuarios do banco
		return rep.findAll();
		
	}

}
