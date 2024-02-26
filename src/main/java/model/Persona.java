package model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persona")

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nombreUsuario", unique = true)
    private String nombreUsuario;
    @Column(name = "contrasegna")
    private String contrasegna;
    @Column(name = "mail")
    private String mail;
    @Column(name = "lastLogIn")
    private LocalDateTime lastLogIn;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "persona_escribe_libros", joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> librosEscritos = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "persona_lee_libros", joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> librosLeidos = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Comentario> haceComentarios = new ArrayList<>();

    public Persona() {
    }

    public Persona(String nombre, String nombreUsuario, String contrasegna, String mail) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasegna = contrasegna;
        this.mail = mail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasegna() {
        return contrasegna;
    }

    public void setContrasegna(String contrasegna) {
        this.contrasegna = contrasegna;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Libro> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(List<Libro> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }

    public List<Libro> getLibrosLeidos() {
        return librosLeidos;
    }

    public void setLibrosLeidos(List<Libro> librosLeidos) {
        this.librosLeidos = librosLeidos;
    }

    public List<Comentario> getHaceComentarios() {
        return haceComentarios;
    }

    public void setHaceComentarios(List<Comentario> haceComentarios) {
        this.haceComentarios = haceComentarios;
    }

    public LocalDateTime getLastLogIn() {
        return lastLogIn;
    }

    public void setLastLogIn(LocalDateTime lastLogIn) {
        this.lastLogIn = lastLogIn;
    }
}
