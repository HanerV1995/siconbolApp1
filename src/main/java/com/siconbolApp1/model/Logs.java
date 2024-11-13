
package com.siconbolApp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table (name = "logs")
public class Logs {

    @Column(name = "Cant", nullable = false)
    private Integer cant;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Log")
    private Integer idLog;
    
    @Column (name = "Fecha", nullable = false)
    private LocalDate fecha;
    
    @ManyToOne()
    @JoinColumn(name = "ID_Empleado")
    private Empleados idEmpleado;
    
    @Column (name = "Actividad", nullable = false)
    private String actividad;
    
    @Column (name = "Observacion", nullable = false)
    private String observa;
    
    
    /* ***************************************
                METODOS GETERS Y SETERS
    **************************************** */
/*
    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getObservascion() {
        return observascion;
    }

    public void setObservascion(String observascion) {
        this.observascion = observascion;
    }    
  */  
}
