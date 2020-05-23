package com.scl.livro;

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
@RequestMapping("livros")
public class LivroController {
	private final LivroService livroService;

	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

	@GetMapping
	public List<Livro> all() {
		return livroService.listar();
	}

	@PostMapping
	public Livro adicionar(@RequestBody Livro novoLivro) {
		return livroService.incluir(novoLivro);
	}

	@GetMapping("{id}")
	public Livro one(@PathVariable Long id) {
		return livroService.buscarPorId(id).orElseThrow(() -> new LivroNotFoundException(id));
	}

	@PutMapping("{id}")
	public Livro atualizar(@RequestBody Livro novoLivro, @PathVariable Long id) {
		return livroService.atualizar(novoLivro, id).orElseThrow(() -> new LivroNotFoundException(id));
	}

	@DeleteMapping("{id}")
	public void excluir(@PathVariable Long id) {
		// Verifica se o livro existe
		livroService.buscarPorId(id).orElseThrow(() -> new LivroNotFoundException(id));
		livroService.excluir(id);
	}
}
