package ar.edu.unq.tp6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp6.bancoYPrestamos.Cliente;
import ar.edu.unq.tp6.bancoYPrestamos.PropiedadInmobiliaria;
import ar.edu.unq.tp6.bancoYPrestamos.SolicitudDeCreditoHipotecario;

class SolicitudDeCreditoHipotecarioTest {
	
	private Cliente juan;
	private PropiedadInmobiliaria terreno;
	private SolicitudDeCreditoHipotecario solicitudJuan;
	private Cliente matias;
	private PropiedadInmobiliaria departamento;
	private SolicitudDeCreditoHipotecario solicitudMatias;

	@BeforeEach
	public void setUp() {
		terreno = new PropiedadInmobiliaria("Terreno", "Lavalle 54", 80000);
		juan = new Cliente("Juan", "Paez", "Sanchez 11", 67, 4000, terreno);
		solicitudJuan = new SolicitudDeCreditoHipotecario(juan, 60000, 12);
		departamento = new PropiedadInmobiliaria("Inmueble", "Acha 56", 900000);
		matias = new Cliente("Matias", "Mendez", "Pringles 22", 33, 40000, departamento);
		solicitudMatias = new SolicitudDeCreditoHipotecario(matias, 20000, 6);
	}

	@Test
	void test001_laSolicitudDeCreditoHipotecarioDeJuanNoEstaAprobada() {
		Boolean result = solicitudJuan.chequearAprobacion();
		assertFalse(result);
	}
	
	@Test
	void test002_laSolicitudDeCreditoHipotecarioDeMatiasEstaAprobada() {
		Boolean result = solicitudMatias.chequearAprobacion();
		assertTrue(result);
	}

}
