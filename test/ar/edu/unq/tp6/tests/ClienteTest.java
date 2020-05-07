package ar.edu.unq.tp6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp6.Cliente;
import ar.edu.unq.tp6.PropiedadInmobiliaria;
import ar.edu.unq.tp6.SolicitudDeCredito;
import ar.edu.unq.tp6.SolicitudDeCreditoPersonal;

class ClienteTest {
	
	private Cliente pepe;
	private Cliente juli;
	private PropiedadInmobiliaria departamento;
	private PropiedadInmobiliaria chalet;
	private SolicitudDeCreditoPersonal creditoPepe;
	private SolicitudDeCreditoPersonal creditoJuli;
	
	@BeforeEach
	public void setUp() {
		
		departamento = new PropiedadInmobiliaria("Inmueble", "Calchaqui 12", 450000);
		chalet = new PropiedadInmobiliaria("Inmueble", "Cerrito 33", 750000);
		pepe = new Cliente("Pepe", "Sanchez", "Libertador 223", 62, 30000, chalet);
		juli = new Cliente("Julieta", "Paez", "Acha 23", 30, 20000, departamento);
		creditoPepe = new SolicitudDeCreditoPersonal(pepe, 40000, 6);
		
	}
	
	@Test
	void test001_clientePepeTieneComoSueldoNetoAnual360000Pesos() {
		Integer result = pepe.calcularSueldoNetoAnual();
		assertEquals(360000, result);
	}
	
	@Test
	void test002_clienteJulietaTieneComoSueldoNetoAnual240000Pesos() {
		Integer result = juli.calcularSueldoNetoAnual();
		assertEquals(240000, result);
	}
	
	@Test
	void test003_elValorFiscalDeLaPropiedadDePepeEsDe750000() {
		Integer result = pepe.getPropiedadInmobiliaria().getValorFiscal();
		assertEquals(750000, result);
	}

}
