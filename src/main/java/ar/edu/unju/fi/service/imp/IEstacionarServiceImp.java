package ar.edu.unju.fi.service.imp;

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
		return estacionarRepository.save(estacionar);
	}

	@Override
	public List<Estacionar> listarEstacionar() {

		    return (List<Estacionar>)estacionarRepository.findAll() ;
	}

	@Override
	public void eliminarEstacionar(Long codigo) {
	    if (estacionarRepository.existsById(codigo)) {
	        estacionarRepository.deleteById(codigo);
	    } else {
	        throw new RuntimeException("El estacionamiento no existe");
	    }
	}

}
