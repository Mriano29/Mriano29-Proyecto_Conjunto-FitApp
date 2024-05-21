package gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Imagen extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image imagen;

	public Imagen(String ruta) {
		this.imagen = new ImageIcon(ruta).getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagen != null) {
			int ancho = getWidth();
			int alto = getHeight();
			g.drawImage(imagen, 0, 0, ancho, alto, this);
		}
	}
}
