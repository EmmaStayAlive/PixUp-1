package org.gerdoc.pixup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table( name = "TBL_ESTADO" )
public class Estado extends Catalogo
{
    @Column( name ="ESTADO" , nullable = false )
    private String nombre;
}
