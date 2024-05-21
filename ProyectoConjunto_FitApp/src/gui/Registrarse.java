package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Gestor;

public class Registrarse extends EstructuraPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNombre;
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	private JPasswordField campoConfirmacion;

	public Registrarse() {
		cargarContenido();
		contenidoFooter();
	}

	private void cargarContenido() {
		JLabel nombre = new JLabel("Nombre:");
		nombre.setBounds(120, 180, 70, 20);
		nombre.setFont(new Font("Arial", Font.BOLD, 16));
		add(nombre);

		campoNombre = new JTextField();
		campoNombre.setBounds(200, 180, 100, 20);
		add(campoNombre);
		campoNombre.setColumns(10);

		JLabel usuario = new JLabel("Usuario:");
		usuario.setBounds(120, 235, 100, 20);
		usuario.setFont(new Font("Arial", Font.BOLD, 16));
		add(usuario);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(200, 235, 100, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		JLabel contraseña = new JLabel("Contraseña:");
		contraseña.setBounds(90, 290, 100, 20);
		contraseña.setFont(new Font("Arial", Font.BOLD, 16));
		add(contraseña);

		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(200, 290, 100, 20);
		add(campoContraseña);
		campoContraseña.setColumns(10);

		JLabel confirmacion = new JLabel("Repita su contraseña:");
		confirmacion.setBounds(25, 345, 166, 20);
		confirmacion.setFont(new Font("Arial", Font.BOLD, 16));
		add(confirmacion);

		campoConfirmacion = new JPasswordField();
		campoConfirmacion.setBounds(200, 345, 100, 20);
		add(campoConfirmacion);
		campoConfirmacion.setColumns(10);

		cargarBotonEntrar();
	}

	private void contenidoFooter() {
		JButton atras = new JButton("Volver");
		atras.setBounds(10, 20, 90, 25);
		footer.add(atras);
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlPaneles control = new ControlPaneles() {
				};
				InicioSesion sesion = new InicioSesion();
				control.cambiarPagina(panelActual, sesion);
			}
		});
	}

	private void cargarBotonEntrar() {
		JButton entrar = new JButton("Entrar");
		entrar.setBounds(215, 400, 90, 25);
		add(entrar);
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = campoNombre.getText().strip();
					String usuario = campoUsuario.getText().strip();
					char[] vectorClave = campoContraseña.getPassword();
					String clave = new String(vectorClave);
					char[] vectorConfirmacion = campoConfirmacion.getPassword();
					String confirmacion = new String(vectorConfirmacion);
					if (nombre.isBlank() || usuario.isBlank() || clave.isBlank() || confirmacion.isBlank()) {
						throw new IllegalArgumentException();
					} else {
						if (!clave.equals(confirmacion)) {
							throw new Exception();
						} else {
							try {
								Gestor gestor = new Gestor();
								if (gestor.comprobarUsuario(usuario)) {
									JOptionPane.showMessageDialog(null, "El nombre de usuario no está disponible");
								} else {
									JOptionPane.showMessageDialog(null, "eskereeeeee");
								}
								gestor.desconectar();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				} catch (InputMismatchException a) {
					JOptionPane.showMessageDialog(null, "Debe introducir datos válidos, inténtelo de nuevo");
				} catch (IllegalArgumentException b) {
					JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos");
				} catch (Exception c) {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
				}
			}
		});
	}
}
