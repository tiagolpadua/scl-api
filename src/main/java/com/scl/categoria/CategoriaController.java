package com.scl.categoria;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	private final CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@GetMapping
	public List<Categoria> listar() {
		return categoriaService.listar();
	}

	@PostMapping
	public Categoria incluir(@RequestBody Categoria novaCategoria) {
		return categoriaService.incluir(novaCategoria);
	}

	@GetMapping("{id}")
	public Categoria buscar(@PathVariable Long id) {
		return categoriaService.buscarPorId(id).orElseThrow(() -> new CategoriaNotFoundException(id));
	}

	@PutMapping("{id}")
	public Categoria atualizar(@RequestBody Categoria categoriaAtualizada, @PathVariable Long id) {
		return categoriaService.atualizar(categoriaAtualizada, id).orElseThrow(() -> new CategoriaNotFoundException(id));
	}

	@DeleteMapping("{id}")
	public void excluir(@PathVariable Long id) {
		// Verifica se o livro existe
		categoriaService.buscarPorId(id).orElseThrow(() -> new CategoriaNotFoundException(id));
		categoriaService.excluir(id);
	}
}
