package com.f1.logica;

import com.f1.persistencia.ControladoraPersistencia;

public class ControladoraLogica {

	// La controladora de persistencia se encarga de hablar con la BD.
	// Desde aquí la usamos como "puente" para guardar datos.
	ControladoraPersistencia controlPersis = new ControladoraPersistencia();

	// ----- ESCUDERIA -----
	// Método de la capa lógica para crear una escudería.
	// Antes de guardarla en la BD, se hacen validaciones.
	public void crearEscuderia(Escuderia esc) throws Exception {
		// Validación: la escudería debe tener un nombre
		if (esc.getNombre() == null || esc.getNombre().isEmpty()) {
			throw new Exception("La escudería debe tener un nombre.");
		}
		// Validación: la escudería debe tener un director de equipo
		if (esc.getDirectorEquipo() == null || esc.getDirectorEquipo().isEmpty()) {
			throw new Exception("La escudería debe tener un director de equipo.");
		}
		// Validación: la edad de fundación o registro debe ser positiva
		if (esc.getEdad() <= 0) {
			throw new Exception("La edad de la escudería debe ser mayor a 0.");
		}

		// VALIDACIÓN MÁS AGREGADA: El nombre del país de origen no puede estar vacío
		if (esc.getNacionalidad() == null || esc.getNacionalidad().isEmpty()) {
			throw new Exception("La nacionalidad de la escudería es obligatoria.");
		}
		
		// Si pasa todas las validaciones, recién ahí se manda a la persistencia
		controlPersis.crearEscuderia(esc);
	}

	// ----- PILOTO -----
	// Método de la capa lógica para crear un piloto.
	// Se valida que tenga datos coherentes antes de persistirla.
	public void crearPiloto(Piloto pil) throws Exception {
		// Validación: el nombre no puede estar vacío
		if (pil.getNombre() == null || pil.getNombre().isEmpty()) {
			throw new Exception("El piloto debe tener un nombre.");
		}
		// Validación: el tiempo de vuelta debe ser mayor a cero
		if (pil.getTiempoVuelta() <= 0) {
			throw new Exception("El tiempo de vuelta debe ser mayor a 0 segundos.");
		}
		// Validación: el número de carro debe tener sentido (mayor a cero)
		if (pil.getNumeroCarro() <= 0) {
			throw new Exception("El número de monoplaza debe ser válido.");
		}
		
		// VALIDACIÓN MÁS AGREGADA: Un piloto no puede correr con un número mayor al 99 (regla FIA)
		if (pil.getNumeroCarro() > 99) {
			throw new Exception("El número de monoplaza no puede ser mayor a 99.");
		}

		// Si pasa todas las validaciones, se guarda en la base de datos
		controlPersis.crearPiloto(pil);
	}
}
