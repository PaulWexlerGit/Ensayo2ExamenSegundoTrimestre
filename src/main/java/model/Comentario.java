package model;

import jakarta.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "valoración")
    private int valoración;
    @Column(name = "comentario")
    private String comentario;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "libro_id")
    private Libro libro;

    public Comentario() {
    }

    public Comentario(int valoracion, String comentario) {
        this.valoración = valoracion;
        this.comentario = comentario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValoración() {
        return valoración;
    }

    public void setValoración(int valoración) {
        this.valoración = valoración;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
