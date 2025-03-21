package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Estacionamiento;

@Repository
public interface EstacionamientoRepository extends CrudRepository<Estacionamiento, Long>{

	List<Estacionamiento> findByDisponibilidad(boolean disponibilidad);

}
