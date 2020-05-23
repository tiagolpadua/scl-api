package com.scl.categoria;

public class CategoriaNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 4539349043723382600L;

	public CategoriaNotFoundException(Long id) {
		super("Não foi possível achar a categoria: " + id);
	}
}
