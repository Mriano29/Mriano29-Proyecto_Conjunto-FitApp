package main;

import gui.ControlPaneles;

/**
 * Clase principal de la aplicacion
 */
public class FitAppMain {
	/**
	 * Metodo main de la clase FitAppMain
	 * 
	 * @param args parámetros por defecto del metodo main
	 */
	public static void main(String[] args) {
		iniciar();
	}

	/**
	 * Metodo que inicia la ventana de la aplicacion
	 */
	private static void iniciar() {
		ControlPaneles control = new ControlPaneles() {
		};
		control.mostrarVentana();
	}
}
