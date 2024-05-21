package gui;

/**
 * Clase EstadoSesion indica si un usuario ha iniciado sesion o no a la interfaz
 */
public class EstadoSesion {
	protected static boolean estadoSesion = false;

	/**
	 * Metodo que retorna el estado de la sesion de un usuario
	 * 
	 * @return true si ha iniciado, false en caso contrario
	 */
	public static boolean isEstado() {
		return estadoSesion;
	}

	/**
	 * Metodo que cambia el estado de la sesion de un usuario
	 * 
	 * @param estado el nuevo estado de la sesión
	 */
	public static void setEstado(boolean estado) {
		estadoSesion = estado;
	}
}
