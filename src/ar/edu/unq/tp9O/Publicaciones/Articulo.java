package ar.edu.unq.tp9O.Publicaciones;

public class Articulo {
	
	private String titulo;
	private String autor;
	private String filiacion;
	private String tipo;
	private String lugarDePublicacion;
	private String palabraClave;

	public Articulo (String titulo, String autor, String filiacion, String tipo, String lugarPublicacion, String palabraClave) {
		this.titulo = titulo;
		this.autor = autor;
		this.filiacion = filiacion;
		this.tipo = tipo;
		this.lugarDePublicacion = lugarPublicacion;
		this.palabraClave = palabraClave;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getAutor() {
		return this.autor;
	}
	
	public String getFiliacion() {
		return this.filiacion;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public String getLugarDePublicacion() {
		return this.lugarDePublicacion;
	}
	
	public String getPalabraClave() {
		return this.palabraClave;
	}
	
}
