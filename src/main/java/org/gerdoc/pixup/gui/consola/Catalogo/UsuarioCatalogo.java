package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.modelos.registro.Usuario;
import org.gerdoc.pixup.util.ReadUtil;

public class UsuarioCatalogo extends Catalogos<Usuario> {
    public static UsuarioCatalogo usuarioCatalogo;

    private UsuarioCatalogo() {
        super();
    }

    public static UsuarioCatalogo getInstance() {
        if (usuarioCatalogo == null) {
            usuarioCatalogo = new UsuarioCatalogo();
        }
        return usuarioCatalogo;
    }

    @Override
    public Usuario newT() {
        return new Usuario();
    }

    @Override
    public boolean processNewT(Usuario usuario) {
        System.out.println("Ingresa el Nombre del Usuario");
        usuario.setNombre(ReadUtil.read());

        System.out.println("Ingresa el Apellido Paterno del Usuario");
        usuario.setApellidoPaterno(ReadUtil.read());

        System.out.println("Ingresa el Apellido Materno del Usuario");
        usuario.setApellidoMaterno(ReadUtil.read());

        System.out.println("Ingresa el Email del Usuario");
        usuario.setEmail(ReadUtil.read());

        System.out.println("Ingresa el Teléfono del Usuario");
        usuario.setTelefono(ReadUtil.read());

        System.out.println("Ingresa la Contraseña del Usuario");
        usuario.setContrasena(ReadUtil.read());

        return true;
    }

    @Override
    public void processEditT(Usuario usuario) {
        System.out.println("Id del Usuario: " + usuario.getId());
        System.out.println("Nombre del Usuario a editar: " + usuario.getNombre());

        System.out.println("Teclee el nuevo nombre del Usuario:");
        usuario.setNombre(ReadUtil.read());

        System.out.println("Teclee el nuevo apellido paterno del Usuario:");
        usuario.setApellidoPaterno(ReadUtil.read());

        System.out.println("Teclee el nuevo apellido materno del Usuario:");
        usuario.setApellidoMaterno(ReadUtil.read());

        System.out.println("Teclee el nuevo email del Usuario:");
        usuario.setEmail(ReadUtil.read());

        System.out.println("Teclee el nuevo teléfono del Usuario:");
        usuario.setTelefono(ReadUtil.read());

        System.out.println("Teclee la nueva contraseña del Usuario:");
        usuario.setContrasena(ReadUtil.read());
    }
}
