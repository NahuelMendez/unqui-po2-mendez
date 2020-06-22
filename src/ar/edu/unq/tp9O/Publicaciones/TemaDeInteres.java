package ar.edu.unq.tp9O.Publicaciones;

public abstract class TemaDeInteres {

	private String tema;
	
	public TemaDeInteres(String tema) {
		this.setTema(tema);
	}

	private void setTema(String tema) {
		this.tema = tema;
	}

	public abstract Boolean compararTemaConArticulo(Articulo articulo);

	public String getTema() {
		return this.tema;
	}
	
}
