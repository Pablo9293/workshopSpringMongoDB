package com.pablocupertino.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pablocupertino.workshopmongo.domain.Post;
import com.pablocupertino.workshopmongo.domain.User;
import com.pablocupertino.workshopmongo.dto.AuthorDTO;
import com.pablocupertino.workshopmongo.repository.PostRepository;
import com.pablocupertino.workshopmongo.repository.UserRepository;

@Configuration // spring entender que e uma configuração
public class Instantiation implements CommandLineRunner {

	// injetar o UserRepository para realizar a operação no nosso banco

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		// declarando o simpledateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();// limpa a coleção no banco
		postRepository.deleteAll(); // limpa a cleção
		// Instanciar os objetos
		User isis = new User(null, "Isis Cupertino", "isis@gmail.com");
		User pablo = new User(null, "Pablo Cupertino", "pablo@gmail.com");
		User barbara = new User(null, "Barbara Souza", "babi@gmail.com");

		// salva os usuarios
		userRepository.saveAll(Arrays.asList(isis, pablo, barbara));

		Post post1 = new Post(null, sdf.parse("30/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(isis));
		Post post2 = new Post(null, sdf.parse("01/04/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(isis));

		// salvando os post
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
