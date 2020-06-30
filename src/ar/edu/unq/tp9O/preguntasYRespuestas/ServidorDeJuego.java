package ar.edu.unq.tp9O.preguntasYRespuestas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServidorDeJuego {
	
	private Set<IParticipante> participantes;
	private Map<String, String> cuestionario;
	private Map<IParticipante, Integer> puntajes;
	private IEstadoDeJuego estadoActual;
	
	public ServidorDeJuego() {
		this.participantes = new HashSet<IParticipante>();
		this.cuestionario = new HashMap<String, String>();
		this.puntajes = new HashMap<IParticipante, Integer>();
		this.estadoActual = new EstadoDeJuegoSinComenzar();
	}
	
	public Set<IParticipante> getParticipantes() {
		return this.participantes;
	}

	public void agregarParticipante(IParticipante participante) throws Exception {
		this.estadoActual.agregarParticipante(this, participante);
	}

	public void recibirCuestionario(Map<String, String> cuestionario) {
		this.cuestionario = cuestionario;
		this.iniciarJuego();
	}

	private void iniciarJuego() {
		this.estadoActual = new EstadoDeJuegoEnCurso();
		this.notificarInicioDePartidaAParticipantes();
	}

	private void notificarInicioDePartidaAParticipantes() {
		ArrayList<String> preguntas = new ArrayList<String>(this.cuestionario.keySet());
		for (IParticipante participante : participantes) {
			participante.update(preguntas);
		}
	}

	public Set<String> getPreguntasDeLaRonda() {
		return this.cuestionario.keySet();
	}

	public Boolean verificarRespuesta(String pregunta, String respuesta, Participante participante) throws Exception {
		return this.estadoActual.verificarRespuesta(pregunta, respuesta, participante, this);
	}

	protected void notificarRespuestaCorrectaDelParticipante(Participante participante, String pregunta) {
		String notificacion = "El/La participante " + participante.getNombre() + " contesto bien la pregunta " + pregunta;
		for (IParticipante participanteDelJuego : this.participantes) {
			participanteDelJuego.agregarNotificacion(notificacion);
		}
	}

	protected void sumarPuntajeAlParticipante(Participante participante) {
		Integer valorAnterior = this.puntajes.get(participante);
		this.puntajes.put(participante, valorAnterior + 1);
		if (this.puntajes.get(participante) == 5) {
			this.finalizarJuego();
			this.notificarGanadorDeLaPartida(participante);
		}
	}

	private void notificarGanadorDeLaPartida(Participante participante) {
		String notificacion = "El/La participante " + participante.getNombre() + " gana la partida";
		for (IParticipante participanteDelJuego : participantes) {
			participanteDelJuego.agregarNotificacion(notificacion);
		}
	}

	private void finalizarJuego() {
		this.estadoActual = new EstadoDeJuegoFinalizado();
	}

	public Integer getPuntajeDeParticipante(IParticipante participante) {
		return this.puntajes.get(participante);
	}

	public IEstadoDeJuego getEstadoActual() {
		return this.estadoActual;
	}

	public void agregarParticipanteAPuntajes(IParticipante participante) {
		this.puntajes.put(participante, 0);
	}

	public Map<String, String> getCuestionario() {
		return this.cuestionario;
	}

	
	
}
