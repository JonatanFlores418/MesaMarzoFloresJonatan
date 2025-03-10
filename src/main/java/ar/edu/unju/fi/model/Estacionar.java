package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Estacionamiento.Zona;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter

public class Estacionar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long codigo;
	@NotNull(message= "DEBE SELECCIONAR UNA ZONA")
	private Zona zona;
	
	@OneToOne
	private Automovil automovil;
	
	@OneToOne
	private Estacionamiento estacionamiento;

	private Boolean estado;
	private Long Horas;
	private Long Total;
}
