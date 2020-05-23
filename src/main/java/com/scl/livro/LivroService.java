package com.scl.livro;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LivroService {
	private LivroRepository livroRepository;
	
	public LivroService(LivroRepository LivroRepository) {
		this.livroRepository = LivroRepository;
	}
	
	public List<Livro> listar() {
		return livroRepository.findAll();
	}
	
	public Livro incluir(Livro novoLivro) {
		return livroRepository.save(novoLivro);
	}
	
	public Optional<Livro> buscarPorId(Long id) {
		return livroRepository.findById(id);
	}
	
	public Optional<Livro> atualizar(Livro novoLivro, Long id) {
		return livroRepository.findById(id).map(livro -> {
			livro.setNome(novoLivro.getNome());
			livro.setCategoria(novoLivro.getCategoria());
			return livroRepository.save(livro);
		});
	}
	
	public void excluir(Long id) {
		livroRepository.deleteById(id);
	}
}
