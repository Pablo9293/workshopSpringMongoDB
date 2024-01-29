package com.pablocupertino.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablocupertino.workshopmongo.domain.Post;
import com.pablocupertino.workshopmongo.repository.PostRepository;
import com.pablocupertino.workshopmongo.services.exception.ObjectNotFoundException;

@Service // serviços injetaveis em outras classes
public class PostService {

	@Autowired
	private PostRepository rep; // mecanismo de injeção de dependencia automatica do spring

	public Post findById(String id) {
		Optional<Post> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	//metodo de busca 
	public List<Post> findByTitle(String text){
		return rep.findByTitleContainingIgnoreCase(text);
	}

}
