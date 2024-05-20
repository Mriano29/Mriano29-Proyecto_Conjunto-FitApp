package gui;

public class EstadoSesion {
	protected static EstadoSesion sesion;
	private boolean estado = false;

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
