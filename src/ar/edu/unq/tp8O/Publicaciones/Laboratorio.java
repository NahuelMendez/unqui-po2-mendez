package ar.edu.unq.tp8O.Publicaciones;

import java.util.ArrayList;
import java.util.List;

public class Laboratorio implements IObserver{
	
	private List<Articulo> articulosRecibidos;
	private SistemaBibliografico sistema;
	private TemaDeInteres temaDeInteres;
	
	public void cargarArticulo(Articulo articulo) {
		this.sistema.agregarArticulo(articulo);
	}

	public Laboratorio(SistemaBibliografico sistema) {
		this.sistema = sistema;
		articulosRecibidos = new ArrayList<Articulo>();
		this.temaDeInteres = new TemaInteresNulo("Ninguno");
	}
	
	public void suscribirseAlSistema(TemaDeInteres temaDeInteres) {
		this.sistema.agregarObserver(this, temaDeInteres);
	}
	
	@Override
	public void update(Articulo articulo) {
		if(this.temaDeInteres.compararTemaConArticulo(articulo)) {
			this.agregarArticuloDeInteres(articulo);
		}
	}
	
	private void agregarArticuloDeInteres(Articulo articulo) {
		this.articulosRecibidos.add(articulo);
	}

	@Override
	public void setTemaDeInteres(TemaDeInteres temaDeInteres) {
		this.temaDeInteres = temaDeInteres;
		
	}

	public List<Articulo> getArticulosRecibidos() {
		return this.articulosRecibidos;
	}
}
