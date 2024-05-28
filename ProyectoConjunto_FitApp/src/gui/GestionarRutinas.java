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
 * Clase GestionarRutinas es una especializacion de EstructuraPanel
 */
public class GestionarRutinas extends EstructuraPanel {

	private static final long serialVersionUID = 1L;
	ArrayList<Rutina> rutinas;
	JList<String> listaEjercicios = new JList<>();
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
		setLayout(null); // Usar layout nulo para coordenadas absolutas
		cargarLista();
		llenarLista();
		botonAgregarRutina();
		botonEliminarRutina();
		botonAgregarEjercicio();
		botonEliminarEjercicio();
	}

	/**
	 * Metodo que llena la lista con las rutinas que tenga el usuario y la recarga
	 */
	private void llenarLista() {
		SwingUtilities.invokeLater(() -> {
			DefaultListModel<String> model = new DefaultListModel<>();
			Gestor gestor = new Gestor() {
			};
			try {
				rutinas = EstadoSesion.getUsuario_activo().getRutinas();
				if (rutinas.size() != 0) {
					for (int i = 0; i < rutinas.size(); i++) {
						model.addElement("Rutina " + (i + 1));
					}
				} else {
					model.addElement("No hay rutinas añadidas");
				}

				listaEjercicios.setModel(model); // Actualiza el modelo de la lista
				gestor.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Metodo que carga la visualizacion de la lista y el scrollpane que la acompaña
	 */
	private void cargarLista() {
		listaEjercicios.setBounds(10, 106, 460, 296);
		scrollPane = new JScrollPane(listaEjercicios);
		scrollPane.setBounds(10, 106, 460, 296);
		add(scrollPane);
	}

	private void botonEliminarEjercicio() {
		JButton eliminarEjercicio = new JButton("Eliminar ejercicio");
		eliminarEjercicio.setBounds(242, 505, 192, 85);
		add(eliminarEjercicio);
	}

	private void botonAgregarEjercicio() {
		JButton agregarEjercicio = new JButton("Agregar ejercicio");
		agregarEjercicio.setBounds(242, 420, 192, 75);
		add(agregarEjercicio);
	}

	/**
	 * Metodo que elimina una rutina seleccionada
	 */
	private void botonEliminarRutina() {
		JButton eliminarRutina = new JButton("Eliminar rutina");
		eliminarRutina.setBounds(40, 505, 192, 85);
		add(eliminarRutina);
		eliminarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicion = listaEjercicios.getSelectedIndex();
				if (posicion != -1) {
					Gestor gestor = new Gestor() {
					};
					try {
						if (gestor.eliminarRutina(rutinas.get(listaEjercicios.getSelectedIndex()).getID())) {
							EstadoSesion.getUsuario_activo()
									.setRutinas(gestor.rutinas(EstadoSesion.getUsuario_activo().getUsuario()));
							llenarLista();
						} else {
							JOptionPane.showMessageDialog(null, "Error al eliminar la rutina intentelo de nuevo");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
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
		agregarRutina.setBounds(40, 420, 192, 75);
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
