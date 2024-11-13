
package com.siconbolApp1.repository;

import com.siconbolApp1.model.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IFacturasRepository extends JpaRepository<Facturas, Integer>{

        
}
