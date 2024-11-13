
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "modulos_boleteros")
public class Modulos_Boleteros {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Modulo_Boletero")
    private Integer idModuloBoletero;
    
    @Column(name = "ID_Ficho")
    private Integer idFicho;
    
    @Column(name = "ID_Modulo")
    private Integer idModulo;
    
}
