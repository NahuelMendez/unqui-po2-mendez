package ar.edu.unq.tp9O.Publicaciones;

public class TemaInteresTipo extends TemaDeInteres {

	public TemaInteresTipo(String tema) {
		super(tema);
	}

	@Override
	public Boolean compararTemaConArticulo(Articulo articulo) {
		return super.getTema().equals(articulo.getTipo());
	}

}
