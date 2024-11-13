
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
@Table (name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_Rol")
    private Integer  idRol;
    
    @Column (name = "Perfil", unique = true, nullable = false)
    private String perfil;
        
    
    /* ***************************************
            RELACIONES ENTRE TABLAS
    **************************************** */
    // Relación con Empleados
    @OneToMany(mappedBy = "idRol")
    @JsonBackReference   //Usado para evitar q en consultas genere un ciclo 
    private List<Empleados> empleados;

}
