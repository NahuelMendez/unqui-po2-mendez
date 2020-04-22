package ar.edu.unq.tp4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp4.Ingreso;
import ar.edu.unq.tp4.IngresoHorasExtra;
import ar.edu.unq.tp4.Trabajador;

class TrabajadorTests {

	private Trabajador pepe;
	private Ingreso abril;
	private Ingreso mayo;
	private IngresoHorasExtra hsAbril;
	private IngresoHorasExtra hsMayo;
	
	@BeforeEach
	public void setUp() {
		
		pepe = new Trabajador();
		abril = new Ingreso("Abril", "Trabajo", 12000d);
		hsAbril = new IngresoHorasExtra("Abril", "Horas Extra", 1200d, 8);
		mayo = new Ingreso("Mayo", "Trabajo", 12000d);
		hsMayo = new IngresoHorasExtra("Mayo", "Horas Extra", 1000d, 6);
		
		pepe.agregarIngreso(abril);
		pepe.agregarIngreso(hsAbril);
		pepe.agregarIngreso(mayo);
		pepe.agregarIngreso(hsMayo);
		
	}
	
	@Test
	void test001_pepeTiene26200ComoTotalDeIngresosPercibidos() {
		Double ingresosPercibidos = pepe.getTotalPercibido();
		assertEquals(26200, ingresosPercibidos);
	}
	
	@Test
	void test002_pepeTiene24000ComoTotalDeMontoImponible() {
		Double totalMontoImponible = pepe.getMontoImponible();
		assertEquals(24000d, totalMontoImponible);
	}
	
	@Test
	void test003_pepeTiene480ComoImpuestoAPagar() {
		Double impuestoAnual = pepe.getImpuestoAPagar();
		assertEquals(480d, impuestoAnual);
	}

}
