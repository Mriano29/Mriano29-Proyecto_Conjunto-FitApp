package modelo;

import java.io.BufferedReader;
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
	private final String url = "jdbc:mysql://localhost:3306/ejercicios";
	private final String usuario = "root";
	private final String contraseña = "";
	private Connection conexion;
	private Statement consulta;

	public Gestor() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conexion = DriverManager.getConnection(url, usuario, contraseña);
			this.consulta = conexion.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
		System.out.println(sentenciaInsercion);
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
}
