package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase InicioSesion es una especializacion de EstructuraPanel
 */
public class InicioSesion extends EstructuraPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase InicioSesion
	 */
	public InicioSesion() {
		super();
		cargarContenido();
	}

	/**
	 * Metodo que introduce el contenido en el panel principal
	 */
	private void cargarContenido() {
		cargarContenidoInicioSesion();
		cargarContenidoRegistro();
		contenidoFooter();
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

	/**
	 * Metodo que contiene los componentes relacionados al registro del usuario
	 */
	private void cargarContenidoRegistro() {
		JLabel registro = new JLabel("¿No tienes cuenta? Registrate aqui");
		registro.setBounds(90, 360, 266, 25);
		registro.setFont(new Font("Arial", Font.BOLD, 16));
		add(registro);

		JButton registrarse = new JButton("Registrarse");
		registrarse.setBounds(180, 400, 100, 25);
		add(registrarse);
		
		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlPaneles control = new ControlPaneles() {
				};
				Registrarse registro = new Registrarse();
				control.cambiarPagina(panelActual, registro);
			}
		});
	}

	/**
	 * Metodo que contiene los componentes relacionados con el inicio de sesion
	 */
	private void cargarContenidoInicioSesion() {
		JLabel usuario = new JLabel("Usuario:");
		usuario.setBounds(120, 180, 70, 20);
		usuario.setFont(new Font("Arial", Font.BOLD, 16));
		add(usuario);

		JTextField campoUsuario = new JTextField();
		campoUsuario.setBounds(200, 180, 100, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		JLabel contraseña = new JLabel("Contraseña:");
		contraseña.setBounds(90, 235, 100, 20);
		contraseña.setFont(new Font("Arial", Font.BOLD, 16));
		add(contraseña);

		JPasswordField campoContraseña = new JPasswordField();
		campoContraseña.setBounds(200, 235, 100, 20);
		add(campoContraseña);
		campoContraseña.setColumns(10);

		JButton entrar = new JButton("Entrar");
		entrar.setBounds(215, 300, 90, 25);
		add(entrar);
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadoSesion.setEstado(true);
				JOptionPane.showMessageDialog(null, "Se ha iniciado correctamente");
				ControlPaneles control = new ControlPaneles() {
				};
				Menu menu = new Menu();
				control.cambiarPagina(panelActual, menu);
			}
		});
	}
}
