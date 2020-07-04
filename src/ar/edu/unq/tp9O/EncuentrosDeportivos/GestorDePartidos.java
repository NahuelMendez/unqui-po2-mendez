package ar.edu.unq.tp9O.EncuentrosDeportivos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GestorDePartidos {
	
	private Set<Partido> partidosRecibidos;
	private Map<String, ArrayList<IObserver>> aspectos;
	
	public GestorDePartidos() {
		this.partidosRecibidos = new HashSet<Partido>();
		this.aspectos = new HashMap<String, ArrayList<IObserver>>();
	}
	
	public void agregarObserver(IObserver observer, Set<String> intereses) {
		for (String aspecto : intereses) {
			this.vincularAspectoYObserver(aspecto, observer);
		}
	}

	private void vincularAspectoYObserver(String aspecto, IObserver observer) {
		if(suscriptoresDelAspecto(aspecto) == null) {
			this.aspectos.put(aspecto, new ArrayList<IObserver>());
		}
		suscriptoresDelAspecto(aspecto).add(observer);
	}
	
	public void recibirPartido(Partido partido) {
		this.partidosRecibidos.add(partido);
		for (String aspecto : this.datosDelPartido(partido)) {
			notificar(partido, aspecto);
		}
	}
	
	private ArrayList<String> datosDelPartido(Partido partido) {
		ArrayList<String> datosDelPartido = new ArrayList<String>();
		datosDelPartido.add(partido.getDeporte());
		datosDelPartido.addAll(partido.getListaDeContrincantes());
		return datosDelPartido;
	}

	private void notificar(Partido partido, String aspectoDePartido) {
		if (elAspectoEstaEnLosAspectosDeInteres(aspectoDePartido)) {
			notificarASuscriptores(suscriptoresDelAspecto(aspectoDePartido), partido);
		}
	}
	
	private boolean elAspectoEstaEnLosAspectosDeInteres(String aspectoDePartido) {
		return this.aspectos.containsKey(aspectoDePartido);
	}
	
	private void notificarASuscriptores(ArrayList<IObserver> suscriptores, Partido partido) {
		for (IObserver suscriptor : suscriptores) {
			suscriptor.update(partido);
		}
	}

	private ArrayList<IObserver> suscriptoresDelAspecto(String aspecto) {
		return this.aspectos.get(aspecto);
	}

	public Set<Partido> getPartidosRecibidos() {
		return this.partidosRecibidos;
	}

}
