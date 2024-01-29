package com.pablocupertino.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablocupertino.workshopmongo.domain.User;
import com.pablocupertino.workshopmongo.dto.UserDTO;
import com.pablocupertino.workshopmongo.repository.UserRepository;
import com.pablocupertino.workshopmongo.services.exception.ObjectNotFoundException;

@Service// serviços injetaveis em outras classes
public class UserService {
	
	//Instanciar um objeto do tipo userRepository automaticamente com a anotação Autowired
	
	@Autowired
	private UserRepository rep; // mecanismo de injeção de dependencia automatica do spring
	
	
	public List<User> findAll(){ //findAll responsavel por retornar todos os usuarios do banco
		return rep.findAll();
		
	}
	public User findById(String id) {
		Optional<User> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	//metodo para inserir
	public User insert(User obj) {
		return rep.insert(obj);
	}
	
	public  void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	

}
