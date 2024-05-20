package gui;

import javax.swing.JPanel;

/**
 * Interfaz ControlPaneles mantiene la ventana principal y su comportamiento
 */
public interface ControlPaneles {
	VentanaPrincipal ventana = new VentanaPrincipal();
	
	/**
	 * Metodo que añade el primer panel a la ventana
	 */
	public default void mostrarVentana() {
		Menu menu = new Menu();
		ventana.setVisible(true);
		ventana.add(menu);
	}
	
	/**
	 * Metodo que cambia el panel que se muestra en la ventana
	 * 
	 * @param quitar el panel a quitar
	 * @param poner el panel a mostrar
	 */
	public default void cambiarPagina(JPanel quitar, JPanel poner) {
		ventana.remove(quitar);
		ventana.add(poner);
		ventana.revalidate();
	}
}
