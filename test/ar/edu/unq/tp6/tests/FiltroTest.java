package ar.edu.unq.tp6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.unq.tp6.ElementosSimilares.Filtro;
import ar.edu.unq.tp6.ElementosSimilares.FiltroLinkEnComun;
import ar.edu.unq.tp6.ElementosSimilares.FiltroMismaLetraInicial;
import ar.edu.unq.tp6.ElementosSimilares.FiltroPropiedadEnComun;
import ar.edu.unq.tp6.ElementosSimilares.Page;
import ar.edu.unq.tp6.ElementosSimilares.WikipediaPage;

class FiltroTest {
	
	private Filtro filtroLetraInicial;
	private Filtro filtroLinkEnComun;
	private Filtro filtroPropiedadEnComun;
	@Mock private Page wikiPage1;
	@Mock private Page wikiPage2;
	@Mock private Page wikiPage3;
	@Mock private Page wikiPage4;
	@Mock private Page wikiPage5;
	private List<WikipediaPage> listaDeWikipages;
	private Map<String, WikipediaPage> mapDeWikiPage1;
	
	
	@BeforeEach
	public void setUp() {
		filtroLetraInicial = new FiltroMismaLetraInicial();
		filtroLinkEnComun = new FiltroLinkEnComun();
		filtroPropiedadEnComun = new FiltroPropiedadEnComun();
		wikiPage1 = mock(Page.class);
		wikiPage2 = mock(Page.class);
		wikiPage3 = mock(Page.class);
		wikiPage4 = mock(Page.class);
		wikiPage5 = mock(Page.class);
		listaDeWikipages = new ArrayList<WikipediaPage>();
		listaDeWikipages.add(wikiPage2);
		listaDeWikipages.add(wikiPage3);
		mapDeWikiPage1 = new HashMap<String, WikipediaPage>();
		mapDeWikiPage1.put("birth_place", wikiPage2);
		when(wikiPage1.getInfobox()).thenReturn(mapDeWikiPage1);
	}

	@Test
	void test_UnFiltroMimsaLetraInicialRecibeUnaPageYUnaListaVaciaYNoEncuentraSimilutes() {
		when(wikiPage1.getTitle()).thenReturn("Los arboles");
		List<WikipediaPage> listaDeWikipagesVacia = new ArrayList<WikipediaPage>();
		List<WikipediaPage> result = this.filtroLetraInicial.getSimilarPages(wikiPage1, listaDeWikipagesVacia);
		assertEquals(0, result.size());
	}

	@Test
	void test_UnFiltroMismaLetraInicialRecibeUnaPageYUnaListaDeWikiPagesYEncuentraDosSimilitudes() {
		when(wikiPage1.getTitle()).thenReturn("Los arboles");
		when(wikiPage2.getTitle()).thenReturn("Llanuras");
		when(wikiPage3.getTitle()).thenReturn("Lanus");
		List<WikipediaPage> result = this.filtroLetraInicial.getSimilarPages(wikiPage1, listaDeWikipages);
		assertEquals(2, result.size());
	}
	
	@Test
	void test_UnFiltroMismaLetraInicialRecibeUnaPageYUnaListaDeWikiPagesYEncuentraUnaSimilitud() {
		when(wikiPage1.getTitle()).thenReturn("Los arboles");
		when(wikiPage2.getTitle()).thenReturn("Hackers");
		when(wikiPage3.getTitle()).thenReturn("Lanus");
		List<WikipediaPage> result = this.filtroLetraInicial.getSimilarPages(wikiPage1, listaDeWikipages);
		assertEquals(1, result.size());
	}
	
	@Test
	void test_UnFiltroLinkEnComunRecibeUnaPageYUnaListaVaciaYNoEncuentraSimilitudes() {
		when(wikiPage1.getLinks()).thenReturn(Arrays.asList(wikiPage4, wikiPage5));
		List<WikipediaPage> listaDeWikipagesVacia = new ArrayList<WikipediaPage>();
		List<WikipediaPage> result = this.filtroLinkEnComun.getSimilarPages(wikiPage1, listaDeWikipagesVacia);
		assertEquals(0, result.size());
	}
	
	@Test
	void test_UnFiltroLinkEnComunRecibeUnaPageYUnaListaEncuentra1Similitud() {
		when(wikiPage1.getLinks()).thenReturn(Arrays.asList(wikiPage4, wikiPage5));
		when(wikiPage2.getLinks()).thenReturn(Arrays.asList(wikiPage3, wikiPage5));
		when(wikiPage3.getLinks()).thenReturn(Arrays.asList(wikiPage2, wikiPage1));
		List<WikipediaPage> result = this.filtroLinkEnComun.getSimilarPages(wikiPage1, listaDeWikipages);
		assertEquals(1, result.size());
	}
	
	@Test
	void test_UnFiltroLinkEnComunRecibeUnaPageYUnaListaEncuentra2Similitudes() {
		when(wikiPage1.getLinks()).thenReturn(Arrays.asList(wikiPage4, wikiPage5));
		when(wikiPage2.getLinks()).thenReturn(Arrays.asList(wikiPage3, wikiPage5));
		when(wikiPage3.getLinks()).thenReturn(Arrays.asList(wikiPage4, wikiPage5));
		List<WikipediaPage> result = this.filtroLinkEnComun.getSimilarPages(wikiPage1, listaDeWikipages);
		assertEquals(2, result.size());
	}
	
	@Test
	void test_UnFiltroPropiedadEnComunRecibeUnaPageYUnaListaVaciaYNoEncuentraSimilitudes() {
		List<WikipediaPage> listaDeWikipagesVacia = new ArrayList<WikipediaPage>();
		List<WikipediaPage> result = this.filtroPropiedadEnComun.getSimilarPages(wikiPage1, listaDeWikipagesVacia);
		assertEquals(0, result.size());
	}
	
	@Test
	void test_UnFiltroPropiedadEnComunRecibeUnaPageYUnaListaYEncuentraUnaSimilitud() {
		Map<String, WikipediaPage> mapConUnaSimilitud = new HashMap<String, WikipediaPage>();
		mapConUnaSimilitud.put("birth_place", wikiPage3);
		when(wikiPage2.getInfobox()).thenReturn(mapConUnaSimilitud);
		when(wikiPage3.getInfobox()).thenReturn(new HashMap<String, WikipediaPage>());
		List<WikipediaPage> result = this.filtroPropiedadEnComun.getSimilarPages(wikiPage1, listaDeWikipages);
		assertEquals(1, result.size());
	}
	
	@Test
	void test_UnFiltroPropiedadEnComunRecibeUnaPageYUnaListaYEncuentraDosSimilitudes() {
		Map<String, WikipediaPage> mapConDosSimilitudes = new HashMap<String, WikipediaPage>();
		mapConDosSimilitudes.put("birth_place", wikiPage5);
		when(wikiPage2.getInfobox()).thenReturn(mapConDosSimilitudes);
		when(wikiPage3.getInfobox()).thenReturn(mapConDosSimilitudes);
		List<WikipediaPage> result = this.filtroPropiedadEnComun.getSimilarPages(wikiPage1, listaDeWikipages);
		assertEquals(2, result.size());
	}
}
