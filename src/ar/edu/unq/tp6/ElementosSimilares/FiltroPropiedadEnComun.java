package ar.edu.unq.tp6.ElementosSimilares;

import java.util.List;

public class FiltroPropiedadEnComun extends Filtro {

	@Override
	protected void agregarAListaSiPasaElFiltro(List<WikipediaPage> paginasFiltradas, WikipediaPage page,
			WikipediaPage wikipediaPage) {
		if(lasPaginasCompartenPropiedadesDeInfobox(page, wikipediaPage)) {
			paginasFiltradas.add(wikipediaPage);
		}
		
	}

	private Boolean lasPaginasCompartenPropiedadesDeInfobox(WikipediaPage page, WikipediaPage wikipediaPage) {
		Boolean result = false;
		for (String key : page.getInfobox().keySet()) {
			result |= wikipediaPage.getInfobox().containsKey(key);
		}
		return result;
	}

}
