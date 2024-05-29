package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import modelo.Gestor;
import modelo.Rutina;

/**
 * Clase GestionarRutinas es una especializacion de EstructuraPanel, contiene
 * los metodos para gestionar las rutinas del usuario
 */
public class GestionarRutinas extends EstructuraPanel {

	private static final long serialVersionUID = 1L;
	ArrayList<Rutina> rutinas;
	JList<String> listaRutinas = new JList<>();
	JScrollPane scrollPane;

	/**
	 * Constructor de la clase GestionarRutinas
	 */
	public GestionarRutinas() {
		try {
			contenido();
		} catch (IOException e) {
			e.printStackTrace();
		}
		contenidoFooter();
	}

	/**
	 * Metodo que carga el contenido en el panel
	 *
	 * @throws IOException
	 */
	private void contenido() throws IOException {
		cargarLista();
		llenarLista();
		botonAgregarRutina();
		botonEliminarRutina();
		botonGestionarEjerciciosRutina();
	}

	/**
	 * Metodo que llena la lista con las rutinas que tenga el usuario y la recarga
	 */
	private void llenarLista() {
		SwingUtilities.invokeLater(() -> {
			DefaultListModel<String> model = new DefaultListModel<>();
			rutinas = EstadoSesion.getUsuario_activo().getRutinas();
			if (rutinas.size() != 0 || rutinas == null) {
				for (int i = 0; i < rutinas.size(); i++) {
					model.addElement("Rutina " + (i + 1));
				}
			} else {
				model.addElement("No hay rutinas añadidas");
			}

			listaRutinas.setModel(model); 
		});
	}

	/**
	 * Metodo que carga la visualizacion de la lista y el scrollpane que la acompaña
	 */
	private void cargarLista() {
		listaRutinas.setBounds(10, 106, 460, 296);
		scrollPane = new JScrollPane(listaRutinas);
		scrollPane.setBounds(10, 106, 460, 296);
		add(scrollPane);
	}

	private void botonGestionarEjerciciosRutina() {
		JButton eliminarEjercicio = new JButton("Gestionar ejercicios");
		eliminarEjercicio.setBounds(140, 505, 192, 85);
		add(eliminarEjercicio);
		eliminarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicion = listaRutinas.getSelectedIndex();
				if (posicion != -1) {
					ControlPaneles control = new ControlPaneles() {
					};
					GestionEjerciciosRutina menu = new GestionEjerciciosRutina(rutinas.get(posicion));
					control.cambiarPagina(panelActual, menu);
				} else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar una rutina para eliminar");
				}
			}
		});
	}

	/**
	 * Metodo que elimina una rutina seleccionada
	 */
	private void botonEliminarRutina() {
		JButton eliminarRutina = new JButton("Eliminar rutina");
		eliminarRutina.setBounds(242, 415, 192, 85);
		add(eliminarRutina);
		eliminarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicion = listaRutinas.getSelectedIndex();
				if (posicion != -1) {
					Gestor gestor = new Gestor() {
					};
					try {
						if (gestor.eliminarRutina(rutinas.get(listaRutinas.getSelectedIndex()).getID())) {
							EstadoSesion.getUsuario_activo()
									.setRutinas(gestor.rutinas(EstadoSesion.getUsuario_activo().getUsuario()));
							llenarLista();
						} else {
							JOptionPane.showMessageDialog(null, "Error al eliminar la rutina intentelo de nuevo");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							gestor.desconectar();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar una rutina para eliminar");
				}
			}
		});
	}

	/**
	 * Metodo que añade una rutina a un usuario
	 */
	private void botonAgregarRutina() {
		JButton agregarRutina = new JButton("Agregar rutina");
		agregarRutina.setBounds(40, 415, 192, 85);
		add(agregarRutina);
		Gestor gestor = new Gestor() {
		};
		agregarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (gestor.agregarRutina(EstadoSesion.getUsuario_activo().getUsuario())) {
						EstadoSesion.getUsuario_activo()
								.setRutinas(gestor.rutinas(EstadoSesion.getUsuario_activo().getUsuario()));
						llenarLista();
					} else {
						JOptionPane.showMessageDialog(null, "Error al crear rutina intentelo de nuevo");
					}
				} catch (IOException b) {
					b.printStackTrace();
				} finally {
					try {
						gestor.desconectar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Metodo que carga el contenido del footer en el panel
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
