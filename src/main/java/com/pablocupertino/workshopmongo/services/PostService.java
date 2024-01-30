package com.pablocupertino.workshopmongo.services;

import java.util.Date;
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
		return rep.searchTitle(text);
	}
	//criar metodo de consulta
	public List<Post> fullSearch(String text , Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return rep.fullSearch(text, minDate, maxDate);
	}

}
