package com.pablocupertino.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pablocupertino.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//incluindo o metodo de busca
	List<Post> findByTitleContainingIgnoreCase(String text);

}
