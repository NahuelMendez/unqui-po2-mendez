package ar.edu.unq.tp9O.preguntasYRespuestas;

public class EstadoDeJuegoSinComenzar implements IEstadoDeJuego {

	public void agregarParticipante(ServidorDeJuego servidor, IParticipante participante) throws Exception {
		if (servidor.getParticipantes().size() == 5) {
			System.out.println("No se admiten mas participantes");
			throw new Exception ("No se admiten mas participantes");
		} else {
			servidor.getParticipantes().add(participante);
			servidor.agregarParticipanteAPuntajes(participante);
		}
	}

	@Override
	public Boolean verificarRespuesta(String pregunta, String respuesta, Participante participante, ServidorDeJuego servidor) throws Exception {
		throw new Exception("No hay una partida en curso");
	}
	
}
