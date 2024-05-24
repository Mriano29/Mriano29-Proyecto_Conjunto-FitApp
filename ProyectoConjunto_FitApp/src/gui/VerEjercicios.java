package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Ejercicio;
import modelo.Gestor;
import java.awt.List;
import javax.swing.JComboBox;

public class VerEjercicios extends EstructuraPanel {

	private static final long serialVersionUID = 1L;
	ArrayList<Ejercicio> ejercicios;

	public VerEjercicios() {
		contenido();
		contenidoFooter();
	}

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
			JComboBox<String> comboBox = new JComboBox<String>();
			comboBox.setBounds(360, 428, 110, 20);
			add(comboBox);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(360, 458, 110, 21);
			add(btnNewButton);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
