package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.UsuarioJdbcImpl;
import org.gerdoc.pixup.modelos.registro.Usuario;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class UsuarioCatalogo extends Catalogos<Usuario> {
    private static UsuarioCatalogo instancia;

    private UsuarioCatalogo() {}

    public static UsuarioCatalogo getInstance() {
        if (instancia == null) {
            instancia = new UsuarioCatalogo();
        }
        return instancia;
    }

    @Override
    public Usuario newT() {
        return new Usuario();
    }

    @Override
    public boolean processNewT(Usuario usuario) {
        System.out.println("Nombre:");
        usuario.setNombre(ReadUtil.read());

        System.out.println("Apellido Paterno:");
        usuario.setApellidoPaterno(ReadUtil.read());

        System.out.println("Apellido Materno:");
        usuario.setApellidoMaterno(ReadUtil.read());

        System.out.println("Correo Electrónico:");
        usuario.setEmail(ReadUtil.read());

        System.out.println("Teléfono:");
        usuario.setTelefono(ReadUtil.read());

        System.out.println("Contraseña:");
        usuario.setContrasena(ReadUtil.read());

        return UsuarioJdbcImpl.getInstance().save(usuario);
    }

    @Override
    public void processEditT(Usuario usuario) {
        System.out.println("ID: " + usuario.getId());
        System.out.println("Editar datos del usuario actual:");

        System.out.println("Nuevo nombre (" + usuario.getNombre() + "):");
        usuario.setNombre(ReadUtil.read());

        System.out.println("Nuevo apellido paterno (" + usuario.getApellidoPaterno() + "):");
        usuario.setApellidoPaterno(ReadUtil.read());

        System.out.println("Nuevo apellido materno (" + usuario.getApellidoMaterno() + "):");
        usuario.setApellidoMaterno(ReadUtil.read());

        System.out.println("Nuevo correo electrónico (" + usuario.getEmail() + "):");
        usuario.setEmail(ReadUtil.read());

        System.out.println("Nuevo teléfono (" + usuario.getTelefono() + "):");
        usuario.setTelefono(ReadUtil.read());

        System.out.println("Nueva contraseña:");
        usuario.setContrasena(ReadUtil.read());

        if (UsuarioJdbcImpl.getInstance().update(usuario)) {
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el usuario.");
        }
    }

    @Override
    public void print() {
        List<Usuario> usuarios = UsuarioJdbcImpl.getInstance().findAll();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Usuario usuario = newT();
        if (processNewT(usuario)) {
            System.out.println("Usuario guardado correctamente.");
        } else {
            System.out.println("No se guardó el usuario.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del usuario a editar:");
        int id = ReadUtil.readInt();
        Usuario usuario = UsuarioJdbcImpl.getInstance().findById(id);
        if (usuario != null) {
            processEditT(usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del usuario a eliminar:");
        int id = ReadUtil.readInt();
        Usuario usuario = UsuarioJdbcImpl.getInstance().findById(id);
        if (usuario != null && UsuarioJdbcImpl.getInstance().delete(usuario)) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el usuario.");
        }
    }
}