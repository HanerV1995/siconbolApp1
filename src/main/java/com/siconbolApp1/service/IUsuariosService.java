
package com.siconbolApp1.service;

import com.siconbolApp1.model.Usuarios;
import java.util.List;

public interface IUsuariosService {
    
    public List<Usuarios> listUsuarios();
    
    public Usuarios findUsuarioById(Integer idUsuario);
    
    public Usuarios saveUsuario(Usuarios usuarios);
    
    public void  deleteUsuario(Usuarios usuarios);
}
