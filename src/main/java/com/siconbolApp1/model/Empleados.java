
package com.siconbolApp1.model;
        
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table (name = "empleados")
public class Empleados {

    @Column(name = "Cant", nullable = false)
    private Integer cant;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Empleado")
    private Integer idEmpleado;
    
    /* llamanos el valor de su tabla original */
    @ManyToOne
    @JoinColumn(name = "ID_Rol")
    /*@JsonManagedReference /* Usado para evitar q en consultas genere un ciclo */
    private Roles idRol;
    
    @Column (name = "Nombre", nullable = false)
    private String nombre;

    @Column (name = "Apellidos", nullable = false)
    private String apellidos;
    
    @Column (name = "Identificacion", nullable = false)
    private Integer identifi;
    
    @Column (name = "Fecha_Nacimiento")
    private LocalDate fechaNaci;
    
    @Column (name = "Celular", nullable = false)
    private Integer celular;
    
    @Column (name = "Correo")
    private String correo;
    
    
    /* ***************************************
            RELACIONES ENTRE TABLAS
    **************************************** */
    // Relacion OneToMany con Logs
    @OneToMany(mappedBy = "idLog")
    @JsonBackReference /* Usado para evitar ciclos en las consultas */
    private List<Logs> logs;
    
    // Relacion OneToMany con Usuarios
    @OneToMany(mappedBy = "idUsuario")
    @JsonBackReference /* Usado para evitar ciclos en las consultas */
    private List<Usuarios> usuarios;
    
}


    