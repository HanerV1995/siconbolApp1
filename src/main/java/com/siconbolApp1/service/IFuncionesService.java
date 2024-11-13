
package com.siconbolApp1.service;

import com.siconbolApp1.model.Funciones;
import java.util.List;

public interface IFuncionesService {
    
    public List<Funciones> listFunciones();
    
    public Funciones findFuncionById(Integer idFuncion);
    
    public Funciones saveFuncion(Funciones funciones);
    
    public void  deleteFuncion(Funciones funciones);
}
