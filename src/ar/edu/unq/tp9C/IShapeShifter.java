package ar.edu.unq.tp9C;

import java.util.List;

public interface IShapeShifter {
	
	public IShapeShifter compose(IShapeShifter ishapeShifter);
	public Integer deepest();
	public IShapeShifter flat();
	public List<Integer> values();

}
