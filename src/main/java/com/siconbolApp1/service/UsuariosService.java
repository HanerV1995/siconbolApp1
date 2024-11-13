
package com.siconbolApp1.service;

import com.siconbolApp1.model.Usuarios;
import com.siconbolApp1.repository.IUsuariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuariosService implements IUsuariosService{

    @Autowired
    private IUsuariosRepository iUsuariosRepository;

    @Override
    public List<Usuarios> listUsuarios() {
        return iUsuariosRepository.findAll();
    }

    @Override
    public Usuarios findUsuarioById(Integer idUsuario) {
        return iUsuariosRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public Usuarios saveUsuario(Usuarios usuarios) {
        return iUsuariosRepository.save(usuarios);
    }

    @Override
    public void deleteUsuario(Usuarios usuarios) {
        iUsuariosRepository.delete(usuarios);        
    }
    
}
