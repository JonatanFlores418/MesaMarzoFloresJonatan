package ar.edu.unju.fi.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter

public class Estacionamiento {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo; // Clave primaria
	
	@Enumerated(EnumType.STRING)
	private Zona zona;
	
	private Boolean disponibilidad;
	
	enum Zona {
		  ZONA2, ZONA1
	}
}
