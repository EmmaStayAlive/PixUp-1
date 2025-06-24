package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.EstadoJdbcImpl;
import org.gerdoc.pixup.modelos.registro.ubicacion.Estado;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class EstadoCatalogo extends Catalogos<Estado> {
    private static EstadoCatalogo estadoCatalogo;

    private EstadoCatalogo() {
        super();
    }

    public static EstadoCatalogo getInstance() {
        if (estadoCatalogo == null) {
            estadoCatalogo = new EstadoCatalogo();
        }
        return estadoCatalogo;
    }

    @Override
    public Estado newT() {
        return new Estado();
    }

    @Override
    public boolean processNewT(Estado estado) {
        System.out.println("Ingresa el Nombre del Estado:");
        String nombre = ReadUtil.read();
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return false;
        }
        estado.setNombre(nombre.trim());
        return EstadoJdbcImpl.getInstance().save(estado);
    }

    @Override
    public void processEditT(Estado estado) {
        System.out.println("Id del Estado: " + estado.getId());
        System.out.println("Estado actual: " + estado.getNombre());

        System.out.println("Nuevo nombre del Estado:");
        String nuevoNombre = ReadUtil.read();
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            estado.setNombre(nuevoNombre.trim());
            if (EstadoJdbcImpl.getInstance().update(estado)) {
                System.out.println("Estado actualizado con éxito.");
            } else {
                System.out.println("Error al actualizar el estado.");
            }
        } else {
            System.out.println("Entrada no válida, no se realizaron cambios.");
        }
    }

    @Override
    public void print() {
        List<Estado> estados = EstadoJdbcImpl.getInstance().findAll();
        if (estados.isEmpty()) {
            System.out.println("No hay estados registrados.");
        } else {
            estados.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Estado estado = newT();
        if (processNewT(estado)) {
            System.out.println("Estado guardado correctamente.");
        } else {
            System.out.println("Error al guardar el estado.");
        }
    }

    @Override
    public void edit() {
        List<Estado> estados = EstadoJdbcImpl.getInstance().findAll();
        if (estados.isEmpty()) {
            System.out.println("No hay estados para editar.");
            return;
        }

        print();
        System.out.println("Ingresa el ID del Estado a editar:");
        int id = ReadUtil.readInt();
        Estado estado = EstadoJdbcImpl.getInstance().findById(id);

        if (estado != null) {
            processEditT(estado);
        } else {
            System.out.println("Estado con ese ID no encontrado.");
        }
    }

    @Override
    public void remove() {
        List<Estado> estados = EstadoJdbcImpl.getInstance().findAll();
        if (estados.isEmpty()) {
            System.out.println("No hay estados para eliminar.");
            return;
        }

        print();
        System.out.println("Ingresa el ID del Estado a eliminar:");
        int id = ReadUtil.readInt();
        Estado estado = EstadoJdbcImpl.getInstance().findById(id);

        if (estado != null) {
            if (EstadoJdbcImpl.getInstance().delete(estado)) {
                System.out.println("Estado eliminado correctamente.");
            } else {
                System.out.println("Error al eliminar el estado.");
            }
        } else {
            System.out.println("Estado con ese ID no encontrado.");
        }
    }
}