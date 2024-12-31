package api_rest.service.impl;

import java.util.List;

import api_rest.model.dao.IClienteDao;
import api_rest.model.dto.ClienteDto;
import api_rest.model.entity.Cliente;
import api_rest.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Transactional
    @Override
    public Cliente save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .UUID(clienteDto.getUUID())
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .correo(clienteDto.getCorreo())
                .fechaRegistro(clienteDto.getFechaRegistro())
                .build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public boolean existsById(Integer id) {
        return clienteDao.existsById(id);
    }

    @Override
    public List<Cliente> listAll() {
        return clienteDao.findAll();
    }

}
