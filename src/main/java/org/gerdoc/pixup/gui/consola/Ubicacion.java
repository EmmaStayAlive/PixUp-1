package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.gui.LecturaAccion;
import org.gerdoc.pixup.gui.consola.Catalogo.ColoniaCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.DomicilioCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.EstadoCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.MunicipioCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.TDomicilioCatalogo;
import org.gerdoc.pixup.negocio.Ejecutable;

public class Ubicacion extends LecturaAccion {
    public static Ubicacion listaCatalogos;

    private Ubicacion() {
    }

    public static Ubicacion getInstance( ) {
        if(listaCatalogos==null) {
            listaCatalogos = new Ubicacion();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu() {
        System.out.println( "Seleccione una opcion:" );
        System.out.println( "1.-Estado");
        System.out.println( "2.-Municipio");
        System.out.println( "3.-Colonia");
        System.out.println( "4.-Tipo de Domicilio");
        System.out.println( "5.-Domicilio");
        System.out.println( "6.-Salir");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 6;
    }

    @Override
    public void procesaOpcion() {
        Ejecutable ejecutable = null;
        switch (opcion) {
            case 1:
                ejecutable = EstadoCatalogo.getInstance( );
                break;
            case 2:
                ejecutable = MunicipioCatalogo.getInstance( );
                break;
            case 3:
                ejecutable = ColoniaCatalogo.getInstance( );
                break;
            case 4:
                ejecutable = TDomicilioCatalogo.getInstance( );
                break;
            case 5:
                ejecutable = DomicilioCatalogo.getInstance( );
                break;
        }
        ejecutable.setFlag( true );
        ejecutable.run( );
    }
}
