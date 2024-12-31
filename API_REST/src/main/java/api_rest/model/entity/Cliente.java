package api_rest.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "cliente")
public class Cliente extends Persona {
	private static final long serialVersionUID = 1L;
	
}
