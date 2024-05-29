package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Clase que gestiona la conexion con la BDD
 */
public class Gestor {
	private String url;
	private String usuario;
	private String contraseña;
	private Connection conexion;
	private Statement consulta;

	/**
	 * Constructor de la clase Gestor
	 */
	public Gestor() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader fr = new FileReader("./src/ficheros/DatosBD.txt");
			BufferedReader br = new BufferedReader(fr);
			this.url = br.readLine();
			this.usuario = br.readLine();
			this.contraseña = "";
			this.conexion = DriverManager.getConnection(url, usuario, contraseña);
			this.consulta = conexion.createStatement();
			br.close();
			fr.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cierra la conexión con la base de datos.
	 * 
	 * @throws SQLException
	 */
	public void desconectar() throws SQLException {
		if (this.conexion != null && !this.conexion.isClosed()) {
			this.conexion.close();
		}
	}

	/**
	 * Metodo que comprueba si un usuario esta registrado
	 * 
	 * @param usuario el usuario a comprobar
	 * @return true si esta en la BDD, false en caso contrario
	 * @throws IOException
	 */
	public boolean comprobarUsuario(String usuario) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Consultas.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		try {
			ResultSet usuariosRegistrados = consulta.executeQuery(linea);
			while (usuariosRegistrados.next()) {
				String usuarioRegistrado = usuariosRegistrados.getString("usuario");
				if (usuario.equals(usuarioRegistrado)) {
					br.close();
					fr.close();
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return false;
	}

	/**
	 * Inserta a un usuario en la base de datos
	 * 
	 * @param nombre     el nombre del usuario
	 * @param usuario    el nombre de usuario del usuario
	 * @param contraseña la contraseña del usuario
	 * @return true si lo añadio, false en caso contrario
	 * @throws IOException
	 */
	public boolean insertarUsuario(String nombre, String usuario, String contraseña) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Inserciones.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		String[] insert = linea.split(",");
		String sentenciaInsercion = insert[0] + "NULL," + "'" + nombre + "'," + "'" + usuario + "'," + "'" + contraseña
				+ "'" + insert[1];
		try {
			boolean comprobacion = consulta.execute(sentenciaInsercion);
			if (comprobacion) {
				br.close();
				fr.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return true;
	}

	/**
	 * Metodo que comprueba si un usuario esta registrado con una determinada clave
	 * 
	 * @param usuario el usuario a comprobar
	 * @return true si esta en la BDD, false en caso contrario
	 * @throws IOException
	 */
	public boolean comprobarUsuarioConClave(String usuario, String contraseña) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Consultas.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine(); // Primera linea
		String linea = br.readLine();
		try {
			ResultSet usuariosRegistrados = consulta.executeQuery(linea);
			while (usuariosRegistrados.next()) {
				String usuarioRegistrado = usuariosRegistrados.getString("usuario");
				String contraseñaRegistrada = usuariosRegistrados.getString("contraseña");
				if (usuario.equals(usuarioRegistrado) && contraseña.equals(contraseñaRegistrada)) {
					br.close();
					fr.close();
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return false;
	}

	/**
	 * Metodo que retorna todos los ejercicios en la base de datos
	 * 
	 * @return una lista con los ejercicios en la base de datos
	 * @throws IOException
	 */
	public ArrayList<Ejercicio> obtenerEjercicios() throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Consultas.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine(); // Primera linea
		br.readLine(); // Segunda linea
		String linea = br.readLine();
		ArrayList<Ejercicio> resultado = new ArrayList<Ejercicio>();
		try {
			ResultSet ejerciciosRegistrados = consulta.executeQuery(linea);
			while (ejerciciosRegistrados.next()) {
				String nombreEjercicio = ejerciciosRegistrados.getString("nombre_ejercicio");
				String seccion = ejerciciosRegistrados.getString("nombre_seccion");
				String musculo = ejerciciosRegistrados.getString("nombre_musculo");
				Ejercicio ejercicio = new Ejercicio(nombreEjercicio, musculo, seccion);
				resultado.add(ejercicio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return resultado;
	}

	/**
	 * * Metodo que retorna un usuario en especifico de la base de datos mediante su
	 * nombre de usuario
	 * 
	 * @param usuario el nombre de usuario
	 * @return el usuario buscado
	 * @throws IOException
	 * 
	 */
	public Usuario_registrado seleccionarUsuario(String usuario) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Consultas.txt");
		BufferedReader br = new BufferedReader(fr);
		for (int i = 0; i < 3; i++) {
			br.readLine();
		}
		String linea = br.readLine();
		String[] insert = linea.split("#");
		String sentencia = insert[0] + usuario + insert[1];
		try {
			ResultSet datosUsuario = consulta.executeQuery(sentencia);
			if (datosUsuario.next()) {
				String nombre = datosUsuario.getString("nombre");
				String contraseña = datosUsuario.getString("contraseña");
				Usuario_registrado resultado = new Usuario_registrado(nombre, usuario, contraseña, null);
				br.close();
				fr.close();
				return resultado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return null;
	}

	/**
	 * Metodo que cambia el nombre de un usuario
	 * 
	 * @param usuario     el usuario a cambiar
	 * @param nuevoNombre el nombre nuevo
	 * @return true si se cambio correctamente, false en caso contrario
	 */
	public boolean cambiarNombre(String usuario, String nuevoNombre) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Updates.txt");
		BufferedReader br = new BufferedReader(fr);
		String[] linea = br.readLine().split(",");
		String act = linea[0] + nuevoNombre + linea[1] + usuario + linea[2];
		try {
			consulta.executeUpdate(act);
			br.close();
			fr.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return false;
	}

	/**
	 * Metodo que cambia el nombre de usuario de un usuario
	 * 
	 * @param usuario      el usuario a cambiar
	 * @param nuevoUsuario el usuario nuevo
	 * @return true si se cambio correctamente, false en caso contrario
	 */
	public boolean cambiarUsuario(String usuario, String nuevoUsuario) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Updates.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String[] linea = br.readLine().split(",");
		String act = linea[0] + nuevoUsuario + linea[1] + usuario + linea[2];
		try {
			consulta.executeUpdate(act);
			br.close();
			fr.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return false;
	}

	/**
	 * Metodo que cambia la contraseña de un usuario
	 * 
	 * @param usuario    el usuario a cambiar
	 * @param nuevaClave la nueva contraseña
	 * @return true si se cambio correctamente, false en caso contrario
	 */
	public boolean cambiarContraseña(String usuario, String nuevaClave) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Updates.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		br.readLine();
		String[] linea = br.readLine().split(",");
		String act = linea[0] + nuevaClave + linea[1] + usuario + linea[2];
		try {
			consulta.executeUpdate(act);
			br.close();
			fr.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return false;
	}

	/**
	 * Metodo que retorna las rutinas de un usuario dado
	 * 
	 * @param usuario el usuario cuyas rutinas se van a comprobar
	 * @return una lista con las rutinas del usuario.
	 * @throws IOException
	 */
	public ArrayList<Rutina> rutinas(String usuario) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Consultas.txt");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Rutina> rutinas = new ArrayList<Rutina>();
		br.readLine();
		br.readLine();
		br.readLine();
		br.readLine();
		br.readLine();
		String[] linea = br.readLine().split(",");
		String sentencia = linea[0] + usuario + linea[1];
		try {
			Statement consulta1 = conexion.createStatement();
			ResultSet datosRutina = consulta1.executeQuery(sentencia);
			while (datosRutina.next()) {
				int idRutina = datosRutina.getInt("id");
				ArrayList<Ejercicio> ejercicios_rutina = ejercicios(idRutina);
				Rutina rutina_nueva = new Rutina(idRutina, ejercicios_rutina);
				rutinas.add(rutina_nueva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return rutinas;
	}

	/**
	 * Metodo que retorna una lista con los ejercicios de una rutina pasada por
	 * parametro
	 * 
	 * @param id la rutina a buscar
	 * @return una lista con los ejercicios de la rutina pasada
	 * @throws IOException
	 */
	public ArrayList<Ejercicio> ejercicios(int id) throws IOException {
		ArrayList<Ejercicio> resultado = new ArrayList<Ejercicio>();
		FileReader fr = new FileReader("./src/ficheros/Consultas.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		br.readLine();
		br.readLine();
		br.readLine();
		String[] linea = br.readLine().split("#");
		String consulta_ejercicios = linea[0] + id + linea[1];
		try {
			Statement consulta2 = conexion.createStatement();
			ResultSet ejercicios_rutina = consulta2.executeQuery(consulta_ejercicios);
			while (ejercicios_rutina.next()) {
				String nombre = ejercicios_rutina.getString("nombre_ejercicio");
				String seccion = ejercicios_rutina.getString("nombre_seccion");
				String musculo = ejercicios_rutina.getString("nombre_musculo");
				Ejercicio ejercicio_nuevo = new Ejercicio(nombre, musculo, seccion);
				resultado.add(ejercicio_nuevo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return resultado;
	}

	/**
	 * Metodo que añade una rutina a un usuario
	 * 
	 * @param usuario el usuario al que se le añadira la rutina
	 * @return true si se añadio, false en caso contrario
	 * @throws IOException
	 */
	public boolean agregarRutina(String usuario) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Inserciones.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String[] linea = br.readLine().split("#");
		String sentencia = linea[0] + usuario + linea[1];
		try {
			boolean comprobacion = consulta.execute(sentencia);
			if (comprobacion) {
				br.close();
				fr.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return true;
	}

	/**
	 * Metodo que elimina la rutina de un usuario
	 * 
	 * @param id el id de la rutina a eliminar
	 * @return true si la elimino, false en caso contrario
	 * @throws IOException
	 */
	public boolean eliminarRutina(int id) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Borrado.txt");
		BufferedReader br = new BufferedReader(fr);
		String[] linea = br.readLine().split("#");
		String sentencia = linea[0] + id + linea[1];
		try {
			boolean comprobacion = consulta.execute(sentencia);
			if (comprobacion) {
				br.close();
				fr.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return true;
	}

	/**
	 * Metodo que añade un ejercicio a la rutina de un usuario
	 * 
	 * @param id        el id de la rutina a la que se añadira el ejercicio
	 * @param ejercicio el ejercicio a añadir
	 * @param musculo   el musculo del ejercicio a aladir
	 * @return true si lo añadio, false en caso contrario
	 * @throws IOException
	 */
	public boolean agregarEjercicio(int id, String ejercicio, String musculo) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Inserciones.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		br.readLine();
		String[] linea = br.readLine().split("#");
		String sentencia = linea[0] + id + linea[1] + musculo + linea[2] + ejercicio + linea[3];
		try {
			boolean comprobacion = consulta.execute(sentencia);
			if (comprobacion) {
				br.close();
				fr.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return true;
	}

	/**
	 * Metodo que obtiene los musculos de la base de datos
	 * 
	 * @return una lista con los nombres de los musculos
	 * @throws IOException
	 */
	public ArrayList<String> obtenerMusculos() throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Consultas.txt");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> resultado = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			br.readLine();
		}
		String sentencia = br.readLine();
		try {
			ResultSet musculosRegistrados = consulta.executeQuery(sentencia);
			while (musculosRegistrados.next()) {
				String musculo = musculosRegistrados.getString("nombre");
				resultado.add(musculo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return resultado;
	}

	/**
	 * Metodo que obtiene los ejercicios de un musculo en especifico
	 * 
	 * @param musculoSeleccionado el musculo a buscar
	 * @return una lista con los ejercicios encontrados
	 * @throws IOException
	 */
	public ArrayList<Ejercicio> obtenerEjerciciosPorMusculo(String musculoSeleccionado) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Consultas.txt");
		BufferedReader br = new BufferedReader(fr);
		for (int i = 0; i < 7; i++) {
			br.readLine();
		}
		String[] linea = br.readLine().split("#");
		String sentencia = linea[0] + musculoSeleccionado + linea[1];
		ArrayList<Ejercicio> resultado = new ArrayList<Ejercicio>();
		try {
			ResultSet ejerciciosRegistrados = consulta.executeQuery(sentencia);
			while (ejerciciosRegistrados.next()) {
				String nombreEjercicio = ejerciciosRegistrados.getString("nombre_ejercicio");
				String seccion = ejerciciosRegistrados.getString("nombre_seccion");
				String musculo = ejerciciosRegistrados.getString("nombre_musculo");
				Ejercicio ejercicio = new Ejercicio(nombreEjercicio, musculo, seccion);
				resultado.add(ejercicio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return resultado;
	}

	/**
	 * Metodo que elimina un ejercicio de una rutina
	 * 
	 * @param id              el id de la rutina
	 * @param nombreEjercicio el nombre del ejercicio a eliminar
	 * @return true si lo elimina false en caso contrario
	 * @throws IOException
	 */
	public boolean eliminarEjercicio(int id, String nombreEjercicio) throws IOException {
		FileReader fr = new FileReader("./src/ficheros/Borrado.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String[] linea = br.readLine().split("#");
		String sentencia = linea[0] + nombreEjercicio + linea[1] + id + linea[2];
		try {
			boolean comprobacion = consulta.execute(sentencia);
			if (comprobacion) {
				br.close();
				fr.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		br.close();
		fr.close();
		return true;
	}
}
