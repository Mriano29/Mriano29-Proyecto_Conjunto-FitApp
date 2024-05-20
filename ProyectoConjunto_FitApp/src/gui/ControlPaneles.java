package gui;

import javax.swing.JPanel;

public interface ControlPaneles {
	VentanaPrincipal ventana = new VentanaPrincipal();

	public default void mostrarVentana() {
		InicioSesion inicio = new InicioSesion();
		ventana.setVisible(true);
		ventana.add(inicio);
	}

	public default void cambiarPagina(JPanel quitar, JPanel poner) {
		ventana.remove(quitar);
		ventana.add(poner);
		ventana.revalidate();
	}
}
