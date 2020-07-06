package ar.edu.unq.tp9O.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp9O.Publicaciones.Articulo;
import ar.edu.unq.tp9O.Publicaciones.Laboratorio;
import ar.edu.unq.tp9O.Publicaciones.SistemaBibliografico;


import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Set;

class SistemaBibliograficoTest {

	private SistemaBibliografico sistema;
	private Articulo articulo;
	private Laboratorio laboratorio;
	private Laboratorio otroLaboratorio;
	
	@BeforeEach
	public void setUp() {
		sistema = new SistemaBibliografico();
		laboratorio = new Laboratorio(sistema);
		otroLaboratorio = new Laboratorio(sistema);
		articulo = new Articulo("Obras Smalltalk", "Eric Gamma", "Universidad", "Cientifico", "Estados Unidos", "Smalltalk");
		laboratorio.suscribirseAlSistema(Set.of("Eric Gamma", "Literatura", "Salud"));
	}
	
	@Test
	void test_UnSistemaNotificaASusObserversLaCargaDeUnArticulo(){
		sistema.agregarArticulo(articulo);
		Integer cantidadArticulos = laboratorio.getNotificacionesRecibidas().size();
		assertEquals(1, cantidadArticulos);
	}
	
	@Test
	void test_unObservadorRecibeUnaNotificacionDeUnArticuloQueNoLeInteresaYNoLoGuarda() {
		Articulo articulo2 = mock(Articulo.class);
		when(articulo2.getDatosRelevantes()).thenReturn(List.of("Kent Beck", "TDD"));
		sistema.agregarArticulo(articulo2);
		Integer cantidadDeArticulos = laboratorio.getNotificacionesRecibidas().size();
		assertEquals(0, cantidadDeArticulos);
	}
	
	@Test
	void test_unObservadorCargaUnArticuloEnElSistemaBibliograficoYEsteLeNotificaAUnObservadorPorqueEsDeSuInteres() {
		Articulo articulo2 = mock(Articulo.class);
		when(articulo2.getDatosRelevantes()).thenReturn(List.of("Salud", "Literatura"));
		otroLaboratorio.cargarArticulo(articulo2);
		Integer cantidadDeArticulos = laboratorio.getNotificacionesRecibidas().size();
		assertEquals(2, cantidadDeArticulos);
	}

}
