
package com.siconbolApp1.controller;

import com.siconbolApp1.exception.ExceptionNoFound;
import com.siconbolApp1.model.Roles;
import com.siconbolApp1.service.IRolesService;
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
public class RolesController {

    /* ********************************************************************
                            CONTROLADOR DE ROLES
    ******************************************************************** */
    @Autowired
    private IRolesService iRolesService;
    
    @GetMapping("roles")
    public List<Roles> getRoles(){
        return iRolesService.listRoles();
    }

    @GetMapping("rol/{idRol}")
    public ResponseEntity<Roles> getRolById(@PathVariable Integer idRol){
        Roles rol = iRolesService.findRolById(idRol);
        if (rol == null){
            throw new ExceptionNoFound("El Perfil no existe:" + idRol);
        }           
        return ResponseEntity.ok(rol);
    }
    
    @PostMapping("rol")
    public Roles postRol(@RequestBody Roles rol){
        return iRolesService.saveRol(rol);
    }
    
    @PutMapping("rol/{id}")
    public ResponseEntity<Roles> putRolById(@PathVariable Integer id, @RequestBody Roles rolObj){
        Roles rol = iRolesService.findRolById(id);
        if (rol == null){
            throw new ExceptionNoFound("El Perfil no existe: " + id);
        } 
        rol.setIdRol(rolObj.getIdRol());
        rol.setPerfil(rolObj.getPerfil());
        
        Roles updateRol = iRolesService.saveRol(rol);
        return ResponseEntity.ok(updateRol);
    }
        
    @DeleteMapping("rol/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRolById(@PathVariable Integer id){
        Roles rol = iRolesService.findRolById(id);
        if (rol == null){
            throw new ExceptionNoFound("El Perfil no existe:" + id);
        } 
        iRolesService.deleteRol(rol);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Perfil Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
    
}   




