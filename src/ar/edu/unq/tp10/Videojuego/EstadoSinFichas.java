package ar.edu.unq.tp10.Videojuego;

public class EstadoSinFichas implements IEstadoDeJuego{

	@Override
	public String iniciar(VideoJuego juego) {
		return "Ingrese fichas para jugar";
	}

}
