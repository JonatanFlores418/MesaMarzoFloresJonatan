package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Automovil;

@Repository
public interface AutomovilRepository extends CrudRepository<Automovil, String> {

}
