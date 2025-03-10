package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Estacionar;

@Service
public interface IEstacionarService {
	
	public Estacionar guardarEstacionar(Estacionar estacionar);
	
	public List<Estacionar> listarEstacionar();
	
	public void eliminarEstacionar(Long codigo);
}
