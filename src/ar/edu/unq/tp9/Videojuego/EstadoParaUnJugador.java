package ar.edu.unq.tp9.Videojuego;

public class EstadoParaUnJugador implements IEstadoDeJuego{

	@Override
	public String iniciar(VideoJuego juego) {
		juego.gastarFicha();
		return "Comienza el juego para un jugador";
	}

}
