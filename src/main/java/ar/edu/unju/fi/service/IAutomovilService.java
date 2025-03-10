package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Automovil;

public interface IAutomovilService{
		
	public Automovil crear(Automovil automovil);
	
	public Automovil actualizar(Automovil automovil);
	
	public List<Automovil> listar();
	
	public void eliminar(String patente);
}
