
package com.siconbolApp1.service;

import com.siconbolApp1.repository.ILogsRepository;
import com.siconbolApp1.model.Logs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LogsService implements ILogsService{

    @Autowired
    private ILogsRepository iLogsRepository;

    @Override
    public List<Logs> listLogs() {
        return iLogsRepository.findAll();
    }

    @Override
    public Logs findLogById(Integer idLog) {
        return iLogsRepository.findById(idLog).orElse(null);
    }

    @Override
    public Logs saveLog(Logs logs) {
        return iLogsRepository.save(logs);
    }

    @Override
    public void deleteLog(Logs logs) {
        iLogsRepository.delete(logs);        
    }
    
}
