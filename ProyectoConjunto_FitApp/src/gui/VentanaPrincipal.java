package gui;

import javax.swing.JFrame;

/**
 * Clase ventana principal
 */
public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {
		crearVentana();
	}

	private void crearVentana() {
		this.setSize(500, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("FitApp");
	}
}