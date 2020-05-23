package com.scl.livro;

public class LivroNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 4539349043723382600L;

	public LivroNotFoundException(Long id) {
		super("Não foi possível achar o livro: " + id);
	}
}
