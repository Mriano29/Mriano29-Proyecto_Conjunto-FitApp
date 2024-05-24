package gui;

import modelo.Usuario_registrado;

/**
 * Clase EstadoSesion indica si un usuario ha iniciado sesion o no a la interfaz
 */
public class EstadoSesion {
	private static boolean estadoSesion = false;
	private static Usuario_registrado usuario_activo = null;

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

	/**
	 * Metodo que retorna el usuario activo en la aplicacion
	 * 
	 * @return el usuario activo
	 */
	public static Usuario_registrado getUsuario_activo() {
		return usuario_activo;
	}

	/**
	 * Metodo que establece el usuario activo en la aplicacion
	 * 
	 * @param usuario_activo el usuario activo
	 */
	public static void setUsuario_activo(Usuario_registrado usuario_activo) {
		EstadoSesion.usuario_activo = usuario_activo;
	}
}
