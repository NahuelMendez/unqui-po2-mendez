package ar.edu.unq.tp5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp5.ProductoTradicional;

class ProductoTradicionalTest {
	
	private ProductoTradicional yerba;
	private ProductoTradicional celular;
	
	@BeforeEach
	public void setUp() {
		yerba = new ProductoTradicional(50, 100);
		celular = new ProductoTradicional(7000, 10);
	}

	@Test
	void test001_productoTradicionalYerbaTieneCosto50() {
		Integer result = yerba.calcularCosto();
		assertEquals(50, result);
	}
	
	@Test
	void test002_productoTradicionalCelularTieneCosto7000() {
		Integer result = celular.calcularCosto();
		assertEquals(7000, result);
	}

}
