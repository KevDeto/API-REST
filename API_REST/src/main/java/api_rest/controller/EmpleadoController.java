package api_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api_rest.model.dto.ClienteDto;
import api_rest.model.dto.EmpleadoDto;
import api_rest.model.entity.Cliente;
import api_rest.model.entity.Empleado;
import api_rest.model.payload.MensajeResponse;
import api_rest.service.IClienteService;
import api_rest.service.IEmpleadoService;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("empleados")
    public ResponseEntity<?> showAll() {
        List<Empleado> getList = empleadoService.listAll();
        if (getList == null) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No hay registros")
                    .objeto(null)
                    .build(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("")
                .objeto(getList)
                .build(),
                HttpStatus.OK);
    }

    @PostMapping("empleado")
    public ResponseEntity<?> create(@RequestBody EmpleadoDto empleadoDto) {
        Empleado empleadoSave = null;
        try {
        	empleadoSave = empleadoService.save(empleadoDto);
            return new ResponseEntity<>(MensajeResponse
                    .builder()
                    .mensaje("Guardado correctamente")
                    .objeto(empleadoDto)
                    .build(),
                    HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .objeto(null)
                    .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("empleado/{id}")
    public ResponseEntity<?> update(@RequestBody EmpleadoDto empleadoDto, @PathVariable Integer id) {
        Empleado empleadoUpdate = null;
        try {
            if (empleadoService.existsById(id)) {
            	empleadoDto.setUUID(id);
            	empleadoUpdate = empleadoService.save(empleadoDto);
                return new ResponseEntity<>(MensajeResponse
                        .builder()
                        .mensaje("Guardado correctamente")
                        .objeto(EmpleadoDto.builder()
                                .UUID(empleadoUpdate.getUUID())
                                .nombre(empleadoUpdate.getNombre())
                                .apellido(empleadoUpdate.getApellido())
                                .correo(empleadoUpdate.getCorreo())
                                .fechaRegistro(empleadoUpdate.getFechaRegistro())
                                .cargo(empleadoUpdate.getCargo())
                                .sueldo(empleadoUpdate.getSueldo())
                                .build())
                        .build(),
                        HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("El registro que intenta actualizar no se encuentra en la base de datos")
                        .objeto(null)
                        .build(),
                        HttpStatus.NOT_FOUND);
            }

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .objeto(null)
                    .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Empleado empleadoDelete = empleadoService.findById(id);
            empleadoService.delete(empleadoDelete);
            return new ResponseEntity<>(empleadoDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .objeto(null)
                    .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("empleado/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado == null) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("El registro que intenta buscar no existe")
                    .objeto(null)
                    .build(),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("")
                .objeto(EmpleadoDto.builder()
                        .UUID(empleado.getUUID())
                        .nombre(empleado.getNombre())
                        .apellido(empleado.getApellido())
                        .correo(empleado.getCorreo())
                        .fechaRegistro(empleado.getFechaRegistro())
                        .cargo(empleado.getCargo())
                        .sueldo(empleado.getSueldo())
                        .build())
                .build(),
                HttpStatus.OK);
    }
}
