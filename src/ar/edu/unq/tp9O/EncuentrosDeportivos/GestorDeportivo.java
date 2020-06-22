package ar.edu.unq.tp9O.EncuentrosDeportivos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestorDeportivo {
	
	private Set<Partido> partidosRecibidos;
	private Map<String, ArrayList<IObserver>> aspectos;
	
	public GestorDeportivo() {
		this.partidosRecibidos = new HashSet<Partido>();
		this.aspectos = new HashMap<String, ArrayList<IObserver>>();
	}
	
	public void recibirPartido(Partido partido) {
		this.partidosRecibidos.add(partido);
		notificarDeporte(partido, partido.getDeporte());
		notificarContrincantes(partido, partido.getListaDeContrincantes());
	}

	private void notificarContrincantes(Partido partido, List<String> listaDeContrincantes) {
		for (String string : listaDeContrincantes) {
			if (this.aspectos.keySet().contains(string)) {
				this.notificarObservers(this.aspectos.get(string), partido, string);
			}
		}
	}

	private void notificarObservers(ArrayList<IObserver> arrayList, Partido partido, String aspecto) {
		for (IObserver iObserver : arrayList) {
			iObserver.update(partido, aspecto);
		}
	}

	public void agregarObserver(IObserver observer, String aspecto) {
		if(this.aspectos.get(aspecto) == null) {
			this.aspectos.put(aspecto, new ArrayList<IObserver>());
		}
		this.aspectos.get(aspecto).add(observer);
	}
	
	private void notificarDeporte(Partido partido, String aspecto) {
		if (this.aspectos.containsKey(partido.getDeporte())) {
			notificarObservers(this.aspectos.get(aspecto), partido, aspecto);
		}
	}

	public Set<Partido> getPartidosRecibidos() {
		return this.partidosRecibidos;
	}

}
