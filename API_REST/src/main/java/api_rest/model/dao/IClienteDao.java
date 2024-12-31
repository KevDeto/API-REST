package api_rest.model.dao;

import api_rest.model.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente, Integer>{
}
