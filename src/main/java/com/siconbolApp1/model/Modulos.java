
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
@Table (name = "modulos")
public class Modulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Modulo")
    private Integer idModulo;
    
    @Column (name = "Modulo", nullable = false)
    private String modulo;

/* ***************************************
            RELACIONES ENTRE TABLAS
**************************************** */

/*@ManyToMany(mappedBy = "idFuncion")
@JsonBackReference
private List<Funciones> funciones;*/
}

