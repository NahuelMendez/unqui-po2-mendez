package ar.edu.unq.tp9O.EncuentrosDeportivos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServidorDeportivo implements IObserver{

	private List<String> intereses;
	private Set<Partido> partidosRecibidos;
	
	public ServidorDeportivo(){
		this.intereses = new ArrayList<String>();
		this.partidosRecibidos = new HashSet<Partido>();
	}
	
	public void suscribirseAGestorDeportivo(GestorDePartidos gestor, Set<String> aspectosDeInteres) {
		gestor.agregarObserver(this, aspectosDeInteres);
		this.intereses.addAll(aspectosDeInteres);
	}
	
	@Override
	public void update(Partido partido) {
		agregarPartido(partido);
	}

	private void agregarPartido(Partido partido) {
		partidosRecibidos.add(partido);
	}

	public Set<Partido> getPartidosRecibidos() {
		return this.partidosRecibidos;
	}
}
