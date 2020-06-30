package ar.edu.unq.tp9O.preguntasYRespuestas;

public interface IEstadoDeJuego {
	
	public void agregarParticipante(ServidorDeJuego servidor, IParticipante participante) throws Exception;

	public Boolean verificarRespuesta(String pregunta, String respuesta, Participante participante, ServidorDeJuego servidor)
			throws Exception;

}
