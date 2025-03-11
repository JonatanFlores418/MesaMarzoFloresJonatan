package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.model.Estacionamiento;
import ar.edu.unju.fi.service.IEstacionamientoService;

public class IndexController {
	
	IEstacionamientoService estacionamientoService;
	Estacionamiento estacionamiento;
	
	List<Estacionamiento> estacionamientos = estacionamientoService.listar();
	
	int total = estacionamientos.size();
	
@GetMapping("/")
public String index() {
	return "index";
}
}
