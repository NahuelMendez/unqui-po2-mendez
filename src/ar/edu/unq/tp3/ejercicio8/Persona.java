package ar.edu.unq.tp3.ejercicio8;

import java.time.LocalDate;

public class Persona {

	private String nombre;
	private LocalDate fechaDeNacimiento;
	
	public Persona(String nombre, LocalDate fechaDeNacimiento) {
		this.setNombre(nombre);
		this.setFechaDeNacimiento(fechaDeNacimiento);
	}
	
	public Boolean menorQue(Persona p) {
		return this.calcularEdad() < p.calcularEdad();
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNombre() {		
		return this.nombre;
	}
	
	public LocalDate getFechaDeNacimiento() {	
		return this.fechaDeNacimiento;	
	}
	
	public Integer calcularEdad() {
		LocalDate fechaActual = LocalDate.now();
		Integer edad = fechaActual.getYear() - this.getFechaDeNacimiento().getYear();  
		return edad;
	}
	
	public static void main(String[] args) {
		LocalDate nacimientoDeJuan = LocalDate.of(1965, 5, 30);
		LocalDate nacimientoJuli = LocalDate.of(1991, 1, 23);
		Persona juli = new Persona("Julieta", nacimientoJuli);
		Persona juan = new Persona("Juan", nacimientoDeJuan);
		System.out.println(juli.calcularEdad());
		System.out.println(juli.getNombre());
		System.out.println(juli.getFechaDeNacimiento());
		System.out.println(juan.menorQue(juli));
		System.out.println(juli.menorQue(juan));
	}
	
}
