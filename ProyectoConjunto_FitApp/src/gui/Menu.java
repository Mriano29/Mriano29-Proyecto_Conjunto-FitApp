package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends EstructuraPanel {
	private static final long serialVersionUID = 1L;

	public Menu() {
		cargarContenido();
	}

	private void cargarContenido() {
		JButton verEjercicios = new JButton("Ver Ejercicios");
		verEjercicios.setBounds(20, 150, 160, 100);
		add(verEjercicios);
		verEjercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlPaneles control = new ControlPaneles() {
				};
				VerEjercicios ejercicios = new VerEjercicios();
				control.cambiarPagina(panelActual, ejercicios);
			}
		});

		JButton gestionarRutinas = new JButton("Gestionar Rutinas");
		gestionarRutinas.setBounds(20, 300, 160, 100);
		add(gestionarRutinas);
		gestionarRutinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlPaneles control = new ControlPaneles() {
				};
				GestionarRutinas rutinas = new GestionarRutinas();
				control.cambiarPagina(panelActual, rutinas);
			}
		});

		JButton gestionarDatos = new JButton("Gestionar datos");
		gestionarDatos.setBounds(20, 450, 160, 100);
		add(gestionarDatos);
		gestionarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlPaneles control = new ControlPaneles() {
				};
				GestionarDatos datos = new GestionarDatos();
				control.cambiarPagina(panelActual, datos);
			}
		});

		JPanel panelImagen = new JPanel();
		panelImagen.setBounds(200, 150, 250, 400);
		add(panelImagen);

		cargarContenidoHeader();
	}

	private void cargarContenidoHeader() {
//		JButton sesion;
//		if (EstadoSesion.sesion.isEstado()) {
//			sesion = new JButton("Cerrar sesión");
//			sesion.setBounds(332, 35, 120, 25);
//			header.add(sesion);
//		} else {
//			sesion = new JButton("Iniciar sesión");
//			sesion.setBounds(332, 35, 120, 25);
//			header.add(sesion);
//		}
//		sesion.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ControlPaneles control = new ControlPaneles() {
//				};
//				if (sesion.getText().equals("Cerrar sesión")) {
//					EstadoSesion.sesion.setEstado(false);
//					control.cambiarPagina(panelActual, panelActual);
//				} else {
//					InicioSesion inicioSesion = new InicioSesion();
//					control.cambiarPagina(panelActual, inicioSesion);
//				}
//			}
//		});

	}
}
