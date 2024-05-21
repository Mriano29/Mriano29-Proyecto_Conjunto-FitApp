package gui;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * Clase EstructuraPanel hereda de JPanel
 */
public class EstructuraPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	protected JPanel header;
	protected JPanel footer;
	protected final JPanel panelActual = this;

	/**
	 * Constructor de la clase EstructuraPanel
	 */
	public EstructuraPanel() {
		crearPanel();
	}

	/**
	 * Metodo genera un panel en la parte inferior del panel principal
	 */
	private void crearFooter() {
		footer = new JPanel();
		footer.setLayout(null);
		footer.setBounds(0, 600, 500, 100);
		Color color = new Color(50, 141, 218);
		footer.setBackground(color);
		add(footer);
	}

	/**
	 * Metodo genera un panel en la parte superior del panel principal
	 */
	private void crearHeader() {
		header = new JPanel();
		header.setLayout(null);
		header.setBounds(0, 0, 500, 100);
		Color color = new Color(0, 141, 218);
		header.setBackground(color);
		add(header);
	}

	/**
	 * Metodo que genera un panel como contenedor principal de la aplicacion
	 */
	private void crearPanel() {
		this.setLayout(null);
		this.setSize(500, 700);
		Color color = new Color(65, 201, 226);
		this.setBackground(color);
		crearHeader();
		crearFooter();
	}
}
