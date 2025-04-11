package org.gerdoc.pixup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity( name = "TBL_ESTADO")
public class Estado extends Catalogo
{
    @Column( name ="estado" , nullable = false )
    private String nombre;
}
