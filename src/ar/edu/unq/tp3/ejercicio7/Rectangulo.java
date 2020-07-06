package ar.edu.unq.tp3.ejercicio7;

import ar.edu.unq.tp3.ejercicio6.Point;

public class Rectangulo {
	
	private Point puntoSupIzq;
	private Point puntoSupDer;
	private Point puntoInfIzq;
	private Point puntoInfDer;
	private Integer ancho;
	private Integer alto;
	
	public Point getPuntoSupIzq() {
		return puntoSupIzq;
	}
	
	public void setPuntoSupIzq(Point puntoSupIzq) {
		this.puntoSupIzq = puntoSupIzq;
	}
	
	public Integer getAncho() {
		return ancho;
	}
	
	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}
	
	public Integer getAlto() {
		return alto;
	}
	
	public void setAlto(Integer alto) {
		this.alto = alto;
	}
	
	public Rectangulo(Point p, Integer an, Integer al) {
		Point supD = new Point((p.getX() + an), p.getY());
		Point infD = new Point(supD.getX(), supD.getY() - al);
		Point infI = new Point(p.getX(), infD.getY());
		this.setPuntoSupIzq(p);
		this.setPuntoSupDer(supD);
		this.setPuntoInfDer(infD);
		this.setPuntoInfIzq(infI);
		this.setAncho(an);
		this.setAlto(al);
	}
	
	public Integer calcularArea() {
		Integer area = this.getAncho() * this.getAlto();
		return area;
	}
	
	public Integer calcularPerimetro() {
		Integer perimetro = this.getAlto() * 2 + this.getAncho() * 2;
		return perimetro;
	}

	public Point getPuntoSupDer() {
		return puntoSupDer;
	}

	public void setPuntoSupDer(Point puntoSupDer) {
		this.puntoSupDer = puntoSupDer;
	}

	public Point getPuntoInfIzq() {
		return puntoInfIzq;
	}

	public void setPuntoInfIzq(Point puntoInfIzq) {
		this.puntoInfIzq = puntoInfIzq;
	}

	public Point getPuntoInfDer() {
		return puntoInfDer;
	}

	public void setPuntoInfDer(Point puntoInfDer) {
		this.puntoInfDer = puntoInfDer;
	}
	
	public String determinarPosicion() {
		if (this.getAncho() > this.getAlto()) {
			return "Horizontal";
		} else if (this.getAncho() == this.getAlto()){
			return "Forma Cuadrada";
		} else {
			return "Vertical";
		}
	}
}
