package dao;

import model.Persona;

public interface PersonaDAO {
    public void createPersona(Persona persona);

    public void actualizaPersona(Persona persona);

    public Persona logIn(String nombreUsuario, String contrasegna);
}
