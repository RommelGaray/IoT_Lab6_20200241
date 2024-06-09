package com.example.lab6_20200241.dtos;

import java.util.Arrays;

public class Usuario {
    private String nombre;
    private String apellido;
    private Arrays Ingreso;

    private Arrays Egreso;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, Arrays ingreso, Arrays egreso) {
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

    public Arrays getIngreso() {
        return Ingreso;
    }

    public void setIngreso(Arrays ingreso) {
        Ingreso = ingreso;
    }

    public Arrays getEgreso() {
        return Egreso;
    }

    public void setEgreso(Arrays egreso) {
        Egreso = egreso;
    }
}
