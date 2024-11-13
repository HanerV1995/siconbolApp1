
package com.siconbolApp1.service;

import com.siconbolApp1.model.Empleados;
import com.siconbolApp1.repository.IEmpleadosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpleadosService implements IEmpleadosService{

    @Autowired
    private IEmpleadosRepository iEmpleadosRepository;

    @Override
    public List<Empleados> listEmpleados() {
        return iEmpleadosRepository.findAll();
    }

    @Override
    public Empleados findEmpleadoById(Integer idEmpleado) {
        return iEmpleadosRepository.findById(idEmpleado).orElse(null);
    }

    @Override
    public Empleados saveEmpleado(Empleados empleados) {
        return iEmpleadosRepository.save(empleados);
    }

    @Override
    public void deleteEmpleado(Empleados empleados) {
        iEmpleadosRepository.delete(empleados);        
    }
    
}
