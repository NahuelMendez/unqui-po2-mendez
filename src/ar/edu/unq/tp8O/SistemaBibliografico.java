package ar.edu.unq.tp8O;

import java.util.ArrayList;
import java.util.List;

public class SistemaBibliografico implements IObservable{
	
	private List<IObserver> observers;
	private List<Articulo> articulos;
	
	public SistemaBibliografico() {
		this.articulos = new ArrayList<Articulo>();
		this.observers = new ArrayList<IObserver>();
	}

	public void agregarArticulo(Articulo articulo) {
		this.articulos.add(articulo);
		this.notificar(articulo);
	}

	@Override
	public void agregarObserver(IObserver observer, TemaDeInteres temaDeInteres) {
		this.observers.add(observer);
		observer.setTemaDeInteres(temaDeInteres);
	}

	@Override
	public void quitarObserver(IObserver observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notificar(Articulo articulo) {
		for (IObserver observer : observers) {
			observer.update(articulo);
		}
	}

}
