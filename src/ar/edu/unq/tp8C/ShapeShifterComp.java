package ar.edu.unq.tp8C;

import java.util.ArrayList;
import java.util.List;

public class ShapeShifterComp extends ShapeShifter {
	
	private Integer depth;
	private List<ShapeShifter> shapeShifters;

	public ShapeShifterComp(IShapeShifter shapeShifter1, IShapeShifter shapeShifter2) {
		this.depth = shapeShifter1.deepest() + shapeShifter2.deepest();
		shapeShifters = new ArrayList<ShapeShifter>();
		shapeShifters.add(shapeShifter1);
		shapeShifters.add(shapeShifter2);
	}

	private ShapeShifterComp(Integer num) {
		this.depth = num;
	}

	@Override
	public IShapeShifter compose(IShapeShifter ishapeShifter) {
		IShapeShifter sSComp = new ShapeShifterComp(this, ishapeShifter);
		return sSComp;
	}

	@Override
	public Integer deepest() {
		Integer resultado = 0;
		for (IShapeShifter iShapeShifter : shapeShifters) {
			if (iShapeShifter.deepest() > resultado) {
				resultado = iShapeShifter.deepest();
			}
		}
		return resultado;
	}

	@Override
	public IShapeShifter flat() {
		ShapeShifterComp shapeNuevo = new ShapeShifterComp(1);
		if (this.deepest() >= 1) {
			for (IShapeShifter iShapeShifter : shapeShifters) {
				iShapeShifter.setDepth(1);
			}
			return this;
		} else {
			return this;
		}
	}

	@Override
	public List<Integer> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addShapeShifter(IShapeShifter iShapeShifter) {
		
	}
}
