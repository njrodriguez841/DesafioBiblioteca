package com.desafiolatam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Libro;
import com.desafiolatam.service.LibroService;

@Controller
public class HomeController {

	@Autowired
	LibroService libroService;
	
	@RequestMapping("/")
	public String principal(@ModelAttribute("libro") Libro libro) {
		
		return "principal.jsp";
	}
	
	@RequestMapping("/librosRegistrados")
	public String librosRegistrados(Model model) {
		
		List<Libro> listaLibros=libroService.findAll();
		model.addAttribute("listaLibros",listaLibros);
		return "librosRegistrados.jsp";
	}
	
	@RequestMapping("/libro/editar/{id}")
	public String eliminarLibro(@PathVariable("id") Long id,
			Model model) {
		Libro libro=libroService.findById(id);
		model.addAttribute("libro",libro);

		return "editarLibro.jsp";
	}
	
	@PostMapping("/libro/actualizar")
	public String persistirEdicion(@ModelAttribute("libro") Libro libro, RedirectAttributes redirectAttributes ) {
	
		
	//Se creará la validación de que al menos se ingrese el nombre del libro y la disponibilidad
		
	if(!libro.getTitulo().equals("") && libro.getTitulo()!=null && libro.getDisponible()!=null) {
		libroService.save(libro);
		redirectAttributes.addFlashAttribute("Correcto","Libro actualizado");
		return "redirect:/librosRegistrados";
	}else {
		redirectAttributes.addFlashAttribute("Error","Ingrese al menos nombre y disponibilidad");
		return "redirect:/librosRegistrados";
		
	}
}
	
	
	@PostMapping("/registro")
	public String agregarLibro(@ModelAttribute("libro") Libro libro, Model model,RedirectAttributes redirectAttributes) {
		
		if(!libro.getTitulo().equals("") && libro.getTitulo()!=null && !libro.getImprenta().equals("") && libro.getImprenta()!=null
				&& libro.getAnio()!=null && libro.getAutor()!=null && !libro.getAutor().equals("") && libro.getDisponible()!=null) {
			
		libroService.save(libro);
		redirectAttributes.addFlashAttribute("Correcto", "Libro ingresado con éxito");
		return "redirect:/";
		
		}else {
			redirectAttributes.addFlashAttribute("Error", "Datos faltantes");
			return "redirect:/";
		}
	}
	
	
	@RequestMapping("/libro/eliminar/{id}")
	public String eliminarAuto(@PathVariable("id") Long id,RedirectAttributes redirectAttributes) {
		libroService.eliminarPorId(id);
		redirectAttributes.addFlashAttribute("Correcto","Registro eliminado con éxito");
		return "redirect:/librosRegistrados";
	}
	
	@RequestMapping("/libro/busqueda")
	public String busqueda(Model model, @Param("autor") String autor, @Param("titulo")String titulo,RedirectAttributes redirectAttributes) {
		
		List<Libro> listaLibros=libroService.busquedaLibro(autor,titulo);
		
		if(listaLibros.size()!=0) {
		model.addAttribute("listaLibros",listaLibros);
		return "librosRegistrados.jsp";
		}else {
			redirectAttributes.addFlashAttribute("Error","Libro no encontrado");
			return "redirect:/librosRegistrados";
		}
	}
	
}
