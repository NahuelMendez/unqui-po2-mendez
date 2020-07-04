package ar.edu.unq.tp4.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp4.ejercicio1.ProductoPrimeraNecesidad;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoPrimeraNecesidadTest {

	private ProductoPrimeraNecesidad leche;
	private ProductoPrimeraNecesidad arroz;
	
	@BeforeEach
	public void setUp() {
		leche = new ProductoPrimeraNecesidad("Leche", 8d, false, 11d);
		arroz = new ProductoPrimeraNecesidad("Arroz", 15d, true, 8d);
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(new Double(7.12), leche.getPrecio());
	}
	
	@Test
	public void testPrecioDeArroz() {
		Double resultado = arroz.getPrecio();
		assertEquals(13.8d, resultado);
	}
}
