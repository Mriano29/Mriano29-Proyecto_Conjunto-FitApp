package gui;

import javax.swing.JFrame;

/**
 * Clase ventana principal hereda de JFrame
 */
public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase Ventana principal
	 */
	public VentanaPrincipal() {
		crearVentana();
	}

	/**
	 * Metodo que inicializa los parametros la ventana
	 */
	private void crearVentana() {
		this.setSize(500, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("FitApp");
	}
}