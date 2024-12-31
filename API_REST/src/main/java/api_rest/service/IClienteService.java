package api_rest.service;

import java.util.List;

import api_rest.model.dto.ClienteDto;
import api_rest.model.entity.Cliente;

public interface IClienteService {
    List<Cliente> listAll();
    Cliente save(ClienteDto clienteDto);
    Cliente findById(Integer id);
    void delete(Cliente cliente);
    boolean existsById(Integer id);
}
