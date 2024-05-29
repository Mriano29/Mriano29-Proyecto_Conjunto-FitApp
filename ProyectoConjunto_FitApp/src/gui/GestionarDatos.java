package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Gestor;

/**
 * Clase gestionarDatos es una especializacion de EstructuraPanel, permite al
 * usuario cambiar sus datos de inicio de sesion y nombre
 */
public class GestionarDatos extends EstructuraPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNombre;
	private JTextField campoUsuario;
	private JPasswordField campoClave;

	/**
	 * Constructor de la clase gestionar datos
	 */
	public GestionarDatos() {
		cargarContenido();
		cargarFunciones();
		contenidoFooter();
	}

	/**
	 * Carga los botones que inician las acciones de gestionar los datos
	 */
	private void cargarFunciones() {
		cambiarNombre();
		cambiarUsuario();
		cambiarClave();
	}

	/**
	 * Contiene las funciones de cambio de contraseña
	 */
	private void cambiarClave() {
		JButton cambiarclave = new JButton("Cambiar clave");
		cambiarclave.setBounds(340, 450, 140, 100);
		add(cambiarclave);
		cambiarclave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmar()) {
					String input = JOptionPane.showInputDialog(null, "Introduce la nueva contraseña", "Cambio de clave",
							JOptionPane.QUESTION_MESSAGE);
					try {
						if (input.isBlank()) {
							throw new InputMismatchException("La contraseña no puede estar vacía intentelo de nuevo");
						} else if (input.length() > 20) {
							throw new InputMismatchException("El numero de caracteres debe ser menor a 20");
						} else {
							Gestor gestor = new Gestor() {
							};
							if (gestor.cambiarContraseña(EstadoSesion.getUsuario_activo().getUsuario(),
									input.strip())) {
								JOptionPane.showMessageDialog(null, "Se ha cambiado su clave con exito");
								EstadoSesion.setUsuario_activo(
										gestor.seleccionarUsuario(EstadoSesion.getUsuario_activo().getUsuario()));
								campoClave.setText(EstadoSesion.getUsuario_activo().getContraseña());
							} else {
								JOptionPane.showMessageDialog(null, "Ha habido un error intentelo de nuevo");
							}
							gestor.desconectar();
						}
					} catch (InputMismatchException a) {
						JOptionPane.showMessageDialog(null, a.getMessage());
					} catch (IOException b) {
						b.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Contiene las funciones de cambio de nombre de usuario
	 */
	private void cambiarUsuario() {
		JButton cambiarUsuario = new JButton("Cambiar usuario");
		cambiarUsuario.setBounds(180, 450, 140, 100);
		add(cambiarUsuario);
		cambiarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmar()) {
					String input = JOptionPane.showInputDialog(null, "Introduce el nuevo usuario", "Cambio de usuario",
							JOptionPane.QUESTION_MESSAGE);
					try {
						if (input.isBlank()) {
							throw new InputMismatchException("El usuario no puede estar vacío intentelo de nuevo");
						} else if (input.length() > 20) {
							throw new InputMismatchException("El numero de caracteres debe ser menor a 20");
						} else {
							Gestor gestor = new Gestor() {
							};
							if (gestor.cambiarUsuario(EstadoSesion.getUsuario_activo().getUsuario(), input.strip())) {
								JOptionPane.showMessageDialog(null, "Se ha cambiado su usuario con exito");
								EstadoSesion.setUsuario_activo(gestor.seleccionarUsuario(input.strip()));
								campoUsuario.setText(EstadoSesion.getUsuario_activo().getUsuario());
							} else {
								JOptionPane.showMessageDialog(null, "Ha habido un error intentelo de nuevo");
							}
							gestor.desconectar();
						}
					} catch (InputMismatchException a) {
						JOptionPane.showMessageDialog(null, a.getMessage());
					} catch (IOException b) {
						b.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Contiene las funciones de cambio de nombre
	 */
	private void cambiarNombre() {
		JButton cambiarNombre = new JButton("Cambiar nombre");
		cambiarNombre.setBounds(20, 450, 140, 100);
		add(cambiarNombre);
		cambiarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmar()) {
					String input = JOptionPane.showInputDialog(null, "Introduce el nuevo nombre", "Cambio de nombre",
							JOptionPane.QUESTION_MESSAGE);
					try {
						if (input.isBlank()) {
							throw new InputMismatchException("El nombre no puede estar vacío intentelo de nuevo");
						} else if (input.length() > 20) {
							throw new InputMismatchException("El numero de caracteres debe ser menor a 20");
						} else {
							Gestor gestor = new Gestor() {
							};
							if (gestor.cambiarNombre(EstadoSesion.getUsuario_activo().getUsuario(), input.strip())) {
								JOptionPane.showMessageDialog(null, "Se ha cambiado su nombre con exito");
								EstadoSesion.setUsuario_activo(
										gestor.seleccionarUsuario(EstadoSesion.getUsuario_activo().getUsuario()));
								campoNombre.setText(EstadoSesion.getUsuario_activo().getNombre());
							} else {
								JOptionPane.showMessageDialog(null, "Ha habido un error intentelo de nuevo");
							}
							gestor.desconectar();
						}
					} catch (InputMismatchException a) {
						JOptionPane.showMessageDialog(null, a.getMessage());
					} catch (IOException b) {
						b.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Metodo que muestra un panel con opciones para confirmar el cambio
	 * 
	 * @return true si el usuario presiona si, false en caso contrario
	 */
	private boolean confirmar() {
		Object[] options = { "Sí", "No" };
		int respuesta = JOptionPane.showOptionDialog(null, "¿Deseas continuar?", "Confirmación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (respuesta == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que carga el contenido principal de la ventana
	 */
	private void cargarContenido() {
		JLabel nombre = new JLabel("Nombre:");
		nombre.setBounds(80, 170, 65, 15);
		nombre.setFont(new Font("Arial", Font.BOLD, 16));
		add(nombre);
		campoNombre = new JTextField();
		campoNombre.setBounds(155, 170, 140, 19);
		add(campoNombre);
		campoNombre.setText(EstadoSesion.getUsuario_activo().getNombre());
		campoNombre.setEditable(false);

		JLabel usuario = new JLabel("Usuario:");
		usuario.setBounds(80, 220, 65, 15);
		usuario.setFont(new Font("Arial", Font.BOLD, 16));
		add(usuario);
		campoUsuario = new JTextField();
		campoUsuario.setBounds(155, 220, 140, 19);
		add(campoUsuario);
		campoUsuario.setText(EstadoSesion.getUsuario_activo().getUsuario());
		campoUsuario.setEditable(false);

		JLabel contraseña = new JLabel("Contraseña");
		contraseña.setBounds(50, 270, 95, 15);
		contraseña.setFont(new Font("Arial", Font.BOLD, 16));
		add(contraseña);
		campoClave = new JPasswordField();
		campoClave.setBounds(155, 270, 140, 19);
		add(campoClave);
		campoClave.setText(EstadoSesion.getUsuario_activo().getContraseña());
		campoClave.setEditable(false);
	}

	/**
	 * Metodo que carga el contenido del footer
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
