package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.modelos.agregar.Genero;
import org.gerdoc.pixup.util.ReadUtil;

public class GeneroCatalogo extends Catalogos<Genero> {
    public static GeneroCatalogo generoCatalogo;

    private GeneroCatalogo() {
        super();
    }

    public static GeneroCatalogo getInstance() {
        if (generoCatalogo == null) {
            generoCatalogo = new GeneroCatalogo();
        }
        return generoCatalogo;
    }

    @Override
    public Genero newT() {
        return new Genero();
    }

    @Override
    public boolean processNewT(Genero genero) {
        System.out.println("Ingresa la Descripción del Género");
        genero.setDescripcion(ReadUtil.read());

        return true;
    }

    @Override
    public void processEditT(Genero genero) {
        System.out.println("ID del Género: " + genero.getId());
        System.out.println("Descripción del Género a editar: " + genero.getDescripcion());

        System.out.println("Teclee la nueva descripción del Género:");
        genero.setDescripcion(ReadUtil.read());
    }
}
