package ar.edu.unq.tp8O.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.tp9O.Publicaciones.Articulo;
import ar.edu.unq.tp9O.Publicaciones.Laboratorio;
import ar.edu.unq.tp9O.Publicaciones.SistemaBibliografico;
import ar.edu.unq.tp9O.Publicaciones.TemaInteresAutor;

import static org.mockito.Mockito.*;

class SistemaBibliograficoTest {

	private SistemaBibliografico sistema;
	private Articulo articulo;
	private Laboratorio laboratorio;
	private TemaInteresAutor temaAutor;
	
	@BeforeEach
	public void setUp() {
		sistema = new SistemaBibliografico();
		laboratorio = new Laboratorio(sistema);
		articulo = new Articulo("Obras Smalltalk", "Eric Gamma", "Universidad", "Cientifico", "Estados Unidos", "Smalltalk");
		temaAutor = new TemaInteresAutor("Eric Gamma");
		laboratorio.suscribirseAlSistema(temaAutor);
	}
	
	@Test
	void test_UnSistemaNotificaASusObserversLaCargaDeUnArticulo(){
		sistema.agregarArticulo(articulo);
		Integer cantidadArticulos = laboratorio.getArticulosRecibidos().size();
		assertEquals(1, cantidadArticulos);
	}
	
	@Test
	void test_unObservadorRecibeUnaNotificacionDeUnArticuloQueNoLeInteresaYNoLoGuarda() {
		Articulo articulo2 = mock(Articulo.class);
		when(articulo2.getAutor()).thenReturn("Kent Beck");
		sistema.agregarArticulo(articulo2);
		Integer cantidadDeArticulos = laboratorio.getArticulosRecibidos().size();
		assertEquals(0, cantidadDeArticulos);
	}

}
