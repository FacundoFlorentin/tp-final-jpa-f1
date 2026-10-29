package com.f1.persistencia;

import com.f1.logica.Escuderia;
import com.f1.logica.Piloto;
import java.util.List; // OBLIGATORIO: Import para poder usar colecciones de tipo List

public class ControladoraPersistencia {
	// Escuderia: Creamos una instancia del controlador que sabe cómo hablar con la
	// base de datos
	EscuderiaJpaController escuderiaJpa = new EscuderiaJpaController();

	// Piloto: Creamos una instancia del controlador que sabe cómo hablar con la
	// base de datos
	PilotoJpaController pilotoJpa = new PilotoJpaController();

	// Este método es el que se usa desde otras capas para crear una ESCUDERIA
	public void crearEscuderia(Escuderia escuderia) {
		// Delegamos la tarea al controlador especializado
		escuderiaJpa.crear(escuderia);
	}
	
	// Método de la capa intermedia para crear un PILOTO
	public void crearPiloto(Piloto piloto) {
		// Delegamos la tarea al controlador especializado
		pilotoJpa.crear(piloto);
	}

	// ==========================================
	// NUEVOS MÉTODOS DE LA ACTIVIDAD 15
	// ==========================================

	// BUSCAR UNA ESCUDERIA
	public Escuderia buscarEscuderia(int id) {
		return escuderiaJpa.buscarUno(id);
	}

	// BUSCAR TODAS LAS ESCUDERIAS
	public List<Escuderia> buscarTodasLasEscuderias() {
		return escuderiaJpa.buscarTodos();
	}

	// BUSCAR UN PILOTO (Lo escribimos nosotros siguiendo el mismo modelo)
	public Piloto buscarPiloto(int id) {
		return pilotoJpa.buscarUno(id);
	}

	// BUSCAR TODOS LOS PILOTOS (Lo escribimos nosotros siguiendo el mismo modelo)
	public List<Piloto> buscarTodosLosPilotos() {
		return pilotoJpa.buscarTodos();
	}
}
