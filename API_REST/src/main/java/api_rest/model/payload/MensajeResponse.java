package api_rest.model.payload;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensajeResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
    private Object objeto;

}
