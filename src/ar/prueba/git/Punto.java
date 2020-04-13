package ar.prueba.git;

public class Punto {
	
	private float x, y;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Punto(float x, float y) {
		this.setXY(x, y);
	}
	
	public void setXY(float x, float y) {
		this.setX(x);
		this.setY(y);
	}

}
