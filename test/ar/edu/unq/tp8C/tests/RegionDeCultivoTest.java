package ar.edu.unq.tp8C.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.tp8C.RegionDeCultivo;
import ar.edu.unq.tp8C.Soja;
import ar.edu.unq.tp8C.Trigo;

class RegionDeCultivoTest {

	@Test
	void testUnaRegionDeCultivoQueTiene2DeSojaY2DeTrigoTieneGananciaAnualDe800Pesos() {
		Soja soja1 = new Soja();
		Soja soja2 = new Soja();
		Trigo trigo1 = new Trigo();
		Trigo trigo2 = new Trigo();
		RegionDeCultivo region = new RegionDeCultivo();
		region.agregarCultivo(soja1);
		region.agregarCultivo(soja2);
		region.agregarCultivo(trigo1);
		region.agregarCultivo(trigo2);
		Integer result = region.gananciaAnual();
		assertEquals(400, result);
	}

}
