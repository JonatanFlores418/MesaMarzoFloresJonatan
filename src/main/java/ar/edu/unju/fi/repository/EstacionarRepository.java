package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Estacionar;

@Repository
public interface EstacionarRepository extends CrudRepository<Estacionar, Long> {

}
