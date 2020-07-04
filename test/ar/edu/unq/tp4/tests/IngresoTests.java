package ar.edu.unq.tp4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp4.ejercicio2.Ingreso;

public class IngresoTests {
	
	private Ingreso ingreso;
	
	@BeforeEach
	public void setUp() {
		ingreso = new Ingreso("Mayo", "Trabajo", 12000d);
	}
	
	@Test
	public void test001_unIngresoTieneMonto12000() {
		Double resultado = ingreso.getMonto();
		assertEquals(12000d, resultado);
	}
	
	@Test
	public void test002_unIngresoTieneMontoPonible12000() {
		Double resultado = ingreso.getMontoImponible();
		assertEquals(12000d, resultado);
	}

}
