package gui;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Gestor;
import modelo.Rutina;

public class GestionarRutinas extends EstructuraPanel {

	private static final long serialVersionUID = 1L;
	ArrayList<Integer> rutinas = new ArrayList<Integer>();

	public GestionarRutinas() {
		contenido();
		contenidoFooter();
	}

	private void contenido() {
		List listaEjercicios = new List();
		listaEjercicios.setBounds(10, 106, 460, 296);
		add(listaEjercicios);
		
		JButton agregarRutina = new JButton("Agregar rutina");
		agregarRutina.setBounds(40, 420, 192, 75);
		add(agregarRutina);
		
		JButton eliminarRutina = new JButton("Eliminar rutina");
		eliminarRutina.setBounds(40, 505, 192, 85);
		add(eliminarRutina);
		
		JButton agregarEjercicio = new JButton("Agregar ejercicio");
		agregarEjercicio.setBounds(242, 420, 192, 75);
		add(agregarEjercicio);
		
		JButton eliminarEjercicio = new JButton("Eliminar ejercicio");
		eliminarEjercicio.setBounds(242, 505, 192, 85);
		add(eliminarEjercicio);
		Gestor gestor = new Gestor() {
		};
		try {
			rutinas = gestor.rutinas(EstadoSesion.getUsuario_activo().getUsuario());
			if(rutinas.size() != 0) {
				for (int i = 0; i < rutinas.size(); i++) {
					listaEjercicios.add("Rutina " + (i + 1) + " ID: " + rutinas.get(i));
				}
			}else {
				listaEjercicios.add("No hay rutinas añadidas");
			}
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
