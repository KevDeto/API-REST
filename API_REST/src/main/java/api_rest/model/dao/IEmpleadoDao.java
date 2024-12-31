package api_rest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import api_rest.model.entity.Empleado;

public interface IEmpleadoDao extends JpaRepository<Empleado, Integer>{

}
