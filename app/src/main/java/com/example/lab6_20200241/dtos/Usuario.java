package com.example.lab6_20200241.dtos;

import java.util.Arrays;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellido;
    private List<String> Ingreso;

    private List<String> Egreso;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, List<String> ingreso, List<String> egreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        Ingreso = ingreso;
        Egreso = egreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getIngreso() {
        return Ingreso;
    }

    public void setIngreso(List<String> ingreso) {
        Ingreso = ingreso;
    }

    public List<String> getEgreso() {
        return Egreso;
    }

    public void setEgreso(List<String> egreso) {
        Egreso = egreso;
    }
}
