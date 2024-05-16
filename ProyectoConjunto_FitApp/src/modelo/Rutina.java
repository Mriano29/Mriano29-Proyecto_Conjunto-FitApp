package modelo;

import java.util.ArrayList;

public class Rutina {
	private ArrayList<Ejercicio> ejercicios;

	public Rutina(ArrayList<Ejercicio> ejercicios) {
		super();
		this.ejercicios = ejercicios;
	}

	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	
	public void añadirEjercicioRutina(Ejercicio ejercicio){
		this.ejercicios.add(ejercicio);
	}
	
	public void eliminarEjercicioRutina(Ejercicio ejercicio) {
		this.ejercicios.remove(ejercicio);
	}
}
