package ar.edu.unq.tp9O.Publicaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemaBibliografico implements IObservable{
	
	private List<Articulo> articulos;
	private Map<String, ArrayList<ISuscriptor>> suscriptores;
	
	public SistemaBibliografico() {
		this.articulos = new ArrayList<Articulo>();
		this.suscriptores = new HashMap<String, ArrayList<ISuscriptor>>();
	}

	public void agregarArticulo(Articulo articulo) {
		this.articulos.add(articulo);
		for (String temaDelArticulo : articulo.getDatosRelevantes()) {
			this.notificar(temaDelArticulo);
		}
	}

	@Override
	public void agregarSuscriptor(ISuscriptor suscriptor, Set<String> temasDeInteres) {
		for (String temaDeInteres : temasDeInteres) {
			this.vincularTemaDeInteresYObservers(suscriptor, temaDeInteres);
		}
	}

	private void vincularTemaDeInteresYObservers(ISuscriptor suscriptor, String temasDeInteres) {
		if (this.suscriptores.get(temasDeInteres) == null) {
			this.suscriptores.put(temasDeInteres, new ArrayList<ISuscriptor>());
		}
		this.suscriptores.get(temasDeInteres).add(suscriptor);
	}

	@Override
	public void quitarSuscriptor(ISuscriptor observer, String temaDeInteres) {
		this.suscriptores.get(temaDeInteres).remove(observer);
	}

	@Override
	public void notificar(String temaDelArticulo) {
		if(this.suscriptores.containsKey(temaDelArticulo)) {
			this.notificarASuscriptoresDelTema(temaDelArticulo);
		}
	}

	private void notificarASuscriptoresDelTema(String temaDelArticulo) {
		for (ISuscriptor suscriptor : this.suscriptores.get(temaDelArticulo)) {
			suscriptor.update(this.notificacionConTema(temaDelArticulo));
		}
	}

	private String notificacionConTema(String temaDelArticulo) {
		return "Se ingreso un nuevo articulo relacionado a: " + temaDelArticulo;
	}

}
