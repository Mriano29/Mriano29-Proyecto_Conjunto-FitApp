package modelo;

import java.util.ArrayList;

/**
 * Clase Rutina
 */
public class Rutina {
	private int ID;
	private ArrayList<Ejercicio> ejercicios;

	/**
	 * Constructor de la clase Rutina
	 * 
	 * @param iD el id de la rutina
	 * @param ejercicios la lista de ejercicios de la rutina
	 */
	public Rutina(int ID, ArrayList<Ejercicio> ejercicios) {
		super();
		this.ID = ID;
		this.ejercicios = ejercicios;
	}

	/**
	 * Metodo que retorna el ID de una rutina
	 * 
	 * @return el id de la rutina
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Metodo que cambia el ID de una rutina
	 * 
	 * @param iD el nuevo ID de la rutina
	 */
	public void setID(int iD) {
		ID = iD;
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
