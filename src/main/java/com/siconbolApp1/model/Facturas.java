
package com.siconbolApp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table (name = "facturas")
public class Facturas {

    @Column(name = "Cant", nullable = false)
    private Integer cant;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Factura")
    private Integer idFactura;    
        
    @Column (name = "Ficho", nullable = false)
    private Integer  ficho;
    
    @Column (name = "Vendidas_500", nullable = false)
    private Integer vendidas_500;
   
    @Column (name = "Vendidas_1000", nullable = false)
    private Integer vendidas_1000;
    
    @Column (name = "Vendidas_2000", nullable = false)
    private Integer vendidas_2000;
    
    @Column (name = "Total_Vendidas", nullable = false)
    private Integer totalVendidas
;    
    @Column (name = "Total_a_Pagar", nullable = false)
    private Integer totalPagar;
    
    @Column (name = "Fecha", nullable = false)
    private LocalDateTime fecha;   
    
   /*public int getCant(){
        return cant;
    }
   public void setCant(Integer cant){
       this.cant = cant;
   }*/
}


