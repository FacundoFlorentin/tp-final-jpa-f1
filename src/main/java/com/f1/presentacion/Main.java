package com.f1.presentacion;

import com.f1.logica.Escuderia;
import com.f1.logica.Piloto;
import com.f1.logica.ControladoraLogica;

import java.util.List; // OBLIGATORIO: Import para poder usar las listas de lectura

public class Main {
	public static void main(String[] args) {
		// INSTANCIAR DOS ESCUDERIAS 
		Escuderia ferrari = new Escuderia("Ferrari", "Frédéric Vasseur", "Francia", 0);
		Escuderia mercedes = new Escuderia("Mercedes", "Toto Wolff", "Austria", 0);

		// INSTANCIAR DOS PILOTOS 
		Piloto leclerc = new Piloto("Charles Leclerc", 1.26f, 16);
		Piloto antonelli = new Piloto("Kimi Antonelli", 1.24f, 12);

		ControladoraLogica conLog = new ControladoraLogica();
		
		try {
			// CREAR AL MENOS DOS ESCUDERIAS, Y DOS PILOTOS
			conLog.crearEscuderia(ferrari);
			conLog.crearEscuderia(mercedes);
			System.out.println("OK. Escuderías creadas con éxito.");

			conLog.crearPiloto(leclerc);
			conLog.crearPiloto(antonelli);
			System.out.println("OK. Pilotos creados con éxito.");
			
		} catch (Exception e) {
			System.out.println("No se pudo crear el elemento: " + e.getMessage());
		}

		// ==========================================
		// NUEVO CÓDIGO DE LA ACTIVIDAD 15 (LECTURA)
		// ==========================================

		// ----- LECTURA DE ESCUDERIAS -----
		System.out.println("\n=== TODAS LAS ESCUDERIAS ===");
		List<Escuderia> escuderias = conLog.listarEscuderias();
		for (Escuderia e : escuderias) {
			System.out.println(e);
		}

		System.out.println("\n=== BUSCAR ESCUDERIA CON ID 1 ===");
		Escuderia escEncontrada = conLog.buscarUnaEscuderia(1);
		if (escEncontrada != null) {
			System.out.println(escEncontrada);
		} else {
			System.out.println("No existe una escudería con ese id");
		}

		System.out.println("\n=== BUSCAR ESCUDERIA CON ID 999 ===");
		Escuderia escNoExiste = conLog.buscarUnaEscuderia(999);
		if (escNoExiste != null) {
			System.out.println(escNoExiste);
		} else {
			System.out.println("No existe una escudería con ese id");
		}

		// ----- LECTURA DE PILOTOS -----
		// (Lo escribimos nosotros siguiendo el mismo modelo exacto)
		System.out.println("\n=== TODOS LOS PILOTOS ===");
		List<Piloto> pilotos = conLog.listarPilones();
		for (Piloto p : pilotos) {
			System.out.println(p);
		}

		System.out.println("\n=== BUSCAR PILOTO CON ID 1 ===");
		Piloto pilEncontrado = conLog.buscarUnPiloto(1);
		if (pilEncontrado != null) {
			System.out.println(pilEncontrado);
		} else {
			System.out.println("No existe un piloto con ese id");
		}

		System.out.println("\n=== BUSCAR PILOTO CON ID 999 ===");
		Piloto pilNoExiste = conLog.buscarUnPiloto(999);
		if (pilNoExiste != null) {
			System.out.println(pilNoExiste);
		} else {
			System.out.println("No existe un piloto con ese id");
		}
	}
}
