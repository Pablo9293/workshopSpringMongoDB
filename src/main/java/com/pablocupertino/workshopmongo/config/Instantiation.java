package com.pablocupertino.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pablocupertino.workshopmongo.domain.User;
import com.pablocupertino.workshopmongo.repository.UserRepository;
@Configuration // spring entender que e uma configuração
public class Instantiation implements CommandLineRunner {
	
	//injetar o UserRepository para realizar a operação no nosso banco
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();//limpa a coleção no banco
		//Instanciar os objetos 
		User isis= new User(null, "Isis Cupertino", "isis@gmail.com");
		User pablo = new User(null, "Pablo Cupertino", "pablo@gmail.com");
		User barbara = new User(null, "Barbara Souza", "babi@gmail.com");
		
		//salva os objetos
		userRepository.saveAll(Arrays.asList(isis,pablo,barbara));
		
	}

}
