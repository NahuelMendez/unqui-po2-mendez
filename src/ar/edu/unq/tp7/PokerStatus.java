package ar.edu.unq.tp7;

import java.util.ArrayList;

public class PokerStatus {
	
	public Boolean verificarPoker(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		ArrayList<Carta> cartas = this.crearMano(carta1, carta2, carta3, carta4, carta5);
		Boolean resultado = false;
		for (Carta carta : cartas) {
			resultado = resultado || this.hayPokerDe(carta, cartas);
		} 
		return resultado; 
	}
	
	public String verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		if (this.verificarPoker(carta1, carta2, carta3, carta4, carta5)) {
			return "Poker";
	    } else if (this.verificarColor(carta1, carta2, carta3, carta4, carta5)) {
	    	return "Color";
	    } else if (this.verificarTrio(carta1, carta2, carta3, carta4, carta5)) {
	    	return "Trio";
	    } else {
	    	return "Nada";
	    }
	}
		
		
	public Boolean verificarTrio(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		Boolean resultado = false;
		ArrayList<Carta> cartas = this.crearMano(carta1, carta2, carta3, carta4, carta5);
		for (Carta carta : cartas) {
			resultado = resultado || this.hayTrio(carta, cartas);
		}
		return resultado;
	}
	
	public Boolean verificarColor(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		Boolean resultado = false;
		ArrayList<Carta> cartas = this.crearMano(carta1, carta2, carta3, carta4, carta5);
		for (Carta carta : cartas) {
			resultado = resultado || this.hayColor(carta, cartas);
		}
		return resultado;
	}


	private Boolean hayColor(Carta numeroCarta, ArrayList<Carta> cartas) {
		Integer contador = 0;
		for (Carta carta: cartas) {
			if (carta.getPalo().equals(numeroCarta.getPalo())) {
				contador++;
			}
		}
		return contador == 5;
	}

	private Boolean hayTrio(Carta numeroCarta, ArrayList<Carta> cartas) {
		Integer contador = 0;
		for (Carta carta: cartas) {
			if (this.numCarta(carta) == (this.numCarta(numeroCarta))) {
				contador++;
			}
		}
		return contador == 3;
	}

	private ArrayList<Carta> crearMano(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(carta1);
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		return cartas;
	}


	public Boolean hayPokerDe(Carta numeroCarta, ArrayList<Carta> cartas) {
		Integer contador = 0;
		for (Carta carta: cartas) {
			if (this.numCarta(carta) == (this.numCarta(numeroCarta))) {
				contador++;
			}
		}
		return contador == 4;
	}

	public Jugada jugadaGanadoraContra(Jugada jugada1, Jugada jugada2) {
		String resultado1 = this.verificar(jugada1.getCartas().get(0), jugada1.getCartas().get(1), jugada1.getCartas().get(2), jugada1.getCartas().get(3), jugada1.getCartas().get(4));
		String resultado2 = this.verificar(jugada2.getCartas().get(0), jugada2.getCartas().get(1), jugada2.getCartas().get(2), jugada2.getCartas().get(3), jugada2.getCartas().get(4));
		if (resultado1.equals(resultado2)) {
			return this.ganadorPorValorEntre(jugada1, jugada2);
		} else {
			return this.ganadorEntre(jugada1, jugada2);
		}
	}

	private Jugada ganadorPorValorEntre(Jugada jugada1, Jugada jugada2) {
		Integer resultado1 = this.getValorNumericoTotal(jugada1.getCartas());
		Integer resultado2 = this.getValorNumericoTotal(jugada2.getCartas());
		if (resultado1 > resultado2) {
			return jugada1;
		} else {
			return jugada2;
		}
	}

	private Integer getValorNumericoTotal(ArrayList<Carta> cartas) {
		Integer resultado = 0;
		for (Carta carta : cartas) {
			resultado += carta.getValorNumerico();
		}
		return resultado;
	}

	private Jugada ganadorEntre(Jugada jugada1, Jugada jugada2) {
		String resultado1 = this.verificar(jugada1.getCartas().get(0), jugada1.getCartas().get(1), jugada1.getCartas().get(2), jugada1.getCartas().get(3), jugada1.getCartas().get(4));
		String resultado2 = this.verificar(jugada2.getCartas().get(0), jugada2.getCartas().get(1), jugada2.getCartas().get(2), jugada2.getCartas().get(3), jugada2.getCartas().get(4));
		if (resultado1.equals("Poker") && !(resultado2.equals("Poker"))) {
			return jugada1;
		} else if (resultado1.equals("Color") && resultado2.equals("Trio")) {
			return jugada1;
		} else if (resultado1.equals("Trio") && resultado2.equals("Nada")) {
			return jugada1;
		} else {
			return jugada2;
		}
	}

	public String numCarta(Carta carta) {
		return carta.getValor();
	}
}