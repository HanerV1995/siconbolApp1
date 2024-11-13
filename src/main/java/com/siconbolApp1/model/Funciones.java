
package com.siconbolApp1.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table (name = "funciones")
public class Funciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Funcion")
    private Integer idFuncion;
    
    @Column (name = "Funcion", nullable = false)
    private String funcion;
    
   /* @ManyToMany
    @Column (name = "ID_Modulo")
    private List<Modulos> idModulos;*/

    
    /* ***************************************
            RELACIONES ENTRE TABLAS
    **************************************** */

    // Relación OneToMany con Roles
    // a traves de Roles_Funciones
    @OneToMany(mappedBy = "idFuncion")
    @JsonBackReference // Evitar ciclos en la serialización JSON
    private List<Roles_Funciones> rolesFunciones;
}
