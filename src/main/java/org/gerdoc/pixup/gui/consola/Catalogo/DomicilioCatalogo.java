package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.registro.Usuario;
import org.gerdoc.pixup.modelos.registro.ubicacion.Colonia;
import org.gerdoc.pixup.modelos.registro.ubicacion.Domicilio;
import org.gerdoc.pixup.modelos.registro.ubicacion.TDomicilio;
import org.gerdoc.pixup.util.ReadUtil;

public class DomicilioCatalogo extends Catalogos<Domicilio> {
    public static DomicilioCatalogo domicilioCatalogo;

    private DomicilioCatalogo( ) {
        super();
    }

    public static DomicilioCatalogo getInstance( ) {
        if(domicilioCatalogo==null) {
            domicilioCatalogo = new DomicilioCatalogo();
        }
        return domicilioCatalogo;
    }

    @Override
    public Domicilio newT() {
        return new Domicilio( );
    }

    @Override
    public boolean processNewT(Domicilio domicilio) {

        System.out.println("Ingresa la Calle del Domicilio" );
        domicilio.setCalle( ReadUtil.read( ) );

        System.out.println("Ingresa el Numero Exterior del Domicilio" );
        domicilio.setNumeroExterior( ReadUtil.read( ) );

        System.out.println("Ingresa el Numero Interior del Domicilio (opcional, presiona Enter para omitir)" );
        domicilio.setNumeroInterior( ReadUtil.read( ) );

        System.out.println("Ingresa el Id de la Colonia del Domicilio");
        int idColonia = Integer.parseInt(ReadUtil.read());
        Colonia colonia = HibernateUtil.getSession().find(Colonia.class, idColonia);
        domicilio.setColonia(colonia);

        System.out.println("Ingresa el Id del Usuario del Domicilio");
        int idUsuario = Integer.parseInt(ReadUtil.read());
        Usuario usuario = HibernateUtil.getSession().find(Usuario.class, idUsuario);
        domicilio.setUsuario(usuario);

        System.out.println("Ingresa el Id del Tipo de Domicilio");
        int idTDomicilio = Integer.parseInt(ReadUtil.read());
        TDomicilio tDomicilio = HibernateUtil.getSession().find(TDomicilio.class, idTDomicilio);
        domicilio.setTDomicilio(tDomicilio);

        return true;
    }

    @Override
    public void processEditT(Domicilio domicilio) {
        System.out.println("Id del Domicilio " + domicilio.getId( ) );
        System.out.println("Calle del Domicilio a editar: " + domicilio.getCalle( ) );

        System.out.println("Teclee el valor nuevo de la Calle" );
        domicilio.setCalle( ReadUtil.read( ) );

        System.out.println("Teclee el nuevo Numero Exterior del Domicilio" );
        domicilio.setNumeroExterior( ReadUtil.read( ) );

        System.out.println("Teclee el nuevo Numero Interior del Domicilio (opcional, presiona Enter para omitir)" );
        domicilio.setNumeroInterior( ReadUtil.read( ) );
        
        System.out.println("Teclee el nuevo Id de la Colonia");
        int idColonia = Integer.parseInt(ReadUtil.read());
        Colonia colonia = HibernateUtil.getSession().find(Colonia.class, idColonia);
        domicilio.setColonia(colonia);

        System.out.println("Teclee el nuevo Id del Usuario");
        int idUsuario = Integer.parseInt(ReadUtil.read());
        Usuario usuario = HibernateUtil.getSession().find(Usuario.class, idUsuario);
        domicilio.setUsuario(usuario);

        System.out.println("Teclee el nuevo Id del Tipo de Domicilio");
        int idTDomicilio = Integer.parseInt(ReadUtil.read());
        TDomicilio tDomicilio = HibernateUtil.getSession().find(TDomicilio.class, idTDomicilio);
        domicilio.setTDomicilio(tDomicilio);

    }
}
