package ar.edu.unq.tp3;

public class Point {
	
	private Integer x;
	private Integer y;
	
	public Point(Integer x, Integer y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Point() {
		this.setX(0);
		this.setY(0);
	}
	
	public void moverPunto(Integer x, Integer y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void sumarseAOtroPunto(Point p) {
		Integer nuevoX = this.x += p.getX();
		Integer nuevoY = this.y += p.getY();
		this.setX(nuevoX);
		this.setY(nuevoY);
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

}
