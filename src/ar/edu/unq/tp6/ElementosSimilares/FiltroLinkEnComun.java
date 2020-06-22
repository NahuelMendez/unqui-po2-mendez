package ar.edu.unq.tp6.ElementosSimilares;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroLinkEnComun extends Filtro {

	@Override
	protected void agregarAListaSiPasaElFiltro(List<WikipediaPage> paginasFiltradas, WikipediaPage page,
			WikipediaPage wikipediaPage) {
		if (lasPaginasCompartenAlMenosUnLink(page, wikipediaPage)) {
			paginasFiltradas.add(wikipediaPage);
		}
		
	}

	private boolean lasPaginasCompartenAlMenosUnLink(WikipediaPage page, WikipediaPage wikipediaPage) {
		return page.getLinks().stream().filter(wikipediaPage.getLinks()::contains).collect(Collectors.toList()).size() >= 1;
	}

}
