package ar.edu.unq.tp8O.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp9O.EncuentrosDeportivos.GestorDeportivo;
import ar.edu.unq.tp9O.EncuentrosDeportivos.Partido;
import ar.edu.unq.tp9O.EncuentrosDeportivos.ServidorDeportivo;

class GestorDeportivoTest {
	
	private GestorDeportivo gestor;
	private Partido partido;
	private ServidorDeportivo servidor;
	
	@BeforeEach
	public void setUp() {
		this.gestor = new GestorDeportivo();
		this.partido = new Partido("Gana Federer", List.of("Federer", "Nadal"), "Tenis");
		this.servidor = new ServidorDeportivo();
		
	}

	@Test
	void test_UnServidorRecibeInformacionTenis() {
		servidor.suscribirseAGestorDeportivo(gestor, "Tenis");
		gestor.recibirPartido(partido);
		assertTrue(servidor.getPartidosRecibidos().contains(partido));
	}
	
	@Test
	void test_UnServidorSeSuscribeConInteresFedererYRecibeUnPartido() {
		servidor.suscribirseAGestorDeportivo(gestor, "Federer");
		gestor.recibirPartido(partido);
		assertTrue(servidor.getPartidosRecibidos().contains(partido));
	}
	
	@Test
	void test_unServidorSeSuscribeConInteresEnDeporteFutbolYNoRecibeNingunaNotificacion() {
		servidor.suscribirseAGestorDeportivo(gestor, "Futbol");
		gestor.recibirPartido(partido);
		assertFalse(servidor.getPartidosRecibidos().contains(partido));
	}
	
	@Test
	void test_unServidorSeSuscribeATenisYNadalYRecibeUnPartidoConEsosAspectos() {
		servidor.suscribirseAGestorDeportivo(gestor, "Nadal");
		servidor.suscribirseAGestorDeportivo(gestor, "Tenis");
		gestor.recibirPartido(partido);
		assertTrue(servidor.getPartidosRecibidos().contains(partido));
		assertEquals(1, servidor.getPartidosRecibidos().size());
	}
	

}
