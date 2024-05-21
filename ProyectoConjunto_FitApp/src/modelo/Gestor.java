package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
