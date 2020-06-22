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
	
	public void suscribirseAGestorDeportivo(GestorDeportivo gestor, String aspecto) {
		gestor.agregarObserver(this, aspecto);
		this.intereses.add(aspecto);
	}
	
	@Override
	public void update(Partido partido, String aspecto) {
		if (this.intereses.contains(aspecto)) {
			agregarPartido(partido);
		}
	}

	private void agregarPartido(Partido partido) {
		partidosRecibidos.add(partido);
	}

	public Set<Partido> getPartidosRecibidos() {
		return this.partidosRecibidos;
	}
}
