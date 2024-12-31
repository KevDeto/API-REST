package api_rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api_rest.model.dao.IEmpleadoDao;
import api_rest.model.dto.EmpleadoDto;
import api_rest.model.entity.Empleado;
import api_rest.service.IEmpleadoService;

@Service
public class EmpleadoImpl implements IEmpleadoService{
    @Autowired
    private IEmpleadoDao empleadoDao;

    @Transactional
    @Override
    public Empleado save(EmpleadoDto empleadoDto) {
    	Empleado empleado = Empleado.builder()
                .UUID(empleadoDto.getUUID())
                .nombre(empleadoDto.getNombre())
                .apellido(empleadoDto.getApellido())
                .correo(empleadoDto.getCorreo())
                .fechaRegistro(empleadoDto.getFechaRegistro())
                .cargo(empleadoDto.getCargo())
                .sueldo(empleadoDto.getSueldo())
                .build();
        return empleadoDao.save(empleado);
    }

    @Transactional(readOnly = true)
    @Override
    public Empleado findById(Integer id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Empleado empleado) {
    	empleadoDao.delete(empleado);
    }

    @Override
    public boolean existsById(Integer id) {
        return empleadoDao.existsById(id);
    }

    @Override
    public List<Empleado> listAll() {
        return empleadoDao.findAll();
    }
}
