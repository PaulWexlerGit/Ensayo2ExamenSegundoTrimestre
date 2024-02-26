package controller;

import dao.LibroDAOImplements;
import model.Libro;

import java.util.List;

public class LibroController {
    LibroDAOImplements libroDAOI = new LibroDAOImplements();
    public void createLibro(Libro libro) {
        libroDAOI.crateLibro(libro);
    }
    public List<Libro> getAllLibros(){
        return libroDAOI.getAllLibros();
    }
}
