
package com.siconbolApp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "roles_funciones")
public class Roles_Funciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Rol_Funcion")
    private Integer idRol_Funcion;
    
    // Relación ManyToOne con Roles
    @ManyToOne
    @JoinColumn(name = "ID_Rol", referencedColumnName = "ID_Rol")
    private Roles idRol;

    // Relación ManyToOne con Funciones
    @ManyToOne
    @JoinColumn(name = "ID_Funcion", referencedColumnName = "ID_Funcion")
    private Funciones idFuncion;
}
