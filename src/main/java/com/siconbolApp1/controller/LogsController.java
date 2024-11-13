
package com.siconbolApp1.controller;

import com.siconbolApp1.exception.ExceptionNoFound;
import com.siconbolApp1.model.Logs;
import com.siconbolApp1.service.ILogsService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/")
@CrossOrigin(value = "http://localhost:4200")
public class LogsController {

    /**************************************************************************************
                                CONTROLADOR DE LOGS
    /**************************************************************************************/
    @Autowired
    private ILogsService iLogsService;
    
    @GetMapping("logs")
    public List<Logs> getLogs(){
        return iLogsService.listLogs();
    }

    @GetMapping("log/{idLog}")
    public ResponseEntity<Logs> getLogById(@PathVariable Integer idLog){
        Logs log = iLogsService.findLogById(idLog);
        if (log == null){
            throw new ExceptionNoFound("El Registro no existe:" + idLog);
        }           
        return ResponseEntity.ok(log);
    }
    
    @PostMapping("log")
    public Logs postLog(@RequestBody Logs log){
        return iLogsService.saveLog(log);
    }
    
    @PutMapping("log/{id}")
    public ResponseEntity<Logs> putLogById(@PathVariable Integer id, @RequestBody Logs logObj){
        Logs log = iLogsService.findLogById(id);
        if (log == null){
            throw new ExceptionNoFound("El Registro con Id:" + id + "no existe. ");
        } 
        log.setCant(logObj.getCant());
        log.setIdLog(logObj.getIdLog());
        log.setFecha(logObj.getFecha());
        log.setIdEmpleado(logObj.getIdEmpleado());
        log.setActividad(logObj.getActividad());
        log.setObserva(logObj.getObserva());    
        
        Logs updateLog = iLogsService.saveLog(log);
        return ResponseEntity.ok(updateLog);
    }    
    
    @DeleteMapping("log/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLogById(@PathVariable Integer id){
        Logs log = iLogsService.findLogById(id);
        if (log == null){
            throw new ExceptionNoFound("El Registro no existe:" + id);
        } 
        iLogsService.deleteLog(log);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Registro Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }    
    
}   




