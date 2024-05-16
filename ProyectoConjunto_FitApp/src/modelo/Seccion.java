package modelo;

public class Seccion {
	private String nombre;
	private Musculo musculo;

	public Seccion(String nombre, Musculo musculo) {
		super();
		this.nombre = nombre;
		this.musculo = musculo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Musculo getMusculo() {
		return musculo;
	}

	public void setMusculo(Musculo musculo) {
		this.musculo = musculo;
	}

}
