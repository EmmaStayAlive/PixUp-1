package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.gui.LecturaAccion;
import org.gerdoc.pixup.modelos.registro.Catalogo;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class Catalogos<T extends Catalogo> extends LecturaAccion
{
    protected List<T>list;
    protected T t;
    protected boolean flag2;

    public Catalogos()
    {
        list = new ArrayList<>( );
    }

    public boolean isListEmpty()
    {
        return list.isEmpty();
    }

    public void print( )
    {
        if( isListEmpty( ) )
        {
            System.out.println( "No hay elementos");
        }
        list.stream().forEach( System.out::println );
    }

    public abstract T newT( );
    public abstract boolean processNewT( T t );
    public abstract void processEditT( T t );

    public void add( )
    {
        t = newT( );
        if( processNewT( t ) )
        {
            t.setId( list.size( ) + 1 );
            list.add( t );
        }
    }

    public void edit( )
    {
        if( isListEmpty( ) )
        {
            System.out.println( "No hay elementos" );
            return;
        }
        flag2 = true;
        while ( flag2 )
        {
            System.out.println( "Ingrese el id del elemento a editar" );
            print( );
            t = list.stream().filter( e -> e.getId().equals( ReadUtil.readInt( ) ) ).findFirst().orElse( null );
            if( t == null )
            {
                System.out.println( "Id incorrecto, intentelo nuevamente" );
            }
            else
            {
                processEditT( t );
                flag2 = false;
                System.out.println( "Elemento modificado" );
            }
        }
    }

    public void remove( )
    {
        if( isListEmpty( ) )
        {
            System.out.println( "No hay elementos" );
            return;
        }
        flag2 = true;
        while ( flag2 )
        {
            System.out.println( "Ingrese el id del elemento a borrar" );
            print( );
            t = list.stream().filter( e -> e.getId().equals( ReadUtil.readInt( ) ) ).findFirst().orElse( null );
            if( t==null )
            {
                System.out.println( "Id incorrecto, intentelo nuevamente" );
            }
            else
            {
                list.remove( t );
                flag2 = false;
                System.out.println( "Elemento borrado" );
            }
        }
    }

    @Override
    public void procesaOpcion()
    {
        switch (opcion)
        {
            case 1:
                add( );
                break;
            case 2:
                edit( );
                break;
            case 3:
                remove( );
                break;
            case 4:
                print( );
                break;
        }
    }

    @Override
    public void despliegaMenu()
    {
        System.out.println("Menú de Estado:");
        System.out.println("Seleccione una opcion:");
        System.out.println("1.-Agregar");
        System.out.println("2.-Editar");
        System.out.println("3.-Borrar");
        System.out.println("4.-Imprimir");
        System.out.println("5.-Salir");
    }

    @Override
    public int valorMinMenu( )
    {
        return 1;
    }

    @Override
    public int valorMaxMenu()
    {
        return 5;
    }

}