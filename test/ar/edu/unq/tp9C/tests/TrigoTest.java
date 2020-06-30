package ar.edu.unq.tp9C.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.tp9C.Trigo;

class TrigoTest {

	@Test
	void testUnTrigoNuevoTieneGananciaAnualDe300Pesos() {
		Trigo trigo = new Trigo();
		Integer result = trigo.gananciaAnual();
		assertEquals(300, result);
	}

}
