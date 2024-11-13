
package com.siconbolApp1.controller;

import com.siconbolApp1.exception.ExceptionNoFound;
import com.siconbolApp1.model.Roles_Funciones;
import com.siconbolApp1.service.IRoles_FuncionesService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/")
@CrossOrigin(value = "http://localhost:4200")
public class Roles_FuncionesController {

    /**************************************************************************************
                                CONTROLADOR DE Roles_Funciones
    /**************************************************************************************/
    @Autowired
    private IRoles_FuncionesService iRoles_FuncionesService;
    
    @GetMapping("roles_funciones")
    public List<Roles_Funciones> getRoles_Funciones(){
        return iRoles_FuncionesService.listRoles_Funciones();
    }

    @GetMapping("rol_funcion/{idRol_Funcion}")
    public ResponseEntity<Roles_Funciones> getRol_FuncionById(@PathVariable Integer idRol_Funcion){
        Roles_Funciones rol_Funcion = iRoles_FuncionesService.findRol_FuncionById(idRol_Funcion);
        if (rol_Funcion == null){
            throw new ExceptionNoFound("El Rol_Funcion no existe:" + idRol_Funcion);
        }           
        return ResponseEntity.ok(rol_Funcion);
    }
    
    @PostMapping("rol_funcion")
    public Roles_Funciones postRol_Funcion(@RequestBody Roles_Funciones rol_Funcion){
        return iRoles_FuncionesService.saveRol_Funcion(rol_Funcion);
    }
    
    @PutMapping("rol_funcion/{id}")
    public ResponseEntity<Roles_Funciones> putRol_FuncionById(@PathVariable Integer id, @RequestBody Roles_Funciones rol_FuncionObj){
        Roles_Funciones rol_Funcion = iRoles_FuncionesService.findRol_FuncionById(id);
        if (rol_Funcion == null){
            throw new ExceptionNoFound("El Rol_Funcion con Id:" + id + "no existe. ");
        } 
        rol_Funcion.setIdRol_Funcion(rol_FuncionObj.getIdRol_Funcion());
        rol_Funcion.setIdRol(rol_FuncionObj.getIdRol());
        rol_Funcion.setIdFuncion(rol_FuncionObj.getIdFuncion());
        
        Roles_Funciones updateRol_Funcion = iRoles_FuncionesService.saveRol_Funcion(rol_Funcion);
        return ResponseEntity.ok(updateRol_Funcion);
    }    
    
    @DeleteMapping("rol_funcion/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRol_FuncionById(@PathVariable Integer id){
        Roles_Funciones rol_Funcion = iRoles_FuncionesService.findRol_FuncionById(id);
        if (rol_Funcion == null){
            throw new ExceptionNoFound("El Rol_Funcion no existe:" + id);
        } 
        iRoles_FuncionesService.deleteRol_Funcion(rol_Funcion);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Rol_Funcion Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }    
    
}   




