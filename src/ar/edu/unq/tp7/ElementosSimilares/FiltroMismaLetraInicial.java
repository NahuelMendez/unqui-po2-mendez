package ar.edu.unq.tp7.ElementosSimilares;

import java.util.List;

public class FiltroMismaLetraInicial extends Filtro {
	
	protected void agregarAListaSiPasaElFiltro(List<WikipediaPage> paginasFiltradas, WikipediaPage page,
			WikipediaPage wikipediaPage) {
		if (lasPaginasTienenMismaInicial(page, wikipediaPage)) {
			paginasFiltradas.add(wikipediaPage);
		}
		
	}

	private Boolean lasPaginasTienenMismaInicial(WikipediaPage page, WikipediaPage wikipediaPage) {
		return page.getTitle().charAt(0) == (wikipediaPage.getTitle().charAt(0));
	}

}
