package ar.edu.unq.tp6.ElementosSimilares;

import java.util.ArrayList;
import java.util.List;

public abstract class Filtro {

	public Filtro() {
		super();
	}

	public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
		List<WikipediaPage> paginasFiltradas = new ArrayList<WikipediaPage>();
		for (WikipediaPage wikipediaPage : wikipedia) {
			this.agregarAListaSiPasaElFiltro(paginasFiltradas, page, wikipediaPage);
		}
		return paginasFiltradas;
	}

	protected abstract void agregarAListaSiPasaElFiltro(List<WikipediaPage> paginasFiltradas, WikipediaPage page,
			WikipediaPage wikipediaPage);
	
	

}