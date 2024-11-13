
package com.siconbolApp1.controller;

import com.siconbolApp1.exception.ExceptionNoFound;
import com.siconbolApp1.model.Usuarios;
import com.siconbolApp1.service.IUsuariosService;
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
public class UsuariosController {

    /**************************************************************************************
                                CONTROLADOR DE EMPLEADOS
    /**************************************************************************************/
    @Autowired
    private IUsuariosService iUsuariosService;
    
    @GetMapping("usuarios")
    public List<Usuarios> getUsuarios(){
        return iUsuariosService.listUsuarios();
    }

    @GetMapping("usuario/{idUsuario}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable Integer idUsuario){
        Usuarios usuario = iUsuariosService.findUsuarioById(idUsuario);
        if (usuario == null){
            throw new ExceptionNoFound("El Usuario no existe:" + idUsuario);
        }           
        return ResponseEntity.ok(usuario);
    }
    
    @PostMapping("usuario")
    public Usuarios postUsuario(@RequestBody Usuarios usuario){
        return iUsuariosService.saveUsuario(usuario);
    }
    
    @PutMapping("usuario/{id}")
    public ResponseEntity<Usuarios> putUsuarioById(@PathVariable Integer id, @RequestBody Usuarios usuarioObj){
        Usuarios usuario = iUsuariosService.findUsuarioById(id);
        if (usuario == null){
            throw new ExceptionNoFound("El Usuario con Id:" + id + "no existe. ");
        } 
        usuario.setCant(usuarioObj.getCant());
        usuario.setIdUsuario(usuarioObj.getIdUsuario());
        usuario.setNomUsuario(usuarioObj.getNomUsuario());
        usuario.setContrasena(usuarioObj.getContrasena());
        usuario.setIdEmpleado(usuarioObj.getIdEmpleado());
        usuario.setEstado(usuarioObj.getEstado());
        
        Usuarios updateUsuario = iUsuariosService.saveUsuario(usuario);
        return ResponseEntity.ok(updateUsuario);
    }    
    
    @DeleteMapping("usuario/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUsuarioById(@PathVariable Integer id){
        Usuarios usuario = iUsuariosService.findUsuarioById(id);
        if (usuario == null){
            throw new ExceptionNoFound("El Usuario no existe:" + id);
        } 
        iUsuariosService.deleteUsuario(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Usuario Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }    
    
}   




