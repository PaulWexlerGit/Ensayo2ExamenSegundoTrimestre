import controller.LibroController;
import controller.PersonaController;
import model.Libro;
import model.Persona;

public class Main {
    public static void main(String[] args) {
        PersonaController personaController = new PersonaController();
        LibroController libroController = new LibroController();

        Persona pedro = new Persona("Pedro", "pedro1", "1234", "pedro@mail.com");
        personaController.createUser(pedro);
        Persona elvis = new Persona("Elvis Tek", "elvisTeck", "1234", "elvistek@mail.com");
        personaController.createUser(elvis);
        Libro libro1 = new Libro("libro1", 10);
        libroController.createLibro(libro1);
        personaController.crearComentario(pedro, libro1, 4, "Bastante bueno");
        Persona pedroLog = personaController.logIn("pedro1", "1234");
        if (pedroLog != null) {
            System.out.println("LogIn correcto. Su último logIn fue: " + pedroLog.getLastLogIn());
        } else {
            System.out.println("LogIn incorrecto");
        }
        personaController.registrarEscritura(elvis, libro1);
        personaController.registrarLectura(pedro, libro1);

        System.out.println("Libros leidos por Pedro: ");
        for (Libro libro : pedro.getLibrosLeidos()) {
            System.out.println(libro);
        }
        System.out.println("Los libros disponibles son: ");
        for (Libro libro : libroController.getAllLibros()) {
            System.out.println(libro);
        }
    }
}
//public class LibroDAO {
//
//    // Obtener todos los libros
//    public List<Libro> obtenerTodosLosLibros() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            String hql = "from Libro"; // Consulta HQL para obtener todos los libros
//            Query<Libro> query = session.createQuery(hql, Libro.class);
//            return query.getResultList();
//        } catch (Exception e) {
//            // Manejo de excepciones (por ejemplo, loguear o relanzar)
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
//String hql = "from Libro l where l.nombre like '%Quijote%'";
//public List<Object[]> getUserTimeLine(User user) {
//    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//        String hql = "SELECT u.username, p.content, p.createdAt, COUNT(DISTINCT l.user) " +
//                "FROM Post p " +
//                "JOIN p.user u " +
//                "LEFT JOIN p.likes l " +
//                "LEFT JOIN u.followedUsers f " +
//                "WHERE u = :user OR f.follower = :user " +
//                "GROUP BY p.id " +
//                "ORDER BY p.createdAt DESC";
//
//        return session.createQuery(hql, Object[].class)
//                .setParameter("user", user)
//                .getResultList();
//    } catch (NoResultException error) {
//        System.err.println(error.getMessage());
//        return null;
//    }
//}
