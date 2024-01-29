package com.pablocupertino.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pablocupertino.workshopmongo.domain.Post;
import com.pablocupertino.workshopmongo.services.PostService;

//Recurso Rest usar a anotacion abaixo
@RestController
@RequestMapping(value = "/posts") // caminho do endpoint
public class PostResource {

	@Autowired
	private PostService service; // dependencia

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		// Instanciar um objeto usuario
		Post obj = service.findById(id);
		// Gera a resposta
		return ResponseEntity.ok().body(obj);
	}

}
