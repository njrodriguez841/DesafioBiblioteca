package com.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Libro;
import com.desafiolatam.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	LibroRepository libroRepository;
	
	public Libro save(Libro libro) {
		
		return libroRepository.saveAndFlush(libro);
	}

	public List<Libro> findAll() {
		
		return libroRepository.findAll();
	}

	public Libro findById(Long id) {
		return libroRepository.findById(id).get();
	}

	public void eliminarPorId(Long id) {
		libroRepository.deleteById(id);
		
	}

	public List<Libro> busquedaLibro(String autor,String titulo){
		if(autor!=null) {
			return libroRepository.findAllLibrosByAutorTitulo(autor, titulo);
		}
		return null;
	}
	
}
