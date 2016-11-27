package es.abendev.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.abendev.beans.Pelicula;

public class PeliculasDao implements GenericDao {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/Peliculas";
	private static final String USUARIO = "root";
	private static final String PASS = "root";
	
	private Connection conexion = null;
	private Statement sentencia = null;
	private ResultSet filas = null;
	private List<Pelicula> listaDePeliculas = new ArrayList<Pelicula>();
	
	private void conectar(){
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL,USUARIO,PASS);
			sentencia = conexion.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	private void desconectar() {
		if(sentencia != null){
			try {
				sentencia.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conexion != null){
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(filas != null){
			try {
				filas.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void create(Pelicula pelicula) {
	conectar();
		
		String consultaSql = "insert into Peliculas (titulo,sinopsis,fecha) values ";
		consultaSql += "('" + pelicula.getTitulo() + "','" + pelicula.getSinopsis() + "','" + pelicula.getFecha() +"')";
		
		try {
			sentencia.executeUpdate(consultaSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		
	}

	public List<Pelicula> read() {
		conectar();
		String consultaSql = "select * from Peliculas";
		try {
			filas = sentencia.executeQuery(consultaSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(filas.next()){
				Pelicula pelicula = new Pelicula(filas.getInt(1),filas.getString(2),filas.getString(3), filas.getString(4));
				listaDePeliculas.add(pelicula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return listaDePeliculas;
	}

	public void update(Pelicula pelicula) {
		conectar();
		String consultaSql = "update Peliculas set titulo='" + pelicula.getTitulo() + "', sinopsis='" +
		pelicula.getSinopsis() + "', fecha='" + pelicula.getFecha() + "', Descripcion='" 
		+ "' where IdPelicula=" + pelicula.getId();
		try {
			sentencia.executeUpdate(consultaSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		
	}

	public void delete(int id) {
		conectar();
		String consultaSql = "delete from Peliculas where idPelicula=" + id;
		try {
			sentencia.executeUpdate(consultaSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		
	}

	
}
