package api_rest.model.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer UUID;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaRegistro;

}
