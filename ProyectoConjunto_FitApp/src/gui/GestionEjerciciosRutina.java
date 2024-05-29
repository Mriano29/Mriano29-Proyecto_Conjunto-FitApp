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
import modelo.Ejercicio;
import modelo.Gestor;
import modelo.Rutina;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * GestionRutina es una especializacion de EstructuraPanel, contiene las
 * funciones para cambiar los ejercicios de una rutina
 */
public class GestionEjerciciosRutina extends EstructuraPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<Ejercicio> ejercicios;
	JList<String> listaEjercicios = new JList<>();
	JScrollPane scrollPane;
	JComboBox<String> comboEjercicios;
	JComboBox<String> comboMusculos;
	DefaultListModel<String> model = new DefaultListModel<>();

	/**
	 * Constructor de la clase GestionEjerciciosRutina
	 * 
	 * @param rutina
	 */
	public GestionEjerciciosRutina(Rutina rutina) {
		contenido(rutina);
		contenidoFooter();
	}

	/**
	 * Metodo que carga el contenido del panel
	 * 
	 * @param rutina la rutina cuyos ejercicios se van a gestionar
	 */
	private void contenido(Rutina rutina) {
		cargarLista();
		cargarComboMusculos();
		cargarComboEjercicios();
		llenarLista(rutina);
		botonAgregarEjercicio(rutina);
		botonEliminarEjercicio(rutina);
		comboMusculos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					actualizarEjercicios();
				}
			}
		});
	}

	/**
	 * control del boton que elimina los ejercicios
	 * 
	 * @param rutina la rutina donde se va a eliminar el ejercicio
	 */
	private void botonEliminarEjercicio(Rutina rutina) {
		JButton eliminarEjercicio = new JButton("Eliminar ejercicio");
		eliminarEjercicio.setBounds(40, 505, 192, 85);
		add(eliminarEjercicio);
		eliminarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicion = listaEjercicios.getSelectedIndex();
				if (posicion != -1) {
					Gestor gestor = new Gestor() {
					};
					try {
						if (gestor.eliminarEjercicio(rutina.getID(),
								rutina.getEjercicios().get(posicion - 1).getNombre())) {
							EstadoSesion.getUsuario_activo()
									.setRutinas(gestor.rutinas(EstadoSesion.getUsuario_activo().getUsuario()));
							model.remove(posicion);
							JOptionPane.showMessageDialog(null, "Se ha eliminado el ejercicio");
						} else {
							JOptionPane.showMessageDialog(null, "Error al eliminar intentelo de nuevo");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar un ejercicio para eliminar");
				}
			}
		});
	}

	/**
	 * Metodo que carga el Combobox con los musculos
	 */
	private void cargarComboMusculos() {
		comboMusculos = new JComboBox<>();
		comboMusculos.setBounds(269, 412, 160, 29);
		add(comboMusculos);
		ArrayList<String> listaMusculos = new ArrayList<>();
		Gestor gestor = new Gestor() {
		};
		try {
			listaMusculos = gestor.obtenerMusculos();
			for (String musculo : listaMusculos) {
				comboMusculos.addItem(musculo);
			}
			gestor.desconectar();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que carga la combobox con los ejercicios de un musculo
	 */
	private void cargarComboEjercicios() {
		comboEjercicios = new JComboBox<>();
		comboEjercicios.setBounds(269, 471, 160, 29);
		add(comboEjercicios);
		ArrayList<Ejercicio> listaEjercicios = new ArrayList<>();
		Gestor gestor = new Gestor() {
		};
		try {
			String musculoSeleccionado = comboMusculos.getSelectedItem().toString();
			listaEjercicios = gestor.obtenerEjerciciosPorMusculo(musculoSeleccionado);
			for (Ejercicio ejercicio : listaEjercicios) {
				comboEjercicios.addItem(ejercicio.getNombre());
			}
			gestor.desconectar();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que actualiza la combobox de ejercicios
	 */
	private void actualizarEjercicios() {
		comboEjercicios.removeAllItems();
		ArrayList<Ejercicio> listaEjercicios = new ArrayList<>();
		Gestor gestor = new Gestor() {
		};
		try {
			String musculoSeleccionado = comboMusculos.getSelectedItem().toString();
			listaEjercicios = gestor.obtenerEjerciciosPorMusculo(musculoSeleccionado);
			for (Ejercicio ejercicio : listaEjercicios) {
				comboEjercicios.addItem(ejercicio.getNombre());
			}
			gestor.desconectar();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que controla la funcion de agregar un ejercicio
	 * 
	 * @param rutina la rutina donde se va a agregar el ejercicio
	 */
	private void botonAgregarEjercicio(Rutina rutina) {
		JButton agregarEjercicio = new JButton("Agregar ejercicio");
		agregarEjercicio.setBounds(40, 415, 192, 85);
		add(agregarEjercicio);
		agregarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestor gestor = new Gestor() {
				};
				try {
					if (gestor.agregarEjercicio(rutina.getID(), comboEjercicios.getSelectedItem().toString(),
							comboMusculos.getSelectedItem().toString())) {
						EstadoSesion.getUsuario_activo()
								.setRutinas(gestor.rutinas(EstadoSesion.getUsuario_activo().getUsuario()));
						model.addElement("Ejercicio: " + comboEjercicios.getSelectedItem().toString());
					} else {
						JOptionPane.showMessageDialog(null, "Error al añadir el ejercicio");
					}
					gestor.desconectar();
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
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

	/**
	 * Metodo que llena la lista con las rutinas que tenga el usuario y la recarga
	 * 
	 * @param rutina
	 */
	private void llenarLista(Rutina rutina) {
		model.removeAllElements();
		ejercicios = rutina.getEjercicios();
		if (ejercicios != null && !ejercicios.isEmpty()) {
			for (Ejercicio ejercicio : ejercicios) {
				model.addElement("Ejercicio: " + ejercicio.getNombre());
			}
		} else {
			model.addElement("No hay ejercicios añadidos");
		}
		listaEjercicios.setModel(model);
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
				GestionarRutinas rutinas = new GestionarRutinas();
				control.cambiarPagina(panelActual, rutinas);
			}
		});
	}
}
