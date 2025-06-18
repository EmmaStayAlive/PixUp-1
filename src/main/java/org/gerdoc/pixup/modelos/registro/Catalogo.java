package org.gerdoc.pixup.modelos.registro;

// jakarta.persistence sirve para la persistencia de datos en bases de datos relacionales
import jakarta.persistence.*;

// Lombok es una biblioteca que ayuda a reducir el código boilerplate en Java

// AllArgsConstructor genera un constructor con todos los campos como parámetros
import lombok.AllArgsConstructor;

// Data genera automáticamente los métodos getter, setter, toString, equals y hashCode
import lombok.Data;

// NoArgsConstructor genera un constructor sin parámetros
import lombok.NoArgsConstructor;

@Data // Genera automáticamente los métodos getter, setter, toString, equals y hashCode
@NoArgsConstructor // Genera un constructor sin parámetros
@AllArgsConstructor // Genera un constructor con todos los campos como parámetros
@MappedSuperclass // Indica que esta clase es una superclase para otras entidades

// la clase Catalogo es una superclase que define un identificador común para todas las entidades que la extienden
public abstract class Catalogo {
    @Id // Indica que este campo es la clave primaria de la entidad
    @Column(name = "ID") // Define el nombre de la columna en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor del ID se generará automáticamente por la base de datos
    protected Integer id; 
}