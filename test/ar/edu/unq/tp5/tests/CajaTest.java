package ar.edu.unq.tp5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp5.Caja;
import ar.edu.unq.tp5.Cliente;
import ar.edu.unq.tp5.ProductoCooperativa;
import ar.edu.unq.tp5.ProductoTradicional;

class CajaTest {
	
	private Caja caja;
	private Cliente julieta;
	private Cliente juan;
	private ProductoTradicional TV;
	private ProductoCooperativa celular;
	
	@BeforeEach
	public void setUp() {
		caja = new Caja();
		juan = new Cliente();
		julieta = new Cliente();
		TV = new ProductoTradicional(5000, 20);
		celular = new ProductoCooperativa(4000, 10);
		julieta.agregarProducto(TV);
		julieta.agregarProducto(celular);
	}

	@Test
	void test001_unaCajaQueRecienAbreTieneMontoACobrar0Pesos() {
		Integer result = caja.getMontoACobrar();
		assertEquals(0, result);
	}
	
	@Test
	void test002_unaCajaCobra5000AJuanQueComproUnTvDe5000EmpresaTradicional() {
		juan.agregarProducto(TV);
		caja.cobrarACliente(juan);
		Integer result = caja.getMontoACobrar();
		assertEquals(5000, result);
	}
	
	@Test
	void test003_unaCajaCobra8600AJulietaQueComproUnTvDe5000TradicionalYUnCelularDe4000Cooperativa() {
		caja.cobrarACliente(julieta);
		Integer result = caja.getMontoACobrar();
		assertEquals(8600, result);
	}
	
	@Test
	void test004_cuandoUnaCajaCobraAJulietaElStockDeTVyCelularDisminuyeUnaUnidad() {
		caja.cobrarACliente(julieta);
		Integer stockTV = TV.getStock();
		Integer stockCelular = celular.getStock();
		assertEquals(19, stockTV);
		assertEquals(9, stockCelular);
	}

}
