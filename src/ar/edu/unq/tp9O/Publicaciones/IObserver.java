package ar.edu.unq.tp9O.Publicaciones;

public interface IObserver {

	public void setTemaDeInteres(TemaDeInteres temaDeInteres);

	public void update(Articulo articulo);

}
