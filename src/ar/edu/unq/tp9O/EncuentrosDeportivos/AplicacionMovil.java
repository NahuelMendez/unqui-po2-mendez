package ar.edu.unq.tp9O.EncuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AplicacionMovil implements IObserver {

	private List<String> resultadosObtenidos;
	
	public AplicacionMovil() {
		this.resultadosObtenidos = new ArrayList<String>();
	}
	
	public void suscribirseAGestorDePartidosConInteres(GestorDePartidos gestorDePartidos, Set<String> intereses) {
		gestorDePartidos.agregarObserver(this, intereses);
	}
	
	@Override
	public void update(Partido partido) {
		agregarResultadoDePartido(partido);
	}

	private void agregarResultadoDePartido(Partido partido) {
		this.resultadosObtenidos.add(partido.getResultado());
	}

	public List<String> getResultadosObtenidos(){
		return this.resultadosObtenidos;
	}
	
}
