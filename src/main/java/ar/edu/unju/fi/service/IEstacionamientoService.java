package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Estacionamiento;

public interface IEstacionamientoService{
	
	public Estacionamiento crear(Estacionamiento estacionamiento);

	public List<Estacionamiento> listar();
	
	public void actualizarEstado(Long codigo, Boolean disponibilidad);
	
	public void eliminar(Long codigo);
	
	public Estacionamiento actualizar(Estacionamiento estacionamiento);
	
	public Estacionamiento buscarPorCodigo(Long codigo);
}
