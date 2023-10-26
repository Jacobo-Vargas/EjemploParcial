package com.example.programacion3_parcial2.ejercicio1.utils;

import com.example.programacion3_parcial2.ejercicio1.model.Observatorio;
import com.example.programacion3_parcial2.ejercicio1.model.Sismo;

public class ObservatorioUtil {

    public static Observatorio quemarDatos(){


        Observatorio observatorio = new Observatorio();

        Sismo sismo1 = new Sismo();
        sismo1.setCiudad("Armenia");
        sismo1.setCodigo("01");
        sismo1.setDepartamento("Quindio");
        sismo1.setProfundidad(10F);
        sismo1.setMagnitud(10F);
        sismo1.setHoraInicio("10:00");
        sismo1.setHoraFinal("10:02");


        Sismo sismo2 = new Sismo();
        sismo2.setCiudad("Armenia");
        sismo2.setCodigo("02");
        sismo2.setDepartamento("Quindio");
        sismo2.setProfundidad(10F);
        sismo2.setMagnitud(10F);
        sismo2.setHoraInicio("10:00");
        sismo2.setHoraFinal("10:02");

        Sismo sismo3 = new Sismo();
        sismo1.setCiudad("Tebaida");
        sismo1.setCodigo("03");
        sismo1.setDepartamento("Quindio");
        sismo1.setProfundidad(10F);
        sismo1.setMagnitud(10F);
        sismo1.setHoraInicio("10:00");
        sismo1.setHoraFinal("10:02");

        Sismo sismo4 = new Sismo();
        sismo4.setCiudad("Tebaida");
        sismo4.setCodigo("04");
        sismo4.setDepartamento("Quindio");
        sismo4.setProfundidad(10F);
        sismo4.setMagnitud(10F);
        sismo4.setHoraInicio("10:00");
        sismo4.setHoraFinal("10:02");

        observatorio.getListaSismos().add(sismo1);
        observatorio.getListaSismos().add(sismo2);
        observatorio.getListaSismos().add(sismo3);
        observatorio.getListaSismos().add(sismo4);

        return observatorio;
    }
}
