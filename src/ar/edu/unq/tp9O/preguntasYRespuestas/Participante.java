package ar.edu.unq.tp9O.preguntasYRespuestas;

import java.util.ArrayList;
import java.util.List;

public class Participante implements IParticipante {

	private String nombre;
	private Boolean puedeParticipar;
	private ServidorDeJuego servidor;
	private List<String> notificaciones;
	private List<String> preguntas;
	private Integer preguntaActual;
	
	public Participante (String nombre) {
		this.nombre = nombre;
		this.preguntaActual = 0;
		this.notificaciones = new ArrayList<String>();
		this.preguntas = new ArrayList<String>();
	}

	@Override
	public void update(ArrayList<String> preguntas) {
		this.preguntas = preguntas;
	}
	
	public void contestarPregunta(String respuesta) throws Exception {
		if (this.servidor == null) {
			System.out.println("El/La participante no se unio a ninguna partida");
			throw new Exception("El/La participante no se unio a ninguna partida");
		} else {
			String pregunta = this.preguntas.get(this.preguntaActual);
			this.servidor.verificarRespuesta(pregunta, respuesta, this);
		}
	}
	
	public void unirseAPartida(ServidorDeJuego servidor) throws Exception {
		this.servidor = servidor;
		this.servidor.agregarParticipante(this);
	}

	public void pasarASiguientePregunta() {
		this.preguntaActual++;
	}

	public void volverAIntentarPregunta() {
		this.agregarNotificacion("Respuesta incorrecta");
	}

	
	public String getNombre() {
		return this.nombre;
	}

	public void agregarNotificacion(String notificacion) {
		this.notificaciones.add(notificacion);
	}

	public List<String> getPreguntas() {
		return this.preguntas;
	}

	public List<String> getNotificaciones() {
		return this.notificaciones;
	}

	public Integer getPosicionPreguntaActual() {
		return this.preguntaActual;
	}

}
