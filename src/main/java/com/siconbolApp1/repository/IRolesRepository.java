
package com.siconbolApp1.repository;

import com.siconbolApp1.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRolesRepository extends JpaRepository<Roles, Integer>{

        
}
