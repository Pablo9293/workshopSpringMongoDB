package com.pablocupertino.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pablocupertino.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	@Query("{ 'title': { $regex: ?0 , $options: 'i'}}")//dentro do @Query o Json
	List<Post>searchTitle(String text);
	
	//incluindo o metodo de busca
	List<Post> findByTitleContainingIgnoreCase(String text);

}
