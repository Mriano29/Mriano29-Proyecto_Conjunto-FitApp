package modelo;

public class Ejercicio {
	private String nombre;
	private String seccion;
	private String musculo;

	public Ejercicio(String nombre, String musculo, String seccion) {
		super();
		this.nombre = nombre;
		this.musculo = musculo;
		this.seccion = seccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getMusculo() {
		return musculo;
	}

	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}

}
