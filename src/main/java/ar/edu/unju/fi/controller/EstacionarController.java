package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Estacionamiento;
import ar.edu.unju.fi.model.Estacionar;
import ar.edu.unju.fi.service.IAutomovilService;
import ar.edu.unju.fi.service.IEstacionamientoService;
import ar.edu.unju.fi.service.IEstacionarService;

@Controller
public class EstacionarController {

	@Autowired
	IAutomovilService automovilService;
	
	@Autowired
	IEstacionamientoService estacionamientoService;
	
	@Autowired
	IEstacionarService estacionarService;
	
	
    @GetMapping("/estacionado/nuevo")
    public ModelAndView formularioNuevaReserva() {
        ModelAndView mav = new ModelAndView("FormReserva");
        mav.addObject("reserva", new Estacionar());
        mav.addObject("automoviles", automovilService.listar());
        mav.addObject("estacionamientos", estacionamientoService.listar());
        return mav;

    }

	@PostMapping("/estacionado/guardar")
	public String guardarEstacionado(Estacionar estacionar) {
		estacionarService.guardarEstacionar(estacionar);
		Estacionamiento box = estacionar.getEstacionamiento();
		estacionamientoService.actualizarEstado(box.getCodigo(), box.getDisponibilidad());
		return "redirect:/estacionado";
	}
    @PostMapping("/estacionado/nuevo")
    public String agregarReserva(Estacionar estacionar) {
        estacionarService.guardarEstacionar(estacionar);
        return "redirect:/estacionado";  // Redirige a la lista de reservas
    }
    

	@GetMapping("/estacionado")
	public ModelAndView listarEstacionar() {
		ModelAndView mav =new ModelAndView("ListEstacionado");
		mav.addObject("reservas", estacionarService.listarEstacionar());
		return mav;
	}
	
	@GetMapping("/estacionado/eliminar/{codigo}")
	public String eliminarEstacionar(@PathVariable Long Codigo) {
		estacionarService.eliminarEstacionar(Codigo);
		return "redirect:/estacionado";
	}


}

