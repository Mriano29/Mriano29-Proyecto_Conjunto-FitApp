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
		this.rutinas = rutinas;
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
	 * Obtiene las rutinas del usuario.
	 * 
	 * @return una lista con las rutinas del usuario
	 */
	public ArrayList<Rutina> getRutinas() {
		return rutinas;
	}

	/**
	 * Establece las rutinas del usuario.
	 * 
	 * @param rutinas una lista con las rutinas del usuario
	 */
	public void setRutinas(ArrayList<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	/**
	 * Crea una nueva rutina vacía y la añade a la lista de rutinas del usuario.
	 */
	public void crearRutina() {
		ArrayList<Ejercicio> lista_ejercicios_vacia = new ArrayList<Ejercicio>();
		Rutina nueva_rutina = new Rutina(lista_ejercicios_vacia);
		rutinas.add(nueva_rutina);
	}

	/**
	 * Elimina una rutina específica de la lista de rutinas del usuario.
	 * 
	 * @param rutina_eliminar la rutina a eliminar
	 */
	public void eliminarRutina(Rutina rutina_eliminar) {
		rutinas.remove(rutina_eliminar);
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
