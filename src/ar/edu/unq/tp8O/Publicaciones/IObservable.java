package ar.edu.unq.tp8O.Publicaciones;

public interface IObservable {
	
	public void agregarObserver(IObserver observer, TemaDeInteres temaDeInteres);
	public void quitarObserver(IObserver observer);
	public void notificar(Articulo articulo);

}
