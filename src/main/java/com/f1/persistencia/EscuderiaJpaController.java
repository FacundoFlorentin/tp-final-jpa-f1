package com.f1.persistencia;

import com.f1.logica.Escuderia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List; // OBLIGATORIO: Agregamos el import para las listas

public class EscuderiaJpaController {
	
	// "Fábrica" de conexiones (EntityManagerFactory).
	// Sirve para crear EntityManager, que son los que realmente hablan con la BD.
	private EntityManagerFactory emf = null;

	// En el constructor decimos con qué unidad de persistencia vamos a trabajar.
	// Esa unidad está definida en persistence.xml con el nombre "formula1_pu".
	public EscuderiaJpaController() {
		emf = Persistence.createEntityManagerFactory("formula1_pu");
	}

	// Método que crea y devuelve un nuevo "EntityManager".
	// Pensalo como: "dame un empleado que se conecte a la base para trabajar".
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// Método para guardar una Escuderia en la base de datos.
	public void crear(Escuderia esc) {
		EntityManager em = null;
		try {
			// Abrimos la conexión (pedimos un empleado).
			em = getEntityManager();
			
			// Iniciamos una transacción: empieza la "promesa".
			em.getTransaction().begin();
			
			// Guardamos el objeto en la base (pero todavía no está confirmado).
			em.persist(esc);
			
			// Confirmamos la transacción: ahora sí el objeto queda guardado.
			em.getTransaction().commit();
		} finally {
			// Cerramos la conexión (el empleado ya no hace falta).
			if (em != null) {
				em.close();
			}
		}
	}

	// ==========================================
	// NUEVOS MÉTODOS DE LA ACTIVIDAD 15
	// ==========================================

	// BUSCAR UNO: busca una escudería por su id.
	// No hace falta transacción porque no modifica nada en la base.
	public Escuderia buscarUno(int id) {
		EntityManager em = getEntityManager();
		try {
			// find busca por clave primaria. Si no existe, devuelve null.
			return em.find(Escuderia.class, id);
		} finally {
			em.close();
		}
	}

	// BUSCAR TODOS: devuelve una lista con todas las escuderías.
	public List<Escuderia> buscarTodos() {
		EntityManager em = getEntityManager();
		try {
			// Consulta JPQL: "traeme todos los objetos Escuderia"
			return em.createQuery("SELECT e FROM Escuderia e", Escuderia.class)
					.getResultList();
		} finally {
			em.close();
		}
	}
}
