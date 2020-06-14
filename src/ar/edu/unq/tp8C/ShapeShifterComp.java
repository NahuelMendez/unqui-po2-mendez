package ar.edu.unq.tp8C;

import java.util.ArrayList;
import java.util.List;

public class ShapeShifterComp implements IShapeShifter {
	
	private List<IShapeShifter> shapeShifters;
	
	public ShapeShifterComp() {
		this.shapeShifters = new ArrayList<IShapeShifter>();
	}

	@Override
	public IShapeShifter compose(IShapeShifter ishapeShifter) {
		ShapeShifterComp newShapeShifter = new ShapeShifterComp();
		newShapeShifter.addShapeShifter(ishapeShifter);
		newShapeShifter.addShapeShifter(this);
		return newShapeShifter;
	}

	@Override
	public Integer deepest() {
		Integer deepest = 1;
		for (IShapeShifter iShapeShifter : shapeShifters) {
			deepest += iShapeShifter.deepest();
		}
		return deepest;
	}

	@Override
	public IShapeShifter flat() {
		ShapeShifterComp newShape = new ShapeShifterComp();
		List<Integer> values = this.values();
		for (Integer value : values) {
			newShape.addShapeShifter(new ShapeShifterSimple(value));
		}
		return newShape;
	}

	@Override
	public List<Integer> values() {
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (IShapeShifter iShapeShifter : shapeShifters) {
			values.addAll(iShapeShifter.values());
		}
		return values;
	}
	
	public void addShapeShifter(IShapeShifter iShapeShifter) {
		this.shapeShifters.add(iShapeShifter);
	}
	
}
