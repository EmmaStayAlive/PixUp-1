package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.modelos.registro.ubicacion.Estado;
import org.gerdoc.pixup.util.ReadUtil;

public class EstadoCatalogo extends Catalogos<Estado> {
    public static EstadoCatalogo estadoCatalogo;

    private EstadoCatalogo( ) {
        super();
    }

    public static EstadoCatalogo getInstance( ) {
        if(estadoCatalogo==null) {
            estadoCatalogo = new EstadoCatalogo();
        }
        return estadoCatalogo;
    }

    @Override
    public Estado newT() {
        return new Estado( );
    }

    @Override
    public boolean processNewT(Estado estado) {
        System.out.println("Ingresa el Nombre del Estado" );
        estado.setNombre( ReadUtil.read( ) );
        return true;
    }

    @Override
    public void processEditT(Estado estado) {
        System.out.println("Id del Estado " + estado.getId( ) );
        System.out.println("Estado a editar: " + estado.getNombre( ) );
        
        System.out.println("Teclee el valor nuevo del estado" );
        estado.setNombre( ReadUtil.read( ) );
    }
}