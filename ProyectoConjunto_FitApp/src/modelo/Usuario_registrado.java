package modelo;

import java.util.ArrayList;

public class Usuario_registrado extends Usuario {
	private String usuario;
	private String contraseña;
	private ArrayList<Rutina> rutinas;

	public Usuario_registrado(String nombre, int edad, Double peso, Double altura, String usuario, String contraseña,
			ArrayList<Rutina> rutinas) {
		super(nombre, edad, peso, altura);
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.rutinas = rutinas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public ArrayList<Rutina> getRutinas() {
		return rutinas;
	}

	public void setRutinas(ArrayList<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public void crearRutina() {
		ArrayList<Ejercicio> lista_ejercicios_vacia = new ArrayList<Ejercicio>();
		Rutina nueva_rutina = new Rutina(lista_ejercicios_vacia);
		rutinas.add(nueva_rutina);
	}

	public void eliminarRutina(Rutina rutina_eliminar) {
		rutinas.remove(rutina_eliminar);
	}

	public ArrayList<Ejercicio> verEjercicios(Rutina rutina) {
		return rutina.getEjercicios();
	}
}
