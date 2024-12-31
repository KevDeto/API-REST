package api_rest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "empleado")
public class Empleado extends Persona{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cargo")
	private String cargo;
	@Column(name = "sueldo")
	private double sueldo;
}
