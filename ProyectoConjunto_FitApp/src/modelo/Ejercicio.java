package modelo;

public class Ejercicio {
	private String nombre;
	private Seccion seccion;

	public Ejercicio(String nombre, Seccion seccion) {
		super();
		this.nombre = nombre;
		this.seccion = seccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	
}
