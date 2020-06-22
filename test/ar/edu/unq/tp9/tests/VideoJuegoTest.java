package ar.edu.unq.tp9.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp10.Videojuego.VideoJuego;

class VideoJuegoTest {
	
	private VideoJuego juego;
	
	@BeforeEach
	public void setUp() {
		this.juego = new VideoJuego();
	}

	@Test
	void test_UnJuegoNuevoComienzaSinFichas() {
		Integer result = this.juego.getFichas();
		assertEquals(0, result);
	}
	
	@Test
	void test_UnJuegoIngresaUnaFichaYTiene1CantidadDeFichas() {
		this.juego.agregarFicha();
		Integer result = this.juego.getFichas();
		assertEquals(1, result);
	}
	
	@Test
	void test_UnJuegoAlIniciarSinFichasMuestraElMensajeIngreseFichasParaJugar() {
		String result = this.juego.iniciar();
		assertEquals("Ingrese fichas para jugar", result);
	}
	
	@Test
	void test_UnJuegoIngresaUnaFichaYAlIniciarAhoraMuestraElMensajeComienzaElJuegoParaUnJugador() {
		this.juego.agregarFicha();
		String result = this.juego.iniciar();
		assertEquals("Comienza el juego para un jugador", result);
	}
	
	@Test
	void test_UnJuegoIngresaDosFichasYAlIniciarMuestraElMensajeComienzaElJuegoParaDosJugadores() {
		this.juego.agregarFicha();
		this.juego.agregarFicha();
		String result = this.juego.iniciar();
		assertEquals("Comienza el juego para dos jugadores", result);
	}
	
	@Test
	void test_UnJuegoAgregaUnaFichaYLuegoDeIniciarNoTieneFichas() {
		this.juego.agregarFicha();
		this.juego.iniciar();
		Integer result = juego.getFichas();
		assertEquals(0, result);
	}
	
	@Test
	void test_UnJuegoCargaDosFichasYLuegoDeIniciarSeQuedaSinFichas() {
		this.juego.agregarFicha();
		this.juego.agregarFicha();
		this.juego.iniciar();
		Integer result = juego.getFichas();
		assertEquals(0, result);
	}

}
