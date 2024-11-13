
package com.siconbolApp1.service;

import com.siconbolApp1.model.Roles_Funciones;
import java.util.List;

public interface IRoles_FuncionesService {
    
    public List<Roles_Funciones> listRoles_Funciones();
    
    public Roles_Funciones findRol_FuncionById(Integer idRol_Funcion);
    
    public Roles_Funciones saveRol_Funcion(Roles_Funciones roles_Funciones);
    
    public void  deleteRol_Funcion(Roles_Funciones roles_Funciones);
}
