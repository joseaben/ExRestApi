package es.abendev.Dao;

import java.util.List;

import es.abendev.beans.Pelicula;

public interface GenericDao {
	void create(Pelicula pelicula);
	List<Pelicula> read();
	void update(Pelicula pelicula);
	void delete(int id);
	
	
}
