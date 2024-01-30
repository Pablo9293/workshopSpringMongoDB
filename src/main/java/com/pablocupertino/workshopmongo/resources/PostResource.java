package com.pablocupertino.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pablocupertino.workshopmongo.domain.Post;
import com.pablocupertino.workshopmongo.resources.util.URL;
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

	// endpoint para realizar a busca

	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

		text = URL.decodePara(text);
		List<Post> list = service.findByTitle(text);

		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate){
			

		text = URL.decodePara(text);
		//Tratar a data minima
		Date min = URL.converteDate(minDate, new Date(0L)); // data minima do java se  der problema
		//tratar a data maxima
		Date max = URL.converteDate(maxDate, new Date()); // data atual do sistema se der problema
		
		List<Post> list = service.fullSearch(text, min , max);

		return ResponseEntity.ok().body(list);
	}
}
