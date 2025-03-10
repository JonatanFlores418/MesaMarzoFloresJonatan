package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.edu.unju.fi.model.Automovil;
import ar.edu.unju.fi.service.IAutomovilService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutomovilControler {

    @Autowired
    IAutomovilService automovilService;

    @GetMapping("/automoviles")
    public ModelAndView listarAutomoviles() {
        ModelAndView vista = new ModelAndView("ListAutos");
        vista.addObject("automoviles", automovilService.listar());
        return vista;
    }


    @GetMapping("/automovil/nuevo")
    public ModelAndView formularioNuevoAutomovil() {
        ModelAndView mav = new ModelAndView("formAuto");
        mav.addObject("Marca", List.of("FORD", "RENAULT", "FIAT", "TOYOTA"));
        mav.addObject("Color", List.of("NEGRO", "BLANCO", "VERDE", "ROJO", "GRIS", "AMARRILLO"));
        mav.addObject("automovil", new Automovil());
        return mav;
    }

    @PostMapping("/automovil/guardar")
    public String guardarAutomovil(Automovil automovil, RedirectAttributes redirectAttributes) {
        try {
            automovil.setEstado(true);
            automovilService.crear(automovil);
            redirectAttributes.addFlashAttribute("mensaje", "Automóvil guardado exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al guardar el automóvil. Intente nuevamente.");
        }
        return "redirect:/automoviles";
    }

    @GetMapping("/automovil/eliminar/{patente}")
    public String eliminarAutomovil(@PathVariable String patente, RedirectAttributes redirectAttributes) {
        try {
            automovilService.eliminar(patente);
            redirectAttributes.addFlashAttribute("mensaje", "Automóvil eliminado exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el automóvil. Intente nuevamente.");
        }
        return "redirect:/automoviles";
    }

    @PostMapping("/automovil/actualizar")
    public String actualizarAutomovil(Automovil automovil, RedirectAttributes redirectAttributes) {
        try {
            automovilService.actualizar(automovil);
            redirectAttributes.addFlashAttribute("mensaje", "Automóvil actualizado exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el automóvil. Intente nuevamente.");
        }
        return "redirect:/automoviles";
    }
}
