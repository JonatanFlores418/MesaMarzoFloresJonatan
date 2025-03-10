package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Automovil;
import ar.edu.unju.fi.repository.AutomovilRepository;
import ar.edu.unju.fi.service.IAutomovilService;

@Service
public class IAutomovilServiceImp implements IAutomovilService{
@Autowired
AutomovilRepository autoRepository;

public Automovil crear(Automovil automovil) {
	return autoRepository.save(automovil);
}

@Override
public List<Automovil> listar() {
	List<Automovil> automoviles = (List<Automovil>) autoRepository.findAll();
	List<Automovil> autosActivos = new ArrayList<>();
	for (Automovil auto: automoviles) {
		if(auto.getEstado().equals(true)) {
			autosActivos.add(auto);
		}
	}
    return autosActivos;
}


@Override
public Automovil actualizar(Automovil automovil) {
	Automovil automovil1 = autoRepository.findById(automovil.getPatente())
		.orElseThrow(()-> new RuntimeException("automovil no encontrado"));
	automovil1 = automovil;
	return autoRepository.save(automovil1);
}



@Override
public void eliminar(String patente) {
	Automovil automovil = autoRepository.findById(patente)
			.orElseThrow(() -> new RuntimeException("automovil no encontrado"));
		automovil.setEstado(false);
		autoRepository.save(automovil);
}
}
