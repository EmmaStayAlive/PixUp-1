package org.gerdoc.pixup.util;

import java.util.Scanner;

public class ReadUtil
{
    private Scanner scanner;
    private static ReadUtil readUtil;

    private ReadUtil()
    {
        scanner = new Scanner( System.in );
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public static ReadUtil getInstance( )
    {
        if(readUtil==null)
        {
            readUtil = new ReadUtil();
        }
        return readUtil;
    }

    public static String read( )
    {
        return getInstance( ).getScanner( ).nextLine();
    }

    public static Integer readInt( )
    {
        String valor = null;
        boolean flag = true;
        Integer aux = null;

        while (flag)
        {
            valor = read();
            if (valor != null && !valor.isEmpty())
            {
                try
                {
                    aux = Integer.valueOf(valor);
                    if (aux != null)
                    {
                        return aux;
                    }
                }
                catch (Exception e)
                {
                }
            }
            System.out.println( "Valor incorrecto, intentelo nuevamente" );
        }
        return null;
    }

    public static Integer string2Integer( String valor )
    {
        try
        {
            return Integer.valueOf(valor);
        }
        catch (Exception e)
        {
        }
        return null;
    }

    public static Double readDouble() {
        String valor = null;
        boolean flag = true;
        Double aux = null;

        while (flag) {
            valor = read();
            if (valor != null && !valor.isEmpty()) {
                try {
                    aux = Double.valueOf(valor);
                    if (aux != null) {
                        return aux;
                    }
                } catch (Exception e) {
                }
            }
            System.out.println("Valor incorrecto, intentelo nuevamente");
        }
        return null;
    }
}