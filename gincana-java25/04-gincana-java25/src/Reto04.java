//RETO 4 - Ultimos titulos
//
//Crea un record Book(String title, int year). Ordena una lista por anio descendente con
//Streams y quedate con los tres libros mas recientes:
//Java basico (2019), Streams claros (2025), Records practicos (2024),
//Servidor moderno (2026), JSP legado (2015).
//
//Imprime los titulos elegidos en orden. Para la clave, pasa los titulos a mayusculas,
//sustituye espacios por _ y unelos con guiones.
//Ultima linea: CLAVE=R4-titulo1-titulo2-titulo3


import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Reto04 {

    record Book(String title, int year) {}

    static List<Book> crearLibros() {
        return List.of(
                new Book("Java basico", 2019),
                new Book("Streams claros", 2025),
                new Book("Records practicos", 2024),
                new Book("Servidor moderno", 2026),
                new Book("JSP legado", 2015)
        );
    }

    static List<Book> tresMasRecientes(List<Book> libros) {
        return libros.stream()
                .sorted(Comparator.comparing(Book::year).reversed())
                .limit(3)
                .toList();
    }

    static String aClave(String titulo) {
        return titulo.toUpperCase(Locale.ROOT).replace(' ', '_');
    }

    static String generarClave(List<Book> elegidos) {
        List<String> titulos = elegidos.stream()
                .map(libro -> aClave(libro.title()))
                .toList();
        return "CLAVE=R4-" + String.join("-", titulos);
    }

    public static void main(String[] args) {
        List<Book> elegidos = tresMasRecientes(crearLibros());

        for (Book libro : elegidos) {
            System.out.println(libro.title() + " (" + libro.year() + ")");
        }

        System.out.println(generarClave(elegidos));
    }
}