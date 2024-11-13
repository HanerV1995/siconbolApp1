
package com.siconbolApp1.repository;

import com.siconbolApp1.model.Boleteros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBoleterosRepository extends JpaRepository<Boleteros, Integer>{

        
}
