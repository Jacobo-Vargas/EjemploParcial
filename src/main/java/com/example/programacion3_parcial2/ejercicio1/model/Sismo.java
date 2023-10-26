package com.example.programacion3_parcial2.ejercicio1.model;

import java.io.Serial;
import java.io.Serializable;

public class Sismo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String departamento;
    private String ciudad;
    private String horaInicio;
    private String horaFinal;
    private Float magnitud;
    private Float profundidad;

    public Sismo() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Float getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(Float magnitud) {
        this.magnitud = magnitud;
    }

    public Float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }


}
