package com.example.seguimiento14;
import java.util.Date;
public class Dato {

    private Date date;
    private String descripcion;
    private double monto;
    private Type tipo;

    public Dato(String descripcion, double monto, Type tipo, Date date) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.tipo = tipo;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMonto() {
        return monto;
    }

    public Type getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
