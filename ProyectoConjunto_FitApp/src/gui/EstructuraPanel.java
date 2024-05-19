package gui;

import java.awt.Color;
import javax.swing.JPanel;

public class EstructuraPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public EstructuraPanel() {
		crearPanel();
	}
	
	private void crearFooter() {
		JPanel footer = new JPanel();
		footer.setLayout(null);
		footer.setBounds(0, 600, 500, 100);
		Color color = new Color(247, 238, 221);
		footer.setBackground(color);
		add(footer);
	}

	private void crearHeader() {
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBounds(0, 0, 500, 100);
		Color color = new Color(0, 141, 218);
		header.setBackground(color);
		add(header);
	}

	private void crearPanel() {
		this.setLayout(null);
		this.setSize(500, 700);
		Color color = new Color(65, 201, 226);
		this.setBackground(color);
		crearHeader();
		crearFooter();
	}
}
