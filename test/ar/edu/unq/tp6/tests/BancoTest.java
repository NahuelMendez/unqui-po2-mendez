package ar.edu.unq.tp6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp7.SueldosRecagardo.Banco;
import ar.edu.unq.tp7.SueldosRecagardo.Cliente;
import ar.edu.unq.tp7.SueldosRecagardo.PropiedadInmobiliaria;
import ar.edu.unq.tp7.SueldosRecagardo.SolicitudDeCreditoHipotecario;
import ar.edu.unq.tp7.SueldosRecagardo.SolicitudDeCreditoPersonal;

class BancoTest {
	
	private Banco banco;
	private Cliente martin;
	private Cliente pepe;
	private PropiedadInmobiliaria terreno;
	private PropiedadInmobiliaria departamento;
	private SolicitudDeCreditoPersonal solicitudMartin;
	private SolicitudDeCreditoHipotecario solicitudPepe;

	@BeforeEach
	public void setUp() {
		banco = new Banco();
		terreno = new PropiedadInmobiliaria("Inmueble", "Gutierrez 55", 120000);
		departamento = new PropiedadInmobiliaria("Inmueble", "Pringles 78", 250000);
		martin = new Cliente("Martin", "Paez", "Sanches 11", 22, 18000, terreno);
		pepe = new Cliente("Pepe", "Martinez", "Cerrito 09", 60, 45000, departamento);
		solicitudMartin = new SolicitudDeCreditoPersonal(martin, 20000, 12);
		solicitudPepe = new SolicitudDeCreditoHipotecario(pepe, 40000, 18);
	}
	
	@Test
	void test001_unBancoQueRecienAbreTiene0Clientes() {
		Integer cantidadClientes = banco.getClientes().size();
		assertEquals(0, cantidadClientes);
	}
	
	@Test
	void test002_unBancoAgregaAlClienteMartinYTieneUnClienteRegistrado() {
		banco.agregarCliente(martin);
		Integer cantidadDeClientes = banco.getClientes().size();
		assertEquals(1, cantidadDeClientes);
	}
	
	@Test
	void test003_unBancoSinClientesNoTieneSolicitudesDeCreditoRegistradas() {
		Integer cantidadDeSolicitudesPendientes = banco.getSolicitudesPendientes().size();
		assertEquals(0, cantidadDeSolicitudesPendientes);
	}
	
	@Test
	void test004_unBancoRegistraUnaSolicitudDeUnClienteNuevoMartin() {
		banco.agregarCliente(martin);
		banco.registrarSolicitudDeCredito(martin.getSolicitudDeCredito());
		Integer cantidadDeSolicitudes = banco.getSolicitudesPendientes().size();
		assertEquals(1, cantidadDeSolicitudes);
	}
	
	@Test
	void test005_unBancoRegistraUnaSolicitudDeMartinYLaEvaluaOtorgandoElCredito() {
		banco.agregarCliente(martin);
		banco.registrarSolicitudDeCredito(martin.getSolicitudDeCredito());
		banco.evaluarSoliticudDeCredito(martin.getSolicitudDeCredito());
		Integer creditoOtorgado = martin.getCreditoObtenido();
		assertEquals(20000, creditoOtorgado);
	}
	
	@Test
	void test006_unBancoRegistraTodasLasSolicitudesDeSusClientesYLuegoLasEvaluaYOtorga() {
		banco.agregarCliente(martin);
		banco.agregarCliente(pepe);
		banco.registrarSolicitudes();
		banco.evaluarSolicitudesPendientes();
		Integer creditoMartin = martin.getCreditoObtenido();
		Integer creditoPepe = pepe.getCreditoObtenido();
		assertEquals(20000, creditoMartin);
		assertEquals(40000, creditoPepe);
	}

}






















