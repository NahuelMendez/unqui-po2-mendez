package ar.edu.unq.tp9O.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import ar.edu.unq.tp9O.preguntasYRespuestas.Participante;
import ar.edu.unq.tp9O.preguntasYRespuestas.ServidorDeJuego;

class ParticipanteTest {
	
	private Participante participante;
	private ArrayList<String> preguntas;
	@Mock private ServidorDeJuego servidor;
	
	@BeforeEach
	public void setUp() {
		this.servidor = mock(ServidorDeJuego.class);
		this.participante = new Participante("Jose");
		this.preguntas = new ArrayList<String>();
		preguntas.add("pregunta A");
		preguntas.add("pregunta B");
		preguntas.add("pregunta C");
		preguntas.add("pregunta D");
		preguntas.add("pregunta E");
	}

	@Test
	void test_Constructor_UnParticipanteTieneNombreJose() {
		String result = participante.getNombre();
		assertEquals("Jose", result);
	}
	
	@Test
	void test_UnParticipanteContestaLaPrimeraPregunta() throws Exception {
		this.participante.unirseAPartida(servidor);
		this.participante.update(preguntas);
		this.participante.contestarPregunta("A");
		verify(servidor).verificarRespuesta(this.participante.getPreguntas().get(0), "A", participante);
	}
	
	@Test
	void test_UnParticipanteQueQuiereContestarUnaPreguntaSinUnirseAUnaPartidaDaError() throws Exception {
		assertThrows(Exception.class, () -> this.participante.contestarPregunta("B"));
	}
	
	@Test
	void test_CuandoUnParticipantePasaALaSiguientePreguntaSuPreguntaActualSeIncrementa() {
		Integer posicionPreguntaAnterior = this.participante.getPosicionPreguntaActual();
		this.participante.pasarASiguientePregunta();
		Integer posicionPreguntaActual = this.participante.getPosicionPreguntaActual();
		assertEquals(0, posicionPreguntaAnterior);
		assertEquals(1, posicionPreguntaActual);
	}
	
	@Test
	void test_CuandoUnParticipanteTieneQueVolverAContestarLaPreguntaRecibeUnaNotificacion() {
		Integer posicionPreguntaAnterior = this.participante.getPosicionPreguntaActual();
		this.participante.volverAIntentarPregunta();
		Integer posicionPreguntaActual = this.participante.getPosicionPreguntaActual();
		assertEquals(0, posicionPreguntaAnterior);
		assertEquals(0, posicionPreguntaActual);
		String notificacionRecibida = this.participante.getNotificaciones().get(this.participante.getNotificaciones().size() - 1);
		assertEquals("Respuesta incorrecta", notificacionRecibida);
	}

}
