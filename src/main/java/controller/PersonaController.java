package controller;

import dao.LibroDAOImplements;
import dao.PersonaDAOImplements;
import model.Comentario;
import model.Libro;
import model.Persona;

import java.time.LocalDateTime;

public class PersonaController {
    private final PersonaDAOImplements personaDAOI;
    private final LibroDAOImplements libroDAOI;

    public PersonaController() {
        this.personaDAOI = new PersonaDAOImplements();
        this.libroDAOI = new LibroDAOImplements();
    }

    public Persona createUser(Persona persona) {
        personaDAOI.createPersona(persona);
        return persona;
    }
    public void crearComentario(Persona persona, Libro libro, int valoracion, String comentario){
        Comentario objComentario = new Comentario(valoracion, comentario);
        objComentario.setLibro(libro);
        objComentario.setPersona(persona);
        persona.getHaceComentarios().add(objComentario);
        personaDAOI.actualizaPersona(persona);
    }

    public Persona registerPersona(String nombre, String nombreUsuario, String mail, String contrasegna) {
        Persona persona = new Persona(nombre, nombreUsuario, mail, contrasegna);
        personaDAOI.createPersona(persona);
        return persona;
    }

    public Persona logIn(String nombreUsuario, String contrasegna) {
        Persona persona= personaDAOI.logIn(nombreUsuario, contrasegna);
        if (persona!= null){
            persona.setLastLogIn(LocalDateTime.now());
            personaDAOI.actualizaPersona(persona);
        }
        return persona;
    }

    public void registrarLectura(Persona persona, Libro libro) {
        persona.getLibrosLeidos().add(libro);
        libro.getPersonasQueLoHanLeido().add(persona);
        personaDAOI.actualizaPersona(persona);
    }

    public void registrarEscritura(Persona persona, Libro libro) {
        persona.getLibrosEscritos().add(libro);
        libro.getEscribenLibros().add(persona);
        personaDAOI.actualizaPersona(persona);
    }
}
