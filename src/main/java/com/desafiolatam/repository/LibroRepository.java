package com.desafiolatam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

	@Query(value="SELECT * FROM libros WHERE autor=?1 OR titulo=?1", nativeQuery=true)
	List<Libro> findAllLibrosByAutorTitulo(String autor, String titulo);
	
	
}
