package ar.edu.unq.tp9O.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.tp9O.Publicaciones.Articulo;
import ar.edu.unq.tp9O.Publicaciones.Laboratorio;
import ar.edu.unq.tp9O.Publicaciones.SistemaBibliografico;


import static org.mockito.Mockito.*;

import java.util.Set;

class LaboratorioTest {

	private Laboratorio laboratorio;
	@Mock private SistemaBibliografico sistema;
	@Mock private Articulo articulo;
	
	@BeforeEach
	public void setUp() {
		sistema = mock(SistemaBibliografico.class);
		laboratorio = new Laboratorio(sistema);
		articulo = mock(Articulo.class);
	}
	
	@Test
	void test_UnLaboratorioCargaUnArticuloNuevoEnUnSistemaBibliografico() {
		laboratorio.cargarArticulo(articulo);
		verify(sistema).agregarArticulo(articulo);
	}
	
	@Test
	void test_UnLaboratorioSeSuscribeAUnSistema() {
		laboratorio.suscribirseAlSistema(Set.of("Smalltalk"));
		verify(sistema).agregarSuscriptor(laboratorio, Set.of("Smalltalk"));
	}
	
	
	
	

}
