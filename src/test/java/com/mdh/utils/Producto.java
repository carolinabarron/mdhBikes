package com.mdh.utils;

public class Producto {
    public Producto() {
    }

    String nombre;
    String descripcion;
    double precio;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }


    public Producto(String nombre, String descripcion, double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;

    }


}
