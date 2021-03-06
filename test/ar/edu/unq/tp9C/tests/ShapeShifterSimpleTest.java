package ar.edu.unq.tp9C.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp9C.shapeShifter.ShapeShifterSimple;

class ShapeShifterSimpleTest {
	
	private ShapeShifterSimple sSimpleA;
	private ShapeShifterSimple sSimpleB;
	
	@BeforeEach
	public void setUp() {
		sSimpleA = new ShapeShifterSimple(1);
		sSimpleB = new ShapeShifterSimple(0);
	}

	@Test
	void testUnShapeShifterSimpleTieneValor1() {
		Integer valorEsperado = sSimpleA.getValue();
		assertEquals(1, valorEsperado);
	}
	
	@Test
	void testUnShapeShifterSimpleTieneValor2() {
		Integer valorEsperado = sSimpleB.getValue();
		assertEquals(0, valorEsperado);
	}
	
	@Test
	void testUnShapeSimpleTieneProfundidad0() {
		Integer result = sSimpleA.deepest();
		assertEquals(0, result);
	}

}
