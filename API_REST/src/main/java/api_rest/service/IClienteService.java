package api_rest.service;

import api_rest.model.dto.ClienteDto;
import api_rest.model.entity.Cliente;
import java.util.List;

public interface IClienteService {
    List<Cliente> listAll();
    Cliente save(ClienteDto cliente);
    Cliente findById(Integer id);
    void delete(Cliente cliente);
    boolean existsById(Integer id);
}
