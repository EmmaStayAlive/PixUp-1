package org.gerdoc.pixup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table( name = "TBL_MUNICIPIO" )
public class Municipio extends Catalogo
{
    @Column( name ="MUNICIPIO" , nullable = false )
    private String nombre;
    @ManyToOne()

    private Estado estado;


}
