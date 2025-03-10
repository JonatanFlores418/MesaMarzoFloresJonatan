package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Estacionamiento;
import ar.edu.unju.fi.repository.EstacionamientoRepository;
import ar.edu.unju.fi.service.IEstacionamientoService;
@Service
public class IEstacionamientoServiceImp implements IEstacionamientoService{
	@Autowired
    EstacionamientoRepository estacionamientoRepository;
	
	@Override
	public Estacionamiento crear(Estacionamiento estacionamiento){
		return  estacionamientoRepository.save(estacionamiento);
	}

	@Override
	  public List<Estacionamiento> listar() {
	    return (List<Estacionamiento>) estacionamientoRepository.findAll();
	  }


	@Override
	public void actualizarEstado(Long codigo, Boolean disponibilidad) {
		 Estacionamiento estacionamiento = estacionamientoRepository.findById(codigo)
			        .orElseThrow(() -> new RuntimeException("Estacionamiento encontrado"));
			    estacionamiento.setDisponibilidad(disponibilidad);
			    estacionamientoRepository.save(estacionamiento);
			  }

	@Override
	public void eliminar(Long codigo) {
		Estacionamiento estacionamiento = estacionamientoRepository.findById(codigo)
				.orElseThrow(() -> new RuntimeException("Estacionamiento no encontrado"));
			    estacionamiento.setDisponibilidad(false);
			    estacionamientoRepository.save(estacionamiento);
			  }

	 @Override
	  public Estacionamiento buscarPorCodigo(Long codigo) {
	    return estacionamientoRepository.findById(codigo).orElseThrow(() -> new RuntimeException("Estacionamiento no encontrado"));
	  }
	
	@Override
	public Estacionamiento actualizar(Estacionamiento estacionamiento) {
		Estacionamiento existente = buscarPorCodigo(estacionamiento.getCodigo());
	    existente = estacionamiento;
	    return estacionamientoRepository.save(existente);
	  }

}
