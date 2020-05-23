package com.scl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.scl.categoria.Categoria;
import com.scl.categoria.CategoriaRepository;
import com.scl.livro.Livro;
import com.scl.livro.LivroRepository;

@Configuration
class LoadDatabase {

	Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(LivroRepository livroRepository, CategoriaRepository categoriaRepository) {
		return args -> {
			Categoria categoriaAdm = new Categoria("Administração");
			Categoria categoriaAuto = new Categoria("Autoajuda");
			Categoria categoriaDireito = new Categoria("Direito");

			logger.info("Preloading " + categoriaRepository.save(categoriaAdm));
			logger.info("Preloading " + categoriaRepository.save(categoriaAuto));
			logger.info("Preloading " + categoriaRepository.save(categoriaDireito));

			logger.info("Preloading " + livroRepository.save(new Livro("Bilbo Baggins", categoriaAdm)));
			logger.info("Preloading " + livroRepository.save(new Livro("Frodo Baggins", categoriaAuto)));

		};
	}
}
