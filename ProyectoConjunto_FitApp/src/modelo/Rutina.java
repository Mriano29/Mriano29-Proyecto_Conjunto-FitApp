package modelo;

import java.util.ArrayList;

/**
 * Clase Rutina
 */
public class Rutina {
	private ArrayList<Ejercicio> ejercicios;

	/**
	 * Constructor de la clase Rutina
	 * 
	 * @param ejercicios la lista de ejercicios de la rutina
	 */
	public Rutina(ArrayList<Ejercicio> ejercicios) {
		super();
		this.ejercicios = ejercicios;
	}

	/**
	 * Obtiene la lista de ejercicios de la rutina.
	 * 
	 * @return una lista con los ejercicios de la rutina
	 */
	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	/**
	 * Establece la lista de ejercicios de la rutina.
	 * 
	 * @param ejercicios la nueva lista de ejercicios de la rutina
	 */
	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	/**
	 * Añade un ejercicio a la rutina.
	 * 
	 * @param ejercicio el ejercicio a añadir
	 */
	public void añadirEjercicioRutina(Ejercicio ejercicio) {
		this.ejercicios.add(ejercicio);
	}

	/**
	 * Elimina un ejercicio de la rutina.
	 * 
	 * @param ejercicio el ejercicio a eliminar
	 */
	public void eliminarEjercicioRutina(Ejercicio ejercicio) {
		this.ejercicios.remove(ejercicio);
	}
}
