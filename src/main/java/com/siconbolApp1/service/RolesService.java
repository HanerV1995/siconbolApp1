
package com.siconbolApp1.service;

import com.siconbolApp1.model.Roles;
import com.siconbolApp1.repository.IRolesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService implements IRolesService{

    @Autowired
    private IRolesRepository iRolesRepository;

    @Override
    public List<Roles> listRoles() {
        return iRolesRepository.findAll();
    }

    @Override
    public Roles findRolById(Integer idRol) {
        return iRolesRepository.findById(idRol).orElse(null);
    }

    @Override
    public Roles saveRol(Roles roles) {
        return iRolesRepository.save(roles);
    }

    @Override
    public void deleteRol(Roles roles) {
        iRolesRepository.delete(roles);        
    }
    
}
