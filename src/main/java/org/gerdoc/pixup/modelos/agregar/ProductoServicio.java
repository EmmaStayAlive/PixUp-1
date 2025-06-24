package org.gerdoc.pixup.modelos.agregar;

import org.gerdoc.pixup.modelos.registro.Catalogo;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

// Colimn sirve para definir las columnas de la tabla en la base de datos
import jakarta.persistence.Column;

// Entity indica que esta clase es una entidad JPA, lo que significa que se mapeará a una tabla en la base de datos
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
// ManyToOne indica una relación de muchos a uno con otra entidad
import jakarta.persistence.ManyToOne;

// Table se utiliza para especificar el nombre de la tabla en la base de datos
import jakarta.persistence.Table;

// Lombok es una biblioteca que ayuda a reducir el código boilerplate en Java
import lombok.*;

@Data // Genera automáticamente los métodos getter, setter, toString, equals y hashCode
@AllArgsConstructor // Genera un constructor con todos los campos como parámetros
@NoArgsConstructor // Genera un constructor sin parámetros
@EqualsAndHashCode(callSuper = true) // Indica que se deben comparar los campos de la superclase (Catalogo) para equals y hashCode
@ToString(callSuper = true) // Indica que se debe incluir la representación en cadena de la superclase (Catalogo) en el método toString
@Entity // Indica que esta clase es una entidad JPA, lo que significa que se mapeará a una tabla en la base de datos
@Table( name = "TBL_PRODUCTOSERVICIO" ) // Especifica el nombre de la tabla en la base de datos

public class ProductoServicio extends Catalogo {
    @Column( name ="NOMBRE" , nullable = false )
    private String nombre;

    @Column( name ="DESCRIPCION" )
    private String descripcion;

    @Column( name ="PRECIO" )
    private Double precio;

    @Column( name ="CANTIDAD" )
    private Integer cantidad;

    @Column( name ="IMAGEN" )
    private String imagen;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "TBL_ARTISTA_ID", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Artista artista;
}