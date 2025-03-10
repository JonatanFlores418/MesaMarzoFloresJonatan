package ar.edu.unju.fi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Estacionamiento;
import ar.edu.unju.fi.service.IEstacionamientoService;

@Controller
public class EstacionamientoController {

    @Autowired
    private IEstacionamientoService estacionamientoService;

    // Mostrar todos los estacionamientos
    @GetMapping("/estacionamientos")
    public ModelAndView listarEstacionamientos() {
        ModelAndView mav = new ModelAndView("listEstacionamientos");
        mav.addObject("estacionamientos", estacionamientoService.listar());
        return mav;
    }

    // Mostrar formulario para nuevo estacionamiento o para editar uno existente
    @GetMapping("/estacionamiento/nuevo")
    public ModelAndView formularioNuevoEstacionamiento() {
        ModelAndView mav = new ModelAndView("FormBox");
        List<String> zonas = Arrays.asList("ZONA1", "ZONA2"); // Zonas disponibles
        mav.addObject("zonas", zonas); // Pasar las zonas al formulario
        mav.addObject("estacionamiento", new Estacionamiento()); // Formulario vacío para nuevo estacionamiento
        return mav;
    }

    // Mostrar formulario de edición de estacionamiento
    @GetMapping("/estacionamiento/editar/{codigo}")
    public ModelAndView formularioEditarEstacionamiento(@PathVariable Long codigo) {
        ModelAndView mav = new ModelAndView("FormBox");
        Estacionamiento estacionamiento = estacionamientoService.buscarPorCodigo(codigo);
        List<String> zonas = Arrays.asList("ZONA1", "ZONA2");
        mav.addObject("zonas", zonas);
        mav.addObject("estacionamiento", estacionamiento);
        return mav;
    }

    // Guardar un nuevo estacionamiento
    @PostMapping("/estacionamiento/guardar")
    public String guardarEstacionamiento(Estacionamiento estacionamiento) {
        estacionamientoService.crear(estacionamiento);
        return "redirect:/estacionamientos"; // Redirigir a la lista de estacionamientos
    }

    // Actualizar un estacionamiento existente
    @PostMapping("/estacionamientos/actualizar")
    public String actualizarEstacionamiento(Estacionamiento estacionamiento) {
        estacionamientoService.actualizar(estacionamiento);
        return "redirect:/estacionamientos"; // Redirigir a la lista de estacionamientos
    }

    // Actualizar el estado de un estacionamiento (libre u ocupado)
    @GetMapping("/estacionamiento/estado/{codigo}")
    public String actualizarEstadoEstacionamiento(@PathVariable Long codigo, @RequestParam Boolean disponibilidad) {
        estacionamientoService.actualizarEstado(codigo, disponibilidad);
        return "redirect:/estacionamiento"; // Redirigir a la lista de estacionamientos
    }
}
