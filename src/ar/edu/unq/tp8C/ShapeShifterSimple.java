package ar.edu.unq.tp8C;

import java.util.ArrayList;
import java.util.List;

public class ShapeShifterSimple extends ShapeShifter {
	
	private Integer value;
	private Integer depth;

	public ShapeShifterSimple(Integer value) {
		this.value = value;
		this.depth = 0;
	}

	public Integer getValue() {
		return this.value;
	}
	
	private void growDepth() {
		this.depth++;
	}

	@Override
	public IShapeShifter compose(IShapeShifter ishapeShifter) {
		this.growDepth();
		ShapeShifterComp sSComp = new ShapeShifterComp(this, ishapeShifter);
		return sSComp;
	}

	@Override
	public Integer deepest() {
		return this.depth;
	}

	@Override
	public IShapeShifter flat() {
		return this;
	}

	@Override
	public List<Integer> values() {
		List<Integer> values = new ArrayList<Integer>();
		values.add(this.getValue());
		return values;
	}
	
	public void setDepth(Integer num) {
		this.depth = num;
	}
}
