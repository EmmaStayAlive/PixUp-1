package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.EstadoJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.MunicipioJdbcImpl;
import org.gerdoc.pixup.modelos.registro.ubicacion.Municipio;
import org.gerdoc.pixup.modelos.registro.ubicacion.Estado;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class MunicipioCatalogo extends Catalogos<Municipio> {
    public static MunicipioCatalogo estadoCatalogo;

    private MunicipioCatalogo() {
        super();
    }

    public static MunicipioCatalogo getInstance() {
        if (estadoCatalogo == null) {
            estadoCatalogo = new MunicipioCatalogo();
        }
        return estadoCatalogo;
    }

    @Override
    public Municipio newT() {
        return new Municipio();
    }

    @Override
    public boolean processNewT(Municipio municipio) {
        System.out.println("Nombre del Municipio:");
        String nombre = ReadUtil.read();
        if (nombre == null || nombre.trim().isEmpty()) return false;
        municipio.setNombre(nombre.trim());

        System.out.println("ID del Estado al que pertenece:");
        int idEstado = ReadUtil.readInt();
        Estado estado = EstadoJdbcImpl.getInstance().findById(idEstado);
        if (estado == null) {
            System.out.println("Estado no encontrado.");
            return false;
        }
        municipio.setEstado(estado);
        return MunicipioJdbcImpl.getInstance().save(municipio);
    }

    @Override
    public void processEditT(Municipio municipio) {
        System.out.println("Municipio actual: " + municipio.getNombre());
        System.out.println("Nuevo nombre:");
        String nuevoNombre = ReadUtil.read();
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            municipio.setNombre(nuevoNombre.trim());
        }

        System.out.println("Nuevo ID de Estado:");
        int idEstado = ReadUtil.readInt();
        Estado estado = EstadoJdbcImpl.getInstance().findById(idEstado);
        if (estado != null) {
            municipio.setEstado(estado);
        }

        MunicipioJdbcImpl.getInstance().update(municipio);
        System.out.println("Municipio actualizado.");
    }

    @Override
    public void print() {
        List<Municipio> municipios = MunicipioJdbcImpl.getInstance().findAll();
        if (municipios.isEmpty()) {
            System.out.println("No hay municipios registrados.");
        } else {
            municipios.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Municipio municipio = newT();
        if (processNewT(municipio)) {
            System.out.println("Municipio guardado correctamente.");
        } else {
            System.out.println("No se guardó el municipio.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del Municipio a editar:");
        int id = ReadUtil.readInt();
        Municipio municipio = MunicipioJdbcImpl.getInstance().findById(id);
        if (municipio != null) {
            processEditT(municipio);
        } else {
            System.out.println("Municipio no encontrado.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del Municipio a eliminar:");
        int id = ReadUtil.readInt();
        Municipio municipio = MunicipioJdbcImpl.getInstance().findById(id);
        if (municipio != null && MunicipioJdbcImpl.getInstance().delete(municipio)) {
            System.out.println("Municipio eliminado.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}