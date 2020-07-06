package ar.edu.unq.tp9O.preguntasYRespuestas;

import java.util.ArrayList;

public interface IParticipante {
	
	public void update(ArrayList<String> preguntas);

	public void agregarNotificacion(String notificacion);

	void contestarPregunta(String respuesta) throws Exception;

	void unirseAPartida(ServidorDeJuego servidor) throws Exception;
	
}
