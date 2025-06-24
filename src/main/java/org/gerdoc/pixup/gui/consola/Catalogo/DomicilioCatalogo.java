package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.ColoniaJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.DomicilioJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.TDomicilioJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.UsuarioJdbcImpl;
import org.gerdoc.pixup.modelos.registro.ubicacion.Colonia;
import org.gerdoc.pixup.modelos.registro.ubicacion.Domicilio;
import org.gerdoc.pixup.modelos.registro.ubicacion.TDomicilio;
import org.gerdoc.pixup.modelos.registro.Usuario;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class DomicilioCatalogo extends Catalogos<Domicilio> {
    private static DomicilioCatalogo instancia;

    private DomicilioCatalogo() {}

    public static DomicilioCatalogo getInstance() {
        if (instancia == null) {
            instancia = new DomicilioCatalogo();
        }
        return instancia;
    }

    @Override
    public Domicilio newT() {
        return new Domicilio();
    }

    @Override
    public boolean processNewT(Domicilio domicilio) {
        System.out.println("Calle:");
        domicilio.setCalle(ReadUtil.read());

        System.out.println("Número exterior:");
        domicilio.setNumeroExterior(ReadUtil.read());

        System.out.println("Número interior (opcional):");
        domicilio.setNumeroInterior(ReadUtil.read());

        System.out.println("ID de la Colonia:");
        Colonia colonia = ColoniaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (colonia == null) {
            System.out.println("Colonia no encontrada.");
            return false;
        }
        domicilio.setColonia(colonia);

        System.out.println("ID del tipo de domicilio:");
        TDomicilio tipo = TDomicilioJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (tipo == null) {
            System.out.println("Tipo de domicilio no encontrado.");
            return false;
        }
        domicilio.setTDomicilio(tipo);

        System.out.println("ID del usuario:");
        Usuario usuario = UsuarioJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return false;
        }
        domicilio.setUsuario(usuario);

        return DomicilioJdbcImpl.getInstance().save(domicilio);
    }

    @Override
    public void processEditT(Domicilio domicilio) {
        System.out.println("Editar domicilio ID: " + domicilio.getId());

        System.out.println("Nueva calle (" + domicilio.getCalle() + "):");
        domicilio.setCalle(ReadUtil.read());

        System.out.println("Nuevo número exterior (" + domicilio.getNumeroExterior() + "):");
        domicilio.setNumeroExterior(ReadUtil.read());

        System.out.println("Nuevo número interior (" + domicilio.getNumeroInterior() + "):");
        domicilio.setNumeroInterior(ReadUtil.read());

        System.out.println("Nuevo ID de Colonia:");
        Colonia colonia = ColoniaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (colonia != null) domicilio.setColonia(colonia);

        System.out.println("Nuevo ID de Tipo de Domicilio:");
        TDomicilio tipo = TDomicilioJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (tipo != null) domicilio.setTDomicilio(tipo);

        System.out.println("Nuevo ID de Usuario:");
        Usuario usuario = UsuarioJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (usuario != null) domicilio.setUsuario(usuario);

        if (DomicilioJdbcImpl.getInstance().update(domicilio)) {
            System.out.println("Domicilio actualizado.");
        } else {
            System.out.println("Error al actualizar domicilio.");
        }
    }

    @Override
    public void print() {
        List<Domicilio> domicilios = DomicilioJdbcImpl.getInstance().findAll();
        if (domicilios.isEmpty()) {
            System.out.println("No hay domicilios registrados.");
        } else {
            domicilios.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Domicilio domicilio = newT();
        if (processNewT(domicilio)) {
            System.out.println("Domicilio guardado exitosamente.");
        } else {
            System.out.println("No se guardó el domicilio.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del domicilio a editar:");
        Domicilio domicilio = DomicilioJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (domicilio != null) {
            processEditT(domicilio);
        } else {
            System.out.println("Domicilio no encontrado.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del domicilio a eliminar:");
        Domicilio domicilio = DomicilioJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (domicilio != null && DomicilioJdbcImpl.getInstance().delete(domicilio)) {
            System.out.println("Domicilio eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el domicilio.");
        }
    }
}