package ar.edu.unq.tp9O.Publicaciones;

public class TemaInteresTitulo extends TemaDeInteres{

	public TemaInteresTitulo(String tema) {
		super(tema);
	}

	@Override
	public Boolean compararTemaConArticulo(Articulo articulo) {
		return super.getTema().equals(articulo.getTitulo());
	}

}
