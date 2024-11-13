
package com.siconbolApp1.repository;

import com.siconbolApp1.model.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ILogsRepository extends JpaRepository<Logs, Integer>{

        
}
