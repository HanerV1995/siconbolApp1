
package com.siconbolApp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table (name = "boletas")
public class Boletas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ficho")
    private Integer ficho;    
        
    @Column (name = "Entregadas_500", nullable = false)
    private Integer  entregadas500;
    
    @Column (name = "Devueltas_500", nullable = false)
    private Integer devueltas500;
   
    @Column (name = "Entregadas_1000", nullable = false)
    private Integer entregadas1000;
    
    @Column (name = "Devueltas_1000", nullable = false)
    private Integer devueltas1000;
    
    @Column (name = "Entregadas_2000", nullable = false)
    private Integer entregadas2000;
    
    @Column (name = "Devueltas_2000", nullable = false)
    private Integer devueltas2000;
    
    @Column (name = "Todal_Entregadas", nullable = false)
    private Integer totalEntregadas;   
    
    @Column (name = "Total_Devueltas", nullable = false)
    private Integer totalDevueltas;   
    
   /*public int getCant(){
        return cant;
    }
   public void setCant(Integer cant){
       this.cant = cant;
   }*/
}


