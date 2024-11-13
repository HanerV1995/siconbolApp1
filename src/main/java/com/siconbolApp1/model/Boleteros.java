
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
@Table (name = "boleteros")
public class Boleteros {

    @Column(name = "Cant", nullable = false)
    private Integer cant;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ficho")
    private Integer ficho;   
    
    @Column (name = "Nombre", nullable = false)
    private String nombre;
   
    @Column (name = "Apellidos", nullable = false)
    private String apellidos;
    
    @Column (name = "Identificacion", nullable = false)
    private Integer identifi;
    
    @Column (name = "Celular", nullable = false)
    private Integer celular;
        
   /*public int getCant(){
        return cant;
    }
   public void setCant(Integer cant){
       this.cant = cant;
   }*/
}


