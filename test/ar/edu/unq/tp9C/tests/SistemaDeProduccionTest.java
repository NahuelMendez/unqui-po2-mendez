package ar.edu.unq.tp9C.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito.*;

import ar.edu.unq.tp9C.cultivos.RegionDeCultivo;
import ar.edu.unq.tp9C.cultivos.SistemaDeProduccion;
import ar.edu.unq.tp9C.cultivos.Soja;
import ar.edu.unq.tp9C.cultivos.Trigo;

class SistemaDeProduccionTest {
	
	private Trigo trigo1;
	private Trigo trigo2;
	private Soja soja1;
	private Soja soja2;
	private RegionDeCultivo region;
	private Trigo trigoR1;
	private Trigo trigoR2;
	private Soja sojaR1;
	private Soja sojaR2;
	private SistemaDeProduccion cliente;
	
	@BeforeEach
	public void setUp() {
		trigo1 = new Trigo();
		trigo2 = new Trigo();
		trigoR1 = new Trigo();
		trigoR2 = new Trigo();
		soja1 = new Soja();
		soja2 = new Soja();
		sojaR1 = new Soja();
		sojaR2 = new Soja();
		region = new RegionDeCultivo();
		region.agregarCultivo(trigoR1);
		region.agregarCultivo(sojaR2);
		region.agregarCultivo(sojaR1);
		region.agregarCultivo(trigoR2);
		cliente = new SistemaDeProduccion();
		cliente.agregarCultivoAProduccion(soja1);
		cliente.agregarCultivoAProduccion(soja2);
		cliente.agregarCultivoAProduccion(trigo1);
		cliente.agregarCultivoAProduccion(trigo2);
	}
	
	@Test
	void testUnSistemaDeProduccionCon4CultivosSimplesY1UnCultivoCompuestoDe4TieneGananciaAnualDeAAPesos() {
		cliente.agregarCultivoAProduccion(region);
		Integer result = cliente.calcularGananciasDeTierrasProductivas();
		assertEquals(2000, result);
	}
	
	@Test
	void testUnSistemaDeProduccionCon4CultivosSimplesTienenGananciaAnualDe1600Pesos() {
		Integer result = cliente.calcularGananciasDeTierrasProductivas();
		assertEquals(1600, result);
	}

}
