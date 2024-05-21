package modelo;

/**
 * Clase Ejercicio
 */
public class Ejercicio {
	private String nombre;
	private String seccion;
	private String musculo;

	/**
	 * Constructor de la clase Ejercicio
	 * 
	 * @param nombre  nombre del ejercicio
	 * @param musculo nombre del músculo que trabaja
	 * @param seccion la sección del músculo que trabaja
	 */
	public Ejercicio(String nombre, String musculo, String seccion) {
		super();
		this.nombre = nombre;
		this.musculo = musculo;
		this.seccion = seccion;
	}

	/**
	 * Obtiene el nombre del ejercicio.
	 * 
	 * @return el nombre del ejercicio
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del ejercicio.
	 * 
	 * @param nombre el nuevo nombre del ejercicio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la sección del músculo que trabaja el ejercicio.
	 * 
	 * @return la sección del músculo
	 */
	public String getSeccion() {
		return seccion;
	}

	/**
	 * Establece la sección del músculo que trabaja el ejercicio.
	 * 
	 * @param seccion la nueva sección del músculo
	 */
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	/**
	 * Obtiene el nombre del músculo que trabaja el ejercicio.
	 * 
	 * @return el nombre del músculo
	 */
	public String getMusculo() {
		return musculo;
	}

	/**
	 * Establece el nombre del músculo que trabaja el ejercicio.
	 * 
	 * @param musculo el nuevo nombre del músculo
	 */
	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}
}
