package api_rest.service;

import java.util.List;

import api_rest.model.dto.ClienteDto;
import api_rest.model.dto.EmpleadoDto;
import api_rest.model.entity.Cliente;
import api_rest.model.entity.Empleado;

public interface IEmpleadoService {
    List<Empleado> listAll();
    Empleado save(EmpleadoDto empleado);
    Empleado findById(Integer id);
    void delete(Empleado empleado);
    boolean existsById(Integer id);
}
