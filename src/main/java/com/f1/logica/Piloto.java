package com.f1.logica;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Piloto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String nombre;
    private float tiempoVuelta; 
    private int numeroCarro;

    public Piloto() { }

    public Piloto(String nombre, float tiempoVuelta, int numeroCarro) {
        this.nombre = nombre;
        this.tiempoVuelta = tiempoVuelta;
        this.numeroCarro = numeroCarro;
    }

    // getters/setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public float getTiempoVuelta() { return tiempoVuelta; }
    public void setTiempoVuelta(float tiempoVuelta) { this.tiempoVuelta = tiempoVuelta; }
    public int getNumeroCarro() { return numeroCarro; }
    public void setNumeroCarro(int numeroCarro) { this.numeroCarro = numeroCarro; }
    @Override
    public String toString() {
        return "PILOTO: \n" + "ID: " + getId() + "\nNombre: " + getNombre()
                + "\nTiempo de vuelta: " + getTiempoVuelta()
                + "\nNumero de carro: " + getNumeroCarro();
    }
}