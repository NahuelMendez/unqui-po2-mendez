package ar.edu.unq.tp8O.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.tp8O.Publicaciones.Articulo;
import ar.edu.unq.tp8O.Publicaciones.Laboratorio;
import ar.edu.unq.tp8O.Publicaciones.SistemaBibliografico;
import ar.edu.unq.tp8O.Publicaciones.TemaInteresTipo;

import static org.mockito.Mockito.*;

class LaboratorioTest {

	private Laboratorio laboratorio;
	@Mock private SistemaBibliografico sistema;
	@Mock private Articulo articulo;
	@Mock private TemaInteresTipo tipoCientifico;
	
	@BeforeEach
	public void setUp() {
		sistema = mock(SistemaBibliografico.class);
		tipoCientifico = mock(TemaInteresTipo.class);
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
		laboratorio.suscribirseAlSistema(tipoCientifico);
		verify(sistema).agregarObserver(laboratorio, tipoCientifico);
	}
	
	
	

}
