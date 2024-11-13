
package com.siconbolApp1.service;

import com.siconbolApp1.model.Logs;
import java.util.List;

public interface ILogsService {
    
    public List<Logs> listLogs();
    
    public Logs findLogById(Integer idLog);
    
    public Logs saveLog(Logs logs);
    
    public void  deleteLog(Logs logs);
}
