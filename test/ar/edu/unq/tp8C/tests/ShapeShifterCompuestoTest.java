package ar.edu.unq.tp8C.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp8C.IShapeShifter;
import ar.edu.unq.tp8C.ShapeShifterSimple;

class ShapeShifterCompuestoTest {
	
	private IShapeShifter shapeS1;
	private IShapeShifter shapeS2;
	private IShapeShifter shapeS3;
	private IShapeShifter shapeC1;
	private IShapeShifter shapeC2;
	
	@BeforeEach
	public void setUp() {
		shapeS1 = new ShapeShifterSimple(1);
		shapeS2 = new ShapeShifterSimple(2);
		shapeS3 = new ShapeShifterSimple(3);
	}

	@Test
	void test_ShapeCompuestoTieneProfundidad1() {
		shapeC1 = shapeS1.compose(shapeS2);
		Integer result = shapeC1.deepest();
		assertEquals(1, result);
	}
	
	@Test
	void test_ShapeCompuestoTieneOtroCompuestoAgregadoYUnaProfundidadDe2() {
		shapeC1 = shapeS1.compose(shapeS2);
		shapeC2 = shapeC1.compose(shapeS3);
		Integer result = shapeC2.deepest();
		assertEquals(2, result);
	}
	
	@Test
	void test_LaProfundidadDeUnShapeDeProfundidad2QueHaceFlatTieneProfundidad1() {
		shapeC1 = shapeS1.compose(shapeS2);
		shapeC2 = shapeC1.flat();
		Integer result = shapeC2.deepest();
		assertEquals(1, result);
	}
	
	@Test
	void test_LosValoresDeUnShapeCompuestoPor3SimplesSon123() {
		shapeC1 = shapeS1.compose(shapeS2);
		shapeC2 = shapeC1.compose(shapeS3);
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1); expected.add(2); expected.add(3);
		List<Integer> result = shapeC2.values();
		assertTrue(result.containsAll(expected));
	}
}
