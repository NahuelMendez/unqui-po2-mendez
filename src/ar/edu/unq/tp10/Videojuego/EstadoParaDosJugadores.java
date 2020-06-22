package ar.edu.unq.tp10.Videojuego;

public class EstadoParaDosJugadores implements IEstadoDeJuego {

	@Override
	public String iniciar(VideoJuego juego) {
		juego.gastarFicha();
		juego.gastarFicha();
		return "Comienza el juego para dos jugadores";
	}

}
