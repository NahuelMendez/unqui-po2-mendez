package ar.edu.unq.tp8O;

public class TemaInteresFiliacion extends TemaDeInteres {

	public TemaInteresFiliacion(String tema) {
		super(tema);
	}
	
	@Override
	public Boolean compararTemaConArticulo(Articulo articulo) {
		return super.getTema().equals(articulo.getFiliacion());
	}

}
