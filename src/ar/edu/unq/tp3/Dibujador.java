package ar.edu.unq.tp3;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JFrame;

public class Dibujador extends JPanel {
	
	private Point p;
	private Cuadrado c;
	private Rectangulo r;
	
	public Dibujador() {
		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g) {
		
		p = new Point(50, 60);
		c = new Cuadrado(p, 250);
		r = new Rectangulo(p, 65, 200);
		super.paintComponent(g);
		g.drawRect(p.getX(), p.getY(), r.getAlto(), r.getAncho());
		g.setColor(Color.BLACK);
	}
	
	public static void main(String[] args) {
		
		Dibujador d = new Dibujador();
		JFrame f = new JFrame();
		f.add(d);
		f.setSize(400, 400);
		f.setVisible(true);
	}
}
