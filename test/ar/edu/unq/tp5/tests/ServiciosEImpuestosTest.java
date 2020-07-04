package ar.edu.unq.tp5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp5.laCajaDelMercadoCentral.Impuesto;
import ar.edu.unq.tp5.laCajaDelMercadoCentral.Servicio;

class ServiciosEImpuestosTest {
	
	private Servicio luz;
	private Servicio hotel;
	private Impuesto seguridadSocial;
	private Impuesto impuestoNacional;
	
	@BeforeEach
	public void setUp() {
		luz = new Servicio(50, 5);
		hotel = new Servicio(300, 2);
		seguridadSocial = new Impuesto(120);
		impuestoNacional = new Impuesto(100);
	}

	@Test
	void test001_unServicioDeLuzCuesta250PesosTieneGastoPorUnidadDe50YCantidadDeConsumos5() {
		Integer result = luz.calcularCosto();
		assertEquals(250, result);
	}
	
	@Test
	void test002_unServicioDeHotelCuesta600PesosPor2ConsumosA300() {
		Integer result = hotel.calcularCosto();
		assertEquals(600, result);
	}

	@Test
	void test003_elImpuestoASeguridadSocialTieneTasaFijaDe120Pesos() {
		Integer result = seguridadSocial.calcularCosto();
		assertEquals(120, result);
	}
	
	@Test
	void test004_elImpuestoNacionalTieneTasaFijaDe100Pesos() {
		Integer result = impuestoNacional.calcularCosto();
		assertEquals(100, result);
	}
}
