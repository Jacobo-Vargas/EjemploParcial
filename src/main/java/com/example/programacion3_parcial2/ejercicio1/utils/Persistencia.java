package com.example.programacion3_parcial2.ejercicio1.utils;

import com.example.programacion3_parcial2.ejercicio1.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    private static final String RUTA_ARCHIVO_MOVIMIENTOS = "src/main/resources/movimientos.txt";

    private static final String RUTA_ARCHIVO_MODELO_XML = "src/main/resources/datos.xml";

    private static final String RUTA_ARCHIVO_MODELO_BINARIO = "src/main/resources/datos.dat";

    private static final String RUTA_ARCHIVO_LOG = "EjercicioUno/src/main/resources/persistencia/log/registroLog.txt";

    public static void guardarSismos(Sismo s) throws IOException {

        String contenido = "";

        contenido += s.getCodigo() +
                "@" + s.getDepartamento()  +
                "@" + s.getCiudad() +
                "@"+ s.getHoraInicio() +
                "@" + s.getHoraFinal() +
                "@" + s.getMagnitud() +
                "@" + s.getProfundidad() +"\n";


        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_MOVIMIENTOS, contenido, true);
    }

    public static ArrayList<Sismo> cargarSismoBuscado(String ciudad) throws FileNotFoundException, IOException {

        ArrayList<Sismo> listaSismos = new ArrayList<>();

        Sismo sismoEncontrado = null;

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_MOVIMIENTOS);

        String linea = "";

        for (String s : contenido) {
            linea = s;
            if ((linea.split("@")[2]).equals(ciudad)) {

                sismoEncontrado = new Sismo();

                sismoEncontrado.setCodigo(linea.split("@")[0]);
                sismoEncontrado.setDepartamento(linea.split("@")[1]);
                sismoEncontrado.setCiudad(linea.split("@")[2]);
                sismoEncontrado.setHoraInicio(linea.split("@")[3]);
                sismoEncontrado.setHoraFinal(linea.split("@")[4]);
                sismoEncontrado.setMagnitud(Float.valueOf(linea.split("@")[5]));
                sismoEncontrado.setProfundidad(Float.valueOf(linea.split("@")[6]));

                listaSismos.add(sismoEncontrado);

            }
        }
        return listaSismos;
    }


    public static void lanzarLog(String mensajeLog, int nivel, String accion) throws IOException {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }

    public static ArrayList<Sismo> cargarSismos() throws FileNotFoundException, IOException {
        ArrayList<Sismo> sismos = new ArrayList<Sismo>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_MOVIMIENTOS);
        String linea = "";
        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);

            Sismo sismo = new Sismo();

            sismo.setCodigo(linea.split("@")[0]);
            sismo.setDepartamento(linea.split("@")[1]);
            sismo.setCiudad(linea.split("@")[2]);
            sismo.setHoraInicio(linea.split("@")[3]);
            sismo.setHoraFinal(linea.split("@")[4]);
            sismo.setMagnitud(Float.valueOf(linea.split("@")[5]));
            sismo.setProfundidad(Float.valueOf(linea.split("@")[6]));

            sismos.add(sismo);
        }
        return sismos;
    }

    public static void guardarRecursoSubastaXML(Observatorio observatorio) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_XML, observatorio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void guardarRecursoBinario(Observatorio observatorio) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BINARIO, observatorio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
