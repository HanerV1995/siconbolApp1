
package com.siconbolApp1.service;

import com.siconbolApp1.model.Roles;
import java.util.List;

public interface IRolesService {
    
    public List<Roles> listRoles();
    
    public Roles findRolById(Integer idRol);
    
    public Roles saveRol(Roles roles);
    
    public void  deleteRol(Roles roles);
}
