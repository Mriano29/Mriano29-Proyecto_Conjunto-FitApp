package modelo;

import java.util.ArrayList;

public class Musculo {
	private String nombre;
	private ArrayList<Musculo> musculos = new ArrayList<Musculo>();

	public Musculo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Musculo> getMusculos() {
		return musculos;
	}

	public void setMusculos(ArrayList<Musculo> musculos) {
		this.musculos = musculos;
	}

}
