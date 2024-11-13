
package com.siconbolApp1.controller;

import com.siconbolApp1.exception.ExceptionNoFound;
import com.siconbolApp1.model.Empleados;
import com.siconbolApp1.service.IEmpleadosService;
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
public class EmpleadosController {

    /**************************************************************************************
                                CONTROLADOR DE EMPLEADOS
    /**************************************************************************************/
    @Autowired
    private IEmpleadosService iEmpleadosService;
    
    @GetMapping("empleados")
    public List<Empleados> getEmpleados(){
        return iEmpleadosService.listEmpleados();
    }

    @GetMapping("empleado/{idEmpleado}")
    public ResponseEntity<Empleados> getEmpleadoById(@PathVariable Integer idEmpleado){
        Empleados empleado = iEmpleadosService.findEmpleadoById(idEmpleado);
        if (empleado == null){
            throw new ExceptionNoFound("El Empleado no existe:" + idEmpleado);
        }           
        return ResponseEntity.ok(empleado);
    }
    
    @PostMapping("empleado")
    public Empleados postEmpleado(@RequestBody Empleados empleado){
        return iEmpleadosService.saveEmpleado(empleado);
    }
    
    @PutMapping("empleado/{id}")
    public ResponseEntity<Empleados> putEmpleadoById(@PathVariable Integer id, @RequestBody Empleados empleadoObj){
        Empleados empleado = iEmpleadosService.findEmpleadoById(id);
        if (empleado == null){
            throw new ExceptionNoFound("El Empleado con Id:" + id + "no existe. ");
        } 
        empleado.setCant(empleadoObj.getCant());
        empleado.setIdEmpleado(empleadoObj.getIdEmpleado());
        empleado.setIdRol(empleadoObj.getIdRol());
        empleado.setNombre(empleadoObj.getNombre());
        empleado.setApellidos(empleadoObj.getApellidos());
        empleado.setIdentifi(empleadoObj.getIdentifi());
        empleado.setFechaNaci(empleadoObj.getFechaNaci());
        empleado.setCelular(empleadoObj.getCelular());
        empleado.setCorreo(empleadoObj.getCorreo()); 
        
        Empleados updateEmpleado = iEmpleadosService.saveEmpleado(empleado);
        return ResponseEntity.ok(updateEmpleado);
    }    
    
    @DeleteMapping("empleado/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmpleadoById(@PathVariable Integer id){
        Empleados empleado = iEmpleadosService.findEmpleadoById(id);
        if (empleado == null){
            throw new ExceptionNoFound("El Empleado no existe:" + id);
        } 
        iEmpleadosService.deleteEmpleado(empleado);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Empleado Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }    
    
}   




