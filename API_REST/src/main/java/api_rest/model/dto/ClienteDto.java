package api_rest.model.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ClienteDto implements Serializable {

    private Integer UUID;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaRegistro;

}
