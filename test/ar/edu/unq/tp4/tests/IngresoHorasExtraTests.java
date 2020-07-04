package ar.edu.unq.tp4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp4.ejercicio2.IngresoHorasExtra;

class IngresoHorasExtraTests {
	
	private IngresoHorasExtra horasExtra;

	@BeforeEach
	public void setUp() {
		horasExtra = new IngresoHorasExtra("Mayo", "Horas Extra", 1200d, 8);
	}
	
	@Test
	void test001_unIngresoDeHorasExtraNoTieneMontoPonibleEsDecirVale0() {
		Double result = horasExtra.getMontoImponible();
		assertEquals(0d, result);
	}

	@Test
	void test002_unIngresoDeHorasExtraTieneMonto1200() {
		Double result = horasExtra.getMonto();
		assertEquals(1200d, result);
	}
}
