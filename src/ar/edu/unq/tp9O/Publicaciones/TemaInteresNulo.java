package ar.edu.unq.tp9O.Publicaciones;

public class TemaInteresNulo extends TemaDeInteres{

	public TemaInteresNulo(String tema) {
		super("Ninguno");
	}

	@Override
	public Boolean compararTemaConArticulo(Articulo articulo) {
		return false;
	}
	
	

}
