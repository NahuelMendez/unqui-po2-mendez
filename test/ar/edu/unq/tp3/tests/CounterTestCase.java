package ar.edu.unq.tp3.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp3.Counter;

class CounterTestCase {

	private Counter counter;
	
	@BeforeEach
	public void setUp() {
		counter = new Counter();
		
		counter.agregarNumero(1);
		counter.agregarNumero(3);
		counter.agregarNumero(5);
		counter.agregarNumero(7);
		counter.agregarNumero(9);
		counter.agregarNumero(1);
		counter.agregarNumero(1);
		counter.agregarNumero(1);
		counter.agregarNumero(1);
		counter.agregarNumero(4);
		
	}
	
	@Test
	void test001_unCounterTiene1NumerosPar() {
		Integer cantidad = counter.getNumerosPares();
		assertEquals(1, cantidad);
	}

	@Test
	void test002_unCounterTiene2NumerosImpares() {
		counter.agregarNumero(2);
		Integer cantidad = counter.getNumerosPares();
		assertEquals(2, cantidad);
	}
	
	@Test
	void test003_unCounterTiene9NumerosImpares() {
		Integer cantidad = counter.getNumerosImpares();
		assertEquals(9, cantidad);
	}
	
	@Test
	void test004_unCounterTiene10NumerosImpares() {
		counter.agregarNumero(7);
		Integer cantidad = counter.getNumerosImpares();
		assertEquals(10, cantidad);
	}
	
	@Test
	void test005_unCounterTiene2NumerosMultiplosDe2() {
		counter.agregarNumero(6);
		Integer cantidad = counter.getMultiplosDe(2);
		assertEquals(2, cantidad);
	}
	
	@Test
	void test006_unCounterTiene1NumeroMultiploDe5() {
		Integer result = counter.getMultiplosDe(5);
		assertEquals(1, result);
	}
}
