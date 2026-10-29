package com.f1.persistencia;

import com.f1.logica.Escuderia;
import com.f1.logica.Piloto;

public class ControladoraPersistencia {
	// Escuderia: Creamos una instancia del controlador que sabe cómo hablar con la
	// base de datos
	EscuderiaJpaController escuderiaJpa = new EscuderiaJpaController();

	// Piloto: Creamos una instancia del controlador que sabe cómo hablar con la
	// base de datos
	// INSTANCIAR OBJETO DE PILOTOJPACONTROLER AL IGUAL QUE SE HIZO CON ARTISTA
	PilotoJpaController pilotoJpa = new PilotoJpaController();

	// Este método es el que se usa desde otras capas para crear una ESCUDERIA
	public void crearEscuderia(Escuderia escuderia) {
		// Delegamos la tarea al controlador especializado
		escuderiaJpa.crear(escuderia);
	}
	
	// AL IGUAL QUE CON ARTISTA, GENERAR EL MÉTODO “crearCancion()” (crearPiloto)
	public void crearPiloto(Piloto piloto) {
		// Delegamos la tarea al controlador especializado
		pilotoJpa.crear(piloto);
	}
}
