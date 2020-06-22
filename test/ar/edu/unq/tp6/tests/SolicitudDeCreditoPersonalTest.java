package ar.edu.unq.tp6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp7.SueldosRecagardo.Cliente;
import ar.edu.unq.tp7.SueldosRecagardo.PropiedadInmobiliaria;
import ar.edu.unq.tp7.SueldosRecagardo.SolicitudDeCreditoPersonal;

class SolicitudDeCreditoPersonalTest {
	
	private Cliente juan;
	private PropiedadInmobiliaria terreno;
	private SolicitudDeCreditoPersonal solicitudJuan;
	private Cliente matias;
	private PropiedadInmobiliaria departamento;
	private SolicitudDeCreditoPersonal solicitudMatias;

	@BeforeEach
	public void setUp() {
		terreno = new PropiedadInmobiliaria("Terreno", "Lavalle 54", 300000);
		juan = new Cliente("Juan", "Paez", "Sanchez 11", 67, 4000, terreno);
		solicitudJuan = new SolicitudDeCreditoPersonal(juan, 60000, 12);
		departamento = new PropiedadInmobiliaria("Inmueble", "Acha 56", 900000);
		matias = new Cliente("Matias", "Mendez", "Pringles 22", 33, 40000, departamento);
		solicitudMatias = new SolicitudDeCreditoPersonal(matias, 20000, 6);
	}
	
	@Test
	void test001_laSolicitudDeCreditoDeJuanTieneMontoMensualPor5000() {
		Integer result = solicitudJuan.calcularMontoMensual();
		assertEquals(5000, result);
	}
	
	@Test
	void test002_elMontoDeLaSolicitudDeJuanEsDe60000() {
		Integer result = solicitudJuan.getMonto();
		assertEquals(60000, result);
	}
	
	@Test
	void test003_laSolicitudDeMatiasEstaAprobada() {
		Boolean result = solicitudMatias.chequearAprobacion();
		assertTrue(result);
	}
	
	@Test
	void test004_laSolicitudDeJuanNoEstaAprobada() {
		Boolean result = solicitudJuan.chequearAprobacion();
		assertFalse(result);
	}

}
