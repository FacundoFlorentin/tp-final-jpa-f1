package com.f1.persistencia;

import com.f1.logica.Piloto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List; // OBLIGATORIO: Agregamos el import para las listas

public class PilotoJpaController {
	
	// "Fábrica" de conexiones con la base de datos.
	// Nos permite crear EntityManager, que son los que realmente hacen el trabajo.
	private EntityManagerFactory emf = null;

	// En el constructor indicamos qué unidad de persistencia usar.
	// El nombre "formula1_pu" debe coincidir con el que está en persistence.xml.
	public PilotoJpaController() {
		emf = Persistence.createEntityManagerFactory("formula1_pu");
	}

	// Método que devuelve un nuevo EntityManager (una conexión lista para trabajar).
	// Podés pensarlo como: "dame un empleado que se conecte a la BD".
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// Método para crear (persistir) un Piloto en la base de datos.
	public void crear(Piloto pil) {
		EntityManager em = null;
		try {
			// Abrimos la conexión (traemos al empleado).
			em = getEntityManager();
			
			// Iniciamos la transacción (arranca la promesa de que se hará todo o nada).
			em.getTransaction().begin();
			
			// Guardamos el objeto Piloto en la base (todavía no confirmado).
			em.persist(pil);
			
			// Confirmamos la transacción: ahora sí, el dato queda guardado en la BD.
			em.getTransaction().commit();
		} finally {
			// Cerramos la conexión si estaba abierta (el empleado termina su turno).
			if (em != null) {
				em.close();
			}
		}
	}

	// ==========================================
	// NUEVOS MÉTODOS DE LA ACTIVIDAD 15
	// ==========================================

	// BUSCAR UNO: busca un piloto por su id.
	// No hace falta transacción porque no modifica nada en la base.
	public Piloto buscarUno(int id) {
		EntityManager em = getEntityManager();
		try {
			// find busca por clave primaria. Si no existe, devuelve null.
			return em.find(Piloto.class, id);
		} finally {
			em.close();
		}
	}

	// BUSCAR TODOS: devuelve una lista con todos los pilotos.
	public List<Piloto> buscarTodos() {
		EntityManager em = getEntityManager();
		try {
			// Consulta JPQL: "traeme todos los objetos Piloto"
			return em.createQuery("SELECT p FROM Piloto p", Piloto.class)
					.getResultList();
		} finally {
			em.close();
		}
	}
}