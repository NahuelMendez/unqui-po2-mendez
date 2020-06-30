package ar.edu.unq.tp9O.preguntasYRespuestas;

public class EstadoDeJuegoFinalizado implements IEstadoDeJuego {

	@Override
	public void agregarParticipante(ServidorDeJuego servidor, IParticipante participante) throws Exception {
		throw new Exception("El juego finalizo");
	}

	@Override
	public Boolean verificarRespuesta(String pregunta, String respuesta, Participante participante,
			ServidorDeJuego servidor) throws Exception {
		throw new Exception("El juego finalizo");
	}

}
