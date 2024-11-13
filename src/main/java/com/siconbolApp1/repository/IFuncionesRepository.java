
package com.siconbolApp1.repository;

import com.siconbolApp1.model.Funciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface IFuncionesRepository extends JpaRepository<Funciones, Integer>{

        
}
