package es.abendev.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;

import es.abendev.Dao.PeliculasDao;
import es.abendev.beans.Pelicula;

@Path("/servicioRest/")
@Produces("application/json")
public class ServicioRest {
	@GET
	@Path("/Peliculas")
	public List<Pelicula> consultaPeliculas(){
		PeliculasDao peliculasDao = new PeliculasDao();
		return peliculasDao.read();
	}
	@POST
	@Path("/Peliculas")
	public void addPelicula(MultivaluedMap<String,String> parametros){
		PeliculasDao peliculasDao = new PeliculasDao();
		Pelicula pelicula = new Pelicula(parametros.getFirst("titulo"),parametros.getFirst("sinopsis"),parametros.getFirst("fecha"));
		peliculasDao.create(pelicula);
	}

	@DELETE
	@Path("/Peliculas/{id}")
	public void deletePelicula(@PathParam("id") int id){
		PeliculasDao peliculasDao = new PeliculasDao();
		peliculasDao.delete(id);
	}
	@PUT
	@Path("/Peliculas/{id}")
	public void updatePelicula(@PathParam("id") int id, MultivaluedMap<String,String> parametros){
		PeliculasDao peliculasDao = new PeliculasDao();
		Pelicula pelicula = new Pelicula(Integer.parseInt(parametros.getFirst("id")),parametros.getFirst("titulo"),parametros.getFirst("sinopsis"),parametros.getFirst("fecha"));
		peliculasDao.update(pelicula);
	}
}
