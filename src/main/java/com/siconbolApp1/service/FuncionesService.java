
package com.siconbolApp1.service;

import com.siconbolApp1.model.Funciones;
import com.siconbolApp1.repository.IFuncionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FuncionesService implements IFuncionesService{

    @Autowired
    private IFuncionesRepository iFuncionesRepository;

    @Override
    public List<Funciones> listFunciones() {
        return iFuncionesRepository.findAll();
    }

    @Override
    public Funciones findFuncionById(Integer idFuncion) {
        return iFuncionesRepository.findById(idFuncion).orElse(null);
    }

    @Override
    public Funciones saveFuncion(Funciones funciones) {
        return iFuncionesRepository.save(funciones);
    }

    @Override
    public void deleteFuncion(Funciones funciones) {
        iFuncionesRepository.delete(funciones);        
    }
    
}
