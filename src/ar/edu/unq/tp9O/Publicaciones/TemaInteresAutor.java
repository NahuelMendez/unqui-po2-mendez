package ar.edu.unq.tp9O.Publicaciones;

public class TemaInteresAutor extends TemaDeInteres {

	public TemaInteresAutor(String tema) {
		super(tema);
	}

	@Override
	public Boolean compararTemaConArticulo(Articulo articulo) {
		return super.getTema().equals(articulo.getAutor());
	}

}