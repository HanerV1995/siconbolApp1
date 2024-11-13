
package com.siconbolApp1.service;

import com.siconbolApp1.model.Empleados;
import java.util.List;

public interface IEmpleadosService {
    
    public List<Empleados> listEmpleados();
    
    public Empleados findEmpleadoById(Integer idEmpleado);
    
    public Empleados saveEmpleado(Empleados empleados);
    
    public void  deleteEmpleado(Empleados empleados);
}
