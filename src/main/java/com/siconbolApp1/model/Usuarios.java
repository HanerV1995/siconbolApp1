/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siconbolApp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table (name = "usuarios")
public class Usuarios {
    
    @Column(name = "Cant")
    private Integer cant;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_Usuario")
    private Integer idUsuario;

    @Column (name = "Nom_Usuario", nullable = false)
    private String  nomUsuario;
    
    @Column (name = "Contraseña", nullable = false)
    private String contrasena;
    
    @OneToOne
    @JoinColumn(name = "ID_Empleado")
    private Empleados idEmpleado;  
    
    @Column (name = "Estado", nullable = false)
    private String estado;
}
