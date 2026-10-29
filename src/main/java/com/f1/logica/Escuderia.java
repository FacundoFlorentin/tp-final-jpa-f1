package com.f1.logica;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Escuderia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String nombre;
    private String directorEquipo;
    private String nacionalidad;
    private int edad;
   
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento; // Siguiendo el ejemplo de fechaNacimiento del profesor
    

    public Escuderia() { }

    public Escuderia(String nombre, String directorEquipo, String nacionalidad, int edad) {
        this.nombre = nombre;
        this.directorEquipo = directorEquipo;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }

    // getters/setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDirectorEquipo() { return directorEquipo; }
    public void setDirectorEquipo(String directorEquipo) { this.directorEquipo = directorEquipo; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}
