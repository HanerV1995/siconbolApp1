
package com.siconbolApp1.controller;

import com.siconbolApp1.exception.ExceptionNoFound;
import com.siconbolApp1.model.Funciones;
import com.siconbolApp1.service.IFuncionesService;
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
public class FuncionesController {

    /**************************************************************************************
                                CONTROLADOR DE FUNCIONES
    /**************************************************************************************/
    @Autowired
    private IFuncionesService iFuncionesService;
    
    @GetMapping("funciones")
    public List<Funciones> getFunciones(){
        return iFuncionesService.listFunciones();
    }

    @GetMapping("funcion/{idFuncion}")
    public ResponseEntity<Funciones> getFuncionById(@PathVariable Integer idFuncion){
        Funciones funcion = iFuncionesService.findFuncionById(idFuncion);
        if (funcion == null){
            throw new ExceptionNoFound("La Funcion no existe:" + idFuncion);
        }           
        return ResponseEntity.ok(funcion);
    }
    
    @PostMapping("funcion")
    public Funciones postFuncion(@RequestBody Funciones funcion){
        return iFuncionesService.saveFuncion(funcion);
    }
    
    @PutMapping("funcion/{id}")
    public ResponseEntity<Funciones> putFuncionById(@PathVariable Integer id, @RequestBody Funciones funcionObj){
        Funciones funcion = iFuncionesService.findFuncionById(id);
        if (funcion == null){
            throw new ExceptionNoFound("La Funcion con Id:" + id + "no existe. ");
        } 
        funcion.setIdFuncion(funcionObj.getIdFuncion());
        funcion.setFuncion(funcionObj.getFuncion());
        /*funcion.setIdModulos(funcionObj.getIdModulos());*/
        
        Funciones updateFuncion = iFuncionesService.saveFuncion(funcion);
        return ResponseEntity.ok(updateFuncion);
    }    
    
    @DeleteMapping("funcion/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFuncionById(@PathVariable Integer id){
        Funciones funcion = iFuncionesService.findFuncionById(id);
        if (funcion == null){
            throw new ExceptionNoFound("El Usuario no existe:" + id);
        } 
        iFuncionesService.deleteFuncion(funcion);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Usuario Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }    
    
}   




