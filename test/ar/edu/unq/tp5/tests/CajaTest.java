package ar.edu.unq.tp5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp5.Caja;
import ar.edu.unq.tp5.Cliente;
import ar.edu.unq.tp5.Impuesto;
import ar.edu.unq.tp5.ProductoCooperativa;
import ar.edu.unq.tp5.ProductoTradicional;
import ar.edu.unq.tp5.Servicio;

class CajaTest {
	
	private Caja caja;
	private Cliente julieta;
	private Cliente juan;
	private Cliente martin;
	private ProductoTradicional TV;
	private ProductoCooperativa celular;
	private Servicio netflix;
	private Impuesto ANSES;
	private ProductoCooperativa arroz;
	
	@BeforeEach
	public void setUp() {
		
		caja = new Caja();
		juan = new Cliente();
		julieta = new Cliente();
		TV = new ProductoTradicional(5000, 20);
		celular = new ProductoCooperativa(4000, 10);
		julieta.agregarCobrable(TV);
		julieta.agregarCobrable(celular);
		martin = new Cliente();
		netflix = new Servicio(200, 1);
		ANSES = new Impuesto(300);
		martin.agregarCobrable(netflix);
		martin.agregarCobrable(TV);
		martin.agregarCobrable(ANSES);
		arroz = new ProductoCooperativa(100, 0);
		
	}

	@Test
	void test001_unaCajaQueRecienAbreTieneMontoACobrar0Pesos() {
		Integer result = caja.getMontoACobrar();
		assertEquals(0, result);
	}
	
	@Test
	void test002_unaCajaCobra5000AJuanQueComproUnTvDe5000EmpresaTradicional() {
		juan.agregarCobrable(TV);
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
	
	@Test
	void test005_despuesDeQueUnaCajaLeCobreAJulietaElSaldoSeInformaAlCliente() {
		caja.cobrarACliente(julieta);
		Integer result = julieta.getSaldoAPagar();
		assertEquals(8600, result);
	}
	
	@Test
	void test006_unaCajaLeCobraAClienteMartin5500EnConceptoDeUnaTvUnServicioNetflixeImpuestoAnses() {
		caja.cobrarACliente(martin);
		Integer result = martin.getSaldoAPagar();
		assertEquals(5500, result);
	}
	
	@Test
	void test007_unaCajaNoPuedeCobrarleAJuanUnProductoQueNoTieneStock() {
		juan.agregarCobrable(arroz);
		caja.cobrarACliente(juan);
		Integer result = juan.getSaldoAPagar();
		assertEquals(0, result);
	}

}
