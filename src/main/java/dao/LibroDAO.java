package dao;

import model.Libro;

import java.util.List;

public interface LibroDAO {
    public void crateLibro(Libro libro);

    public List<Libro> getAllLibros();
}
