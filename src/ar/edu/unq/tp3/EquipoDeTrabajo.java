package ar.edu.unq.tp3;

import java.util.ArrayList;

public class EquipoDeTrabajo {

	private String nombre;
	private ArrayList<Persona2> integrantes;
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Integer edadPromedioDeIntegrantes() {
		Integer promedio = 0;
		for (Persona2 integrante: integrantes) {
			promedio += integrante.getEdad();
		}
		promedio /= integrantes.size();
		return promedio;
	}
	
	public EquipoDeTrabajo(String nombre) {
		this.nombre = nombre;
		this.integrantes = new ArrayList<Persona2>();
	}
	
	public void agregarIntegrante(Persona2 p) {
		this.integrantes.add(p);
	}
	
	/*public static void main(String[] args) {
		
		Persona2 juli = new Persona2("Juli", "Paez", 25);
		Persona2 juan = new Persona2("Juan", "Paez", 65);
		Persona2 martin = new Persona2("Martin", "Paez", 15);
		Persona2 nahuel = new Persona2("Nahuel", "Mendez", 29);
		Persona2 maestro = new Persona2("Maestre", "Trunkli", 14);
		
		EquipoDeTrabajo magios = new EquipoDeTrabajo("Magios");
		magios.agregarIntegrante(juli);
		magios.agregarIntegrante(juan);
		magios.agregarIntegrante(nahuel);
		magios.agregarIntegrante(martin);
		magios.agregarIntegrante(maestro);
		
		System.out.println(magios.edadPromedioDeIntegrantes());
	}
	*/
}
