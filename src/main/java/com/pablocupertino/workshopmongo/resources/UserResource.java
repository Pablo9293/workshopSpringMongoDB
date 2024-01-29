package com.pablocupertino.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pablocupertino.workshopmongo.domain.Post;
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
	
		@RequestMapping( value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity <UserDTO> findById(@PathVariable String id) {
			//Instanciar um objeto usuario
			User obj =service.findById(id);
			//Gera a resposta
			return ResponseEntity.ok().body(new UserDTO(obj));
		}
		@RequestMapping( method = RequestMethod.POST)
		public ResponseEntity <Void> insert(@RequestBody UserDTO objDto) {
			
			User obj =service.fromDTO(objDto);
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		@RequestMapping( value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity <Void> delete(@PathVariable String id) {
			
			service.delete(id);
			
			return ResponseEntity.noContent().build();
		}
		//implementar o metodo update
		@RequestMapping( value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity <Void> update(@RequestBody UserDTO objDto,@PathVariable String id) {
			
			User obj =service.fromDTO(objDto);
			obj.setId(id);
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
			
		}
		@RequestMapping( value = "/{id}/posts", method = RequestMethod.GET)
		public ResponseEntity <List<Post>> findPosts(@PathVariable String id) {
			//Instanciar um objeto usuario
			User obj =service.findById(id);
			//Gera a resposta
			return ResponseEntity.ok().body(obj.getPosts());//retorna a lista de posts associada ao usuario 
		}
		

}
