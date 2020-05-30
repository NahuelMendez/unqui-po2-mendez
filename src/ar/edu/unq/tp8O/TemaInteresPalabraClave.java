package ar.edu.unq.tp8O;

public class TemaInteresPalabraClave extends TemaDeInteres {

	public TemaInteresPalabraClave(String tema) {
		super(tema);
	}

	@Override
	public Boolean compararTemaConArticulo(Articulo articulo) {
		return super.getTema().equals(articulo.getPalabraClave());
	}

}
