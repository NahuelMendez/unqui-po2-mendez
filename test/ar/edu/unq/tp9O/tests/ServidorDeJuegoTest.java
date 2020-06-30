package ar.edu.unq.tp9O.tests;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import ar.edu.unq.tp9O.preguntasYRespuestas.Participante;
import ar.edu.unq.tp9O.preguntasYRespuestas.ServidorDeJuego;
import static org.mockito.Mockito.*;

public class ServidorDeJuegoTest {
	
	private ServidorDeJuego servidorConJuegoEnCurso;
	private ServidorDeJuego servidorSinEmpezar;
	private Map<String, String> cuestionario;
	@Mock private Participante participante1;
	@Mock private Participante participante2;
	@Mock private Participante participante3;
	@Mock private Participante participante4;
	@Mock private Participante participante5;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.servidorConJuegoEnCurso = new ServidorDeJuego();
		this.servidorSinEmpezar = new ServidorDeJuego();
		this.cuestionario = new HashMap<String, String>();
		cuestionario.put("pregunta A", "A");
		cuestionario.put("pregunta B", "B");
		cuestionario.put("pregunta C", "C");
		cuestionario.put("pregunta D", "D");
		cuestionario.put("pregunta E", "E");
		participante1 = mock(Participante.class);
		participante2 = mock(Participante.class);
		participante3 = mock(Participante.class);
		participante4 = mock(Participante.class);
		participante5 = mock(Participante.class);
		this.servidorConJuegoEnCurso.agregarParticipante(participante1);
		this.servidorConJuegoEnCurso.agregarParticipante(participante2);
		this.servidorConJuegoEnCurso.agregarParticipante(participante3);
		this.servidorConJuegoEnCurso.agregarParticipante(participante4);
		this.servidorConJuegoEnCurso.agregarParticipante(participante5);
		this.servidorConJuegoEnCurso.recibirCuestionario(cuestionario);
	}

	@Test
	void test_UnServidorDeJuegoNuevoSinParticipantesTiene0CantidadDeParticipantes() {
		Integer result = this.servidorSinEmpezar.getParticipantes().size();
		assertEquals(0, result);
	}
	
	@Test
	void test_UnServidorDeJuegoAgrega1ParticipanteYTiene1CantidadDeParticipantes() throws Exception {
		this.servidorSinEmpezar.agregarParticipante(participante1);
		Integer result = this.servidorSinEmpezar.getParticipantes().size();
		assertEquals(1, result);
	}
	
	@Test
	void test_UnServidorSoloPuedeTener5ParticipantesALaVezConLaPartidaEnCurso() throws Exception {
		Participante participante6 = mock(Participante.class);
		assertThrows(Exception.class, () -> servidorConJuegoEnCurso.agregarParticipante(participante6));
		Integer result = this.servidorConJuegoEnCurso.getParticipantes().size();
		assertEquals(5, result);
	}
	
	@Test
	void test_UnServidorSoloPuedeTener5ParticipantesALaVezAntesDeComenzarLaPartida() throws Exception {
		this.servidorSinEmpezar.agregarParticipante(participante1);
		this.servidorSinEmpezar.agregarParticipante(participante2);
		this.servidorSinEmpezar.agregarParticipante(participante3);
		this.servidorSinEmpezar.agregarParticipante(participante4);
		this.servidorSinEmpezar.agregarParticipante(participante5);
		Participante participante6 = mock(Participante.class);
		assertThrows(Exception.class, () -> servidorSinEmpezar.agregarParticipante(participante6));
		Integer result = this.servidorConJuegoEnCurso.getParticipantes().size();
		assertEquals(5, result);
	}
	
	@Test
	void test_UnServidorQueNoEmpezoUnaPartidaNoPuedeVerificarUnaRespuesta() {
		assertThrows(Exception.class, () -> this.servidorSinEmpezar.verificarRespuesta("pregunta D", "D", participante1));
	}
	
	@Test
	void test_UnServidorRecibeUnCuestionarioCon3Preguntas() {
		this.servidorConJuegoEnCurso.recibirCuestionario(this.cuestionario);
		Integer result = this.servidorConJuegoEnCurso.getPreguntasDeLaRonda().size();
		assertEquals(5, result);
	}
	
	@Test
	void test_UnServidorRecibeUnaRespuestaCorrectaDeLaPreguntaA() throws Exception {
		assertTrue(this.servidorConJuegoEnCurso.verificarRespuesta("pregunta A", "A", participante1));
	}
	
	@Test
	void test_UnServidorRecibeUnaRespuestaIncorrectaDeLaPreguntaA() throws Exception {
		this.servidorConJuegoEnCurso.recibirCuestionario(this.cuestionario);
		assertFalse(this.servidorConJuegoEnCurso.verificarRespuesta("pregunta A", "C", participante1));
	}
	
	@Test
	void test_UnServidorRecibeUnaRespuestaCorrectaYLeAvisaAlParticipanteQueSeLaEnvio() throws Exception {
		this.servidorSinEmpezar.agregarParticipante(participante1);
		this.servidorSinEmpezar.recibirCuestionario(this.cuestionario);
		this.servidorSinEmpezar.verificarRespuesta("pregunta A", "A", participante1);
		verify(participante1).pasarASiguientePregunta();
	}
	
	@Test
	void test_UnServidorRecibeUnaRespuestaIncorrectaYLeAvisaAlParticipanteQueSeLaEnvio() throws Exception {
		this.servidorConJuegoEnCurso.recibirCuestionario(this.cuestionario);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta A", "B", participante1);
		verify(participante1).volverAIntentarPregunta();
	}
	
	@Test
	void test_UnServidorRecibeUnaRespuestaCorrectaYLeSumaUnPuntoAlParticipante() throws Exception {
		this.servidorSinEmpezar.agregarParticipante(participante1);
		this.servidorSinEmpezar.recibirCuestionario(this.cuestionario);
		this.servidorSinEmpezar.verificarRespuesta("pregunta A", "A", participante1);
		Integer result = this.servidorSinEmpezar.getPuntajeDeParticipante(participante1);
		assertEquals(1, result);
	}
	
	@Test
	void test_UnServidorRecibeUnaRespuestaIncorrectaYSuma0AlParticipanteQueSeLaEnvio() throws Exception {
		this.servidorSinEmpezar.agregarParticipante(participante1);
		this.servidorSinEmpezar.recibirCuestionario(this.cuestionario);
		this.servidorSinEmpezar.verificarRespuesta("pregunta A", "B", participante1);
		Integer result = this.servidorSinEmpezar.getPuntajeDeParticipante(participante1);
		assertEquals(0, result);
	}
	
	@Test
	void test_UnServidorCuandoComienzaConEstadoDeJuegoSinEmpezar() {
		String result = this.servidorSinEmpezar.getEstadoActual().getClass().getSimpleName();
		assertEquals("EstadoDeJuegoSinComenzar", result);
	}
	
	@Test
	void test_UnServidorCuandoTiene5ParticipantesYRecibeUnCuestionarioCambiaAEstadoDeJuegoEnCurso() throws Exception {
		String result = this.servidorConJuegoEnCurso.getEstadoActual().getClass().getSimpleName();
		assertEquals("EstadoDeJuegoEnCurso", result);
	}
	
	@Test
	void test_UnServidorLanzaUnErrorCuandoUnParticipanteQuiereAgregarseConLaPartidaEnCurso() throws Exception {
		Participante participante6 = mock(Participante.class);
		assertThrows(Exception.class, () -> servidorConJuegoEnCurso.agregarParticipante(participante6));
	}
	
	@Test
	void test_UnServidorNotificaATodosLosParticipantesDeLaRondaQueElParticipante1ContestoCorrectamenteLaPreguntaA() throws Exception {
		when(participante1.getNombre()).thenReturn("Jorge");
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta A", "A", participante1);
		String notificacion = "El/La participante Jorge contesto bien la pregunta pregunta A";
		verify(participante1).agregarNotificacion(notificacion);
		verify(participante2).agregarNotificacion(notificacion);
		verify(participante3).agregarNotificacion(notificacion);
		verify(participante4).agregarNotificacion(notificacion);
		verify(participante5).agregarNotificacion(notificacion);
	}
	
	@Test
	void test_UnServidorFinalizaLaPartidaCuandoElParticipante3ContestaLas5PreguntasCorrectamente() throws Exception {
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta A", "A", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta B", "B", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta C", "C", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta D", "D", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta E", "E", participante3);
		String result = this.servidorConJuegoEnCurso.getEstadoActual().getClass().getSimpleName();
		assertEquals("EstadoDeJuegoFinalizado", result);
	}
	
	@Test
	void test_UnServidorNoPuedeAgregarAUnParticipanteCuandoLaPartidaYaTermino() throws Exception {
		Participante participante6 = mock(Participante.class);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta A", "A", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta B", "B", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta C", "C", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta D", "D", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta E", "E", participante3);
		assertThrows(Exception.class, () -> this.servidorConJuegoEnCurso.agregarParticipante(participante6));
	}
	
	@Test
	void test_UnServidorNotificaALosParticipantesQueLaParticipanteJulietaGanaLaPartida() throws Exception {
		String notificacion = "El/La participante Julieta gana la partida";
		when(participante3.getNombre()).thenReturn("Julieta");
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta A", "A", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta B", "B", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta C", "C", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta D", "D", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta E", "E", participante3);
		verify(participante1).agregarNotificacion(notificacion);
		verify(participante2).agregarNotificacion(notificacion);
		verify(participante3).agregarNotificacion(notificacion);
		verify(participante4).agregarNotificacion(notificacion);
		verify(participante5).agregarNotificacion(notificacion);
	}
	
	@Test
	void test_UnServidorNoPuedeVerificarUnaRespuestaCuandoLaPartidaYaTermino() throws Exception {
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta A", "A", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta B", "B", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta C", "C", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta D", "D", participante3);
		this.servidorConJuegoEnCurso.verificarRespuesta("pregunta E", "E", participante3);
		assertThrows(Exception.class, () -> this.servidorConJuegoEnCurso.verificarRespuesta("pregunta A", "C", participante3));
	}
}
