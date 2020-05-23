package com.scl.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	private CategoriaRepository categoriaRepository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	public Categoria incluir(Categoria novaCategoria) {
		return categoriaRepository.save(novaCategoria);
	}
	
	public Optional<Categoria> buscarPorId(Long id) {
		return categoriaRepository.findById(id);
	}
	
	public Optional<Categoria> atualizar(Categoria novaCategoria, Long id) {
		return categoriaRepository.findById(id).map(categoria -> {
			categoria.setNome(novaCategoria.getNome());
			return categoriaRepository.save(categoria);
		});
	}
	
	public void excluir(Long id) {
		categoriaRepository.deleteById(id);
	}
}
