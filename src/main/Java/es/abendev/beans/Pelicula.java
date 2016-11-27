package es.abendev.beans;

public class Pelicula {
	private int id;
	private String titulo;
	private String sinopsis;
	private String fecha;
	
	public Pelicula(int id, String titulo, String sinopsis, String fecha){
		this.id = id;
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.fecha = fecha;
	}
	public Pelicula(String titulo, String sinopsis, String fecha){
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
