package ar.edu.unq.tp9O.preguntasYRespuestas;

public class EstadoDeJuegoEnCurso implements IEstadoDeJuego {

	@Override
	public void agregarParticipante(ServidorDeJuego servidor, IParticipante participante) throws Exception {
		throw new Exception("El juego ya esta en curso");
	}

	@Override
	public Boolean verificarRespuesta(String pregunta, String respuesta, Participante participante, ServidorDeJuego servidor) throws Exception {
		if (servidor.getCuestionario().get(pregunta).equals(respuesta)) {
			participante.pasarASiguientePregunta();
			servidor.sumarPuntajeAlParticipante(participante);
			servidor.notificarRespuestaCorrectaDelParticipante(participante, pregunta);
			return true;
		} else {
			participante.volverAIntentarPregunta();
			return false;
		}
	}
	
	

}
