package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "paginas")
    private int paginas;
    @ManyToMany(mappedBy = "librosEscritos")
    private List<Persona> escribenLibros = new ArrayList<>();
    @ManyToMany(mappedBy = "librosLeidos")
    private List<Persona> personasQueLoHanLeido = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "libro")
    private List<Comentario> tieneComentarios = new ArrayList<>();

    public Libro() {
    }

    public Libro(String titulo, int paginas) {
        this.titulo = titulo;
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public List<Persona> getEscribenLibros() {
        return escribenLibros;
    }

    public void setEscribenLibros(List<Persona> escribenLibros) {
        this.escribenLibros = escribenLibros;
    }

    public List<Persona> getPersonasQueLoHanLeido() {
        return personasQueLoHanLeido;
    }

    public void setPersonasQueLoHanLeido(List<Persona> leenLibros) {
        this.personasQueLoHanLeido = leenLibros;
    }

    public List<Comentario> getTieneComentarios() {
        return tieneComentarios;
    }

    public void setTieneComentarios(List<Comentario> tieneComentarios) {
        this.tieneComentarios = tieneComentarios;
    }
}
