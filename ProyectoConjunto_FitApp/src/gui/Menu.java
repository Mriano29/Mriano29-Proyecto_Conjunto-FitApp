package gui;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase Menu es una especializacion de EstructuraPanel
 */
public class Menu extends EstructuraPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase Menu
	 */
	public Menu() {
		cargarContenido();
	}

	/**
	 * Metodo que carga el contenido en el panel
	 */
	private void cargarContenido() {
		cargarBotonEjercicios();
		cargarBotonGestionarRutinas();
		cargarBotonGestionarDatos();
		cargarImagen();
		cargarContenidoHeader();
	}

	/**
	 * Metodo que carga una imagen en el panel
	 */
	private void cargarImagen() {
		String ruta = "./src/imagenes/portada.jpg";
		Imagen panelImagen = new Imagen(ruta);
		panelImagen.setBounds(200, 150, 250, 400);
		add(panelImagen);
	}

	/**
	 * Carga el boton de gestionar datos
	 */
	private void cargarBotonGestionarDatos() {
		JButton gestionarDatos = new JButton("Gestionar datos");
		gestionarDatos.setBounds(20, 450, 160, 100);
		add(gestionarDatos);
		gestionarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EstadoSesion.isEstado()) {
					ControlPaneles control = new ControlPaneles() {
					};
					GestionarDatos datos = new GestionarDatos();
					control.cambiarPagina(panelActual, datos);
				}else {
					JOptionPane.showMessageDialog(null, "Debes iniciar sesion para usar esta función");
				}
			}
		});
	}

	/**
	 * Carga el boton de gestionar rutinas
	 */
	private void cargarBotonGestionarRutinas() {
		JButton gestionarRutinas = new JButton("Gestionar Rutinas");
		gestionarRutinas.setBounds(20, 300, 160, 100);
		add(gestionarRutinas);
		gestionarRutinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EstadoSesion.isEstado()) {
					ControlPaneles control = new ControlPaneles() {
					};
					GestionarRutinas rutinas = new GestionarRutinas();
					control.cambiarPagina(panelActual, rutinas);
				}else {
					JOptionPane.showMessageDialog(null, "Debes iniciar sesion para usar esta función");
				}
			}
		});
	}

	/**
	 * Carga el boton de gestionar ejercicios
	 */
	private void cargarBotonEjercicios() {
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
	}

	/**
	 * Carga el contenido del header
	 */
	private void cargarContenidoHeader() {
		cargarBotonInicioSesion();
	}
	
	/**
	 * Carga el boton de inicio de sesion
	 */
	private void cargarBotonInicioSesion() {
		JButton sesion;
		if (EstadoSesion.isEstado()) {
			sesion = new JButton("Cerrar sesión");
			sesion.setBounds(332, 35, 120, 25);
			header.add(sesion);
		} else {
			sesion = new JButton("Iniciar sesión");
			sesion.setBounds(332, 35, 120, 25);
			header.add(sesion);
		}
		sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlPaneles control = new ControlPaneles() {
				};
				if (sesion.getText().equals("Cerrar sesión")) {
					EstadoSesion.setEstado(false);
					control.cambiarPagina(panelActual, panelActual);
				} else {
					InicioSesion inicioSesion = new InicioSesion();
					control.cambiarPagina(panelActual, inicioSesion);
				}
			}
		});
	}
}
