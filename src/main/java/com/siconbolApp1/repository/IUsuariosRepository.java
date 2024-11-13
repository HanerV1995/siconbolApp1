
package com.siconbolApp1.repository;

import com.siconbolApp1.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer>{

        
}
