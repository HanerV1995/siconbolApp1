
package com.siconbolApp1.service;

import com.siconbolApp1.model.Roles_Funciones;
import com.siconbolApp1.repository.IRoles_FuncionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Roles_FuncionesService implements IRoles_FuncionesService{

    @Autowired
    private IRoles_FuncionesRepository iRoles_FuncionesRepository;

    @Override
    public List<Roles_Funciones> listRoles_Funciones() {
        return iRoles_FuncionesRepository.findAll();
    }

    @Override
    public Roles_Funciones findRol_FuncionById(Integer idRol) {
        return iRoles_FuncionesRepository.findById(idRol).orElse(null);
    }

    @Override
    public Roles_Funciones saveRol_Funcion(Roles_Funciones roles_Funciones) {
        return iRoles_FuncionesRepository.save(roles_Funciones);
    }

    @Override
    public void deleteRol_Funcion(Roles_Funciones roles_Funciones) {
        iRoles_FuncionesRepository.delete(roles_Funciones);        
    }
    
}
