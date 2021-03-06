package ar.edu.unq.tp5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp5.laCajaDelMercadoCentral.Cliente;
import ar.edu.unq.tp5.laCajaDelMercadoCentral.ProductoCooperativa;
import ar.edu.unq.tp5.laCajaDelMercadoCentral.ProductoTradicional;

class ClienteTest {
	
	private Cliente pepe;
	private ProductoCooperativa mesa;
	private ProductoTradicional TV;
	
	@BeforeEach
	public void setUp() {
		pepe = new Cliente();
	}

	@Test
	void test001_empleadoPepeSinProductosTiene0CantidadDeProductos() {
		Integer result = pepe.getCobrables().size();
		assertEquals(0, result);
	}
	
	@Test
	void test002_empleadoPepeAgrega2ProductosParaComprarYSuCantidadDeProductosEs2() {
		pepe.agregarCobrable(mesa);
		pepe.agregarCobrable(TV);
		Integer result = pepe.getCobrables().size();
		assertEquals(2, result);
	}
	
}
