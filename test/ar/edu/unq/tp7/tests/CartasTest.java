package ar.edu.unq.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp7.Carta;



public class CartasTest {
	
	private Carta carta4C;
	
	@BeforeEach
	public void setUp() {
		carta4C = new Carta("4", "C");
	}

	@Test
	void testUnaCarta4CTieneComoValor4YComoPaloC() {
		assertEquals("4", carta4C.getValor());
		assertEquals("C", carta4C.getPalo());
	}
	
	@Test
	void testUnaCartaKCEsMayorA9D() {
		Carta cartaKC = new Carta("K", "C");
		Carta carta9D = new Carta("9", "D");
		Boolean kcEsMayor = cartaKC.esDeValorSuperiorA(carta9D);
		assertTrue(kcEsMayor);
	}
	
	@Test
	void testUnaCarta4CNoTieneValorSuperiorAJC() {
		Carta cartaJC = new Carta("J", "C");
		Boolean c4CMayorAJC = carta4C.esDeValorSuperiorA(cartaJC);
		assertFalse(c4CMayorAJC);
	}

}
