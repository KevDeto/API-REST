package api_rest.model.dao;

import api_rest.model.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends JpaRepository<Cliente, Integer>{
    
}
