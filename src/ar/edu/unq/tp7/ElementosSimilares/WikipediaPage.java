package ar.edu.unq.tp7.ElementosSimilares;

import java.util.List;
import java.util.Map;

public interface WikipediaPage {

	public String getTitle(); 
	/*retorna el título de la página.*/
	
	public List<WikipediaPage> getLinks(); 
	/*retorna una Lista de las páginas de
	Wikipedia con las que se conecta.*/
	
	public Map<String, WikipediaPage> getInfobox(); 
	/*retorna un Map con un valor en
	texto y la pagina que describe ese valor que aparecen en los infobox de la
	página de Wikipedia.*/
	
}
