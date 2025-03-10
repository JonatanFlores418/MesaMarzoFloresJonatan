package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Estacionar;
import ar.edu.unju.fi.repository.AutomovilRepository;
import ar.edu.unju.fi.repository.EstacionamientoRepository;
import ar.edu.unju.fi.repository.EstacionarRepository;
import ar.edu.unju.fi.service.IEstacionarService;

@Service
public class IEstacionarServiceImp implements IEstacionarService{

	@Autowired
	EstacionarRepository estacionarRepository;
	
	@Autowired
	EstacionamientoRepository estacionamientoRepository;
	
	@Autowired
	AutomovilRepository automovilRepository;
	
	@Override
	public Estacionar guardarEstacionar(Estacionar estacionar) {
		estacionar.setEstado(true);
		return estacionarRepository.save(estacionar);
	}

	@Override
	public List<Estacionar> listarEstacionar() {
		 List<Estacionar> estacionar = (List<Estacionar>) estacionarRepository.findAll();
		    List<Estacionar> estacionarActivos = new ArrayList<>();
		    for (Estacionar estacion : estacionar) {
		      if (estacion.getEstado().equals(true)) {
		        estacionarActivos.add(estacion);
		      }
		    }
		    return estacionarActivos;
	}

	@Override
	public void eliminarEstacionar(Long codigo) {
		 Estacionar estacionar = estacionarRepository.findById(codigo)
			        .orElseThrow(() -> new RuntimeException("estacionamiento no encontrado"));
			    estacionar.setEstado(false);
			    estacionarRepository.save(estacionar);
	}

}
