package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Setter
@Getter
public class Automovil {
@Id
private String patente;

@Enumerated(EnumType.STRING)
private Marca marca;

@Enumerated(EnumType.STRING)
private Color color;


private String Modelo;
private Long dni;

private Boolean estado;

enum Color {
  NEGRO, BLANCO, VERDE, ROJO, GRIS, AMARRILLO, 
}

enum Marca {
  FORD, RENAULT, FIAT, TOYOTA, 
}
}
