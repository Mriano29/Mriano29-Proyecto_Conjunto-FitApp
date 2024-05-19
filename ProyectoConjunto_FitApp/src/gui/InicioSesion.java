package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends EstructuraPanel{
	private static final long serialVersionUID = 1L;

	public InicioSesion() {
		super();
		cargarContenido();
	}

	private void cargarContenido() {
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
		
		JLabel registro = new JLabel("¿No tienes cuenta? Registrate aqui");
		registro.setBounds(90, 360, 266, 25);
		registro.setFont(new Font("Arial", Font.BOLD, 16));
		add(registro);
		
		JButton registrarse = new JButton("Registrarse");
		registrarse.setBounds(180, 400, 90, 25);
		add(registrarse);
		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
