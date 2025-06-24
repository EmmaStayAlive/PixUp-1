package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.registro.ubicacion.Municipio;
import org.gerdoc.pixup.modelos.registro.ubicacion.Colonia;
import org.gerdoc.pixup.util.ReadUtil;

public class ColoniaCatalogo extends Catalogos<Colonia> {
    public static ColoniaCatalogo coloniaCatalogo;

    private ColoniaCatalogo( ) {
        super();
    }

    public static ColoniaCatalogo getInstance( ) {
        if(coloniaCatalogo==null) {
            coloniaCatalogo = new ColoniaCatalogo();
        }
        return coloniaCatalogo;
    }

    @Override
    public Colonia newT() {
        return new Colonia( );
    }

    @Override
    public boolean processNewT(Colonia colonia) {
        System.out.println("Ingresa el Nombre de la Colonia" );
        colonia.setNombre( ReadUtil.read( ) );

        System.out.println("Ingresa el Codigo Postal de la Colonia" );
        colonia.setCodigoPostal( ReadUtil.read( ) );
        

        System.out.println("Ingresa el Id del Municipio de la Colonia");
        int idMunicipio = Integer.parseInt(ReadUtil.read());
        Municipio municipio = HibernateUtil.getSession().find(Municipio.class, idMunicipio);
        colonia.setMunicipio(municipio);
        return true;
    }

    @Override
    public void processEditT(Colonia colonia) {
        System.out.println("Id de la Colonia " + colonia.getId( ) );
        System.out.println("Colonia a editar: " + colonia.getNombre( ) );

        System.out.println("Teclee el valor nuevo de la colonia" );
        colonia.setNombre( ReadUtil.read( ) );

        System.out.println("Teclee el nuevo codigo postal de la colonia" );
        colonia.setCodigoPostal( ReadUtil.read( ) );

        

    }
}
