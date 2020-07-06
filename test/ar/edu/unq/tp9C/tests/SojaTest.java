package ar.edu.unq.tp9C.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.tp9C.cultivos.Soja;

class SojaTest {

	@Test
	void testUnaSojaNuevaTieneComoGananciaAnual500Pesos() {
		Soja soja = new Soja();
		Integer result = soja.gananciaAnual();
		assertEquals(500, result);
	}

}
