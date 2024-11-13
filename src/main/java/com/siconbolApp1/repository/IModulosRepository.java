
package com.siconbolApp1.repository;

import com.siconbolApp1.model.Modulos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface IModulosRepository extends JpaRepository<Modulos, Integer>{

        
}
