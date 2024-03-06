package api_rest.model.dao;

import api_rest.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Integer>{
    
}
