package ar.edu.unq.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp8.Carta;
import ar.edu.unq.tp8.Jugada;
import ar.edu.unq.tp8.PokerStatus;

import static org.mockito.Mockito.*;

class PokerStatusTest {
	
	private Carta carta4P;
	private Carta carta4D;
	private Carta carta4C;
	private Carta carta4T;
	private Carta carta5T;
	private Carta carta3P;
	private Carta carta2D;
	private Carta carta6P;
	private Jugada jugada1;
	private Jugada jugada2;
	private PokerStatus pokerStatus;
	
	@BeforeEach
	public void setUp() {
		carta4P = new Carta("4", "P");
		carta4D = new Carta("4", "D");
		carta4C = new Carta("4", "C");
		carta4T = new Carta("4", "T");
		carta5T = new Carta("5", "T");
		carta3P = new Carta("3", "P");
		carta2D = new Carta("2", "D");
		carta6P = new Carta("6", "P");
		jugada1 = new Jugada(carta4P, carta4D, carta4T, carta4C, carta6P);
		jugada2 = new Jugada(carta4T, carta4D, carta4P, carta6P, carta5T);
		pokerStatus = new PokerStatus();
	}

	@Test
	void testPokerStatusVerificaPokerEnUnaJugada() {
		Boolean result = pokerStatus.verificarPoker(carta4P, carta4D, carta4C, carta4T, carta5T); 
		assertTrue(result);
	} 
	
	@Test
	void testPokerStatusVerificaQueNoEsPokerEnUnaJugada() {
		Boolean result = pokerStatus.verificarPoker(carta4P, carta3P, carta2D, carta6P, carta5T);
		assertFalse(result);
		}
	
	@Test
	void testUnPokerStatusAlVerificarUnaManoDeterminaPoker() {
		String result = pokerStatus.verificar(carta4P, carta4D, carta4C, carta4T, carta5T); 
		assertEquals("Poker", result);
	}
	
	@Test
	void testUnPokerStatusAlVerificarUnaManoDeterminaColor() {
		Carta carta2T = mock(Carta.class);
		Carta carta9T = mock(Carta.class);
		Carta cartaJT = mock(Carta.class);
		when(carta2T.getPalo()).thenReturn("T");
		when(carta9T.getPalo()).thenReturn("T");
		when(cartaJT.getPalo()).thenReturn("T");
		String result = pokerStatus.verificar(carta2T, carta9T, cartaJT, carta4T, carta5T); 
		assertEquals("Color", result);
	}
	
	@Test
	void testUnPokeStatusAlVerificarUnaManoDeterminaTrio() {
		String result = pokerStatus.verificar(carta4P, carta4D, carta4C, carta6P, carta5T); 
		assertEquals("Trio", result);
	}
	
	@Test
	void testUnPokerEstatusComparaJugada1YJugada2YDeclaraGanadorAJugada1() {
		Jugada result = pokerStatus.jugadaGanadoraContra(jugada1, jugada2);
		assertEquals(jugada1, result);
	}
}
