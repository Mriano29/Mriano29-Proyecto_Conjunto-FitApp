package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Ejercicio;
import modelo.Gestor;
import java.awt.List;

/**
 * Clase VerEjercicios es una especializacion de EstructuraPanel, muestra todos
 * los ejercicios en la base de datos
 */
public class VerEjercicios extends EstructuraPanel {

	private static final long serialVersionUID = 1L;
	ArrayList<Ejercicio> ejercicios;

	/**
	 * Constructor de la clase VerEjercicios
	 */
	public VerEjercicios() {
		contenido();
		contenidoFooter();
	}

	/**
	 * Metodo que inicializa el contenido principal del panel
	 */
	private void contenido() {
		List listaEjercicios = new List();
		listaEjercicios.setBounds(10, 106, 460, 296);
		add(listaEjercicios);
		Gestor gestor = new Gestor() {
		};
		try {
			ejercicios = gestor.obtenerEjercicios();
			for (int i = 0; i < ejercicios.size(); i++) {
				listaEjercicios.add(ejercicios.get(i).toString());
			}
			gestor.desconectar();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException a) {
			a.printStackTrace();
		}
	}

	/**
	 * Metodo que carga el contenido del footer del panel
	 */
	private void contenidoFooter() {
		JButton atras = new JButton("Volver");
		atras.setBounds(10, 20, 90, 25);
		footer.add(atras);
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlPaneles control = new ControlPaneles() {
				};
				Menu menu = new Menu();
				control.cambiarPagina(panelActual, menu);
			}
		});
	}
}
