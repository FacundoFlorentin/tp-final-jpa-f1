package com.f1.presentacion;

import com.f1.logica.Escuderia;
import com.f1.logica.Piloto;
import com.f1.logica.ControladoraLogica;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		// INSTANCIAR DOS ESCUDERIAS (Pasamos: nombre, directorEquipo, nacionalidad, edad)
		Escuderia ferrari = new Escuderia("Ferrari", "Frédéric Vasseur", "Francia", 58);
		Escuderia mercedes = new Escuderia("Mercedes", "Toto Wolff", "Austria", 60);

		// INSTANCIAR DOS PILOTOS (Pasamos: nombre, tiempoVuelta, numeroCarro)
		Piloto leclerc = new Piloto("Charles Leclerc", 1.26f, 16);
		Piloto norris = new Piloto("Kimi Antonelli", 1.24f, 12);

		ControladoraLogica conLog = new ControladoraLogica();
		
		try {
			// CREAR AL MENOS DOS ESCUDERIAS, Y DOS PILOTOS
			conLog.crearEscuderia(ferrari);
			conLog.crearEscuderia(mercedes);
			System.out.println("OK. Escuderías creadas con éxito.");

			conLog.crearPiloto(leclerc);
			conLog.crearPiloto(norris);
			System.out.println("OK. Pilotos creados con éxito.");
			
		} catch (Exception e) {
			System.out.println("No se pudo crear el elemento: " + e.getMessage());
		}
	}
}
