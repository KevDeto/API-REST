package api_rest.model.dao;

import api_rest.model.entity.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoDao extends JpaRepository<Empleado, Integer>{
}
