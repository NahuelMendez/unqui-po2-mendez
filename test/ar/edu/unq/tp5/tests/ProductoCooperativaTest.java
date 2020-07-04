package ar.edu.unq.tp5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp5.laCajaDelMercadoCentral.ProductoCooperativa;

class ProductoCooperativaTest {
	
	private ProductoCooperativa silla;
	private ProductoCooperativa mesa;
	
	@BeforeEach
	public void setUp() {
		silla = new ProductoCooperativa(200, 20);
		mesa = new ProductoCooperativa(500, 50);
	}

	@Test
	void test001_unProductoSillaTienePrecio180() {
		Integer result = silla.calcularCosto();
		assertEquals(180, result);
	}
	
	@Test
	void test002_unProductoMesaTienePrecio450() {
		Integer result = mesa.calcularCosto();
		assertEquals(450, result);
	}
	
	@Test
	void test003_cuandoElProductoMesaConStock50DisminuyeSuStockQuedan49() {
		mesa.reducirStock();
		Integer result = mesa.getStock();
		assertEquals(49, result);
	}
	
	@Test
	void test004_cuandoElProductoSillaConStock20DisminuyeSuStockQuedan19() {
		silla.reducirStock();
		Integer result = silla.getStock();
		assertEquals(19, result);
	}

}
