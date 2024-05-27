package modelo;

import java.util.ArrayList;

/**
 * Clase que representa a un usuario registrado
 */
public class Usuario_registrado {
	private String nombre;
	private String usuario;
	private String contraseña;
	private ArrayList<Rutina> rutinas;

	/**
	 * Constructor de la clase Usuario_registrado
	 * 
	 * @param nombre     nombre del usuario
	 * @param usuario    el identificador del usuario
	 * @param contraseña la contraseña de acceso del usuario
	 * @param rutinas    las rutinas del usuario
	 */
	public Usuario_registrado(String nombre, String usuario, String contraseña, ArrayList<Rutina> rutinas) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	/**
	 * Obtiene el nombre del usuario.
	 * 
	 * @return el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario.
	 * 
	 * @param nombre el nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el identificador del usuario.
	 * 
	 * @return el identificador del usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece el identificador del usuario.
	 * 
	 * @param usuario el identificador del usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 * 
	 * @return la contraseña del usuario
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Establece la contraseña del usuario.
	 * 
	 * @param contraseña la contraseña del usuario
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	/**
	 * Metodo que retorna las rutinas del usuario
	 * @return una lista con las rutinas del usuario
	 */
	public ArrayList<Rutina> getRutinas() {
		return rutinas;
	}
	
	/**
	 * Metodo que establece una rutina del usuario
	 * 
	 * @param rutinas la rutina a establecer
	 */

	public void setRutinas(ArrayList<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	/**
	 * Obtiene la lista de ejercicios de una rutina específica.
	 * 
	 * @param rutina la rutina de la cual se quieren obtener los ejercicios
	 * @return una lista con los ejercicios de la rutina
	 */
	public ArrayList<Ejercicio> verEjercicios(Rutina rutina) {
		return rutina.getEjercicios();
	}
}
