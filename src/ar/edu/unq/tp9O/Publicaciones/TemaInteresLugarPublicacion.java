package ar.edu.unq.tp9O.Publicaciones;

public class TemaInteresLugarPublicacion extends TemaDeInteres{

	public TemaInteresLugarPublicacion(String tema) {
		super(tema);
	}

	@Override
	public Boolean compararTemaConArticulo(Articulo articulo) {
		return super.getTema().equals(articulo.getLugarDePublicacion());
	}

}
