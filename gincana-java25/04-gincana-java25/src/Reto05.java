//RETO 5 - Nota persistente
//
//Escribe en notas.txt mediante Files.writeString y UTF-8 la frase exacta:
//Java 25 prepara el salto a Spring Boot.
//
//Leela de nuevo con Files.readString. Imprime el contenido leido, su numero de caracteres
//y si coincide exactamente con el original. La ultima linea debe usar SOLO los resultados
//obtenidos al leer el fichero, en este formato:
//CLAVE=R5-numeroCaracteres-igualdadExacta
//Escribe el booleano en mayusculas (TRUE/FALSE). No anadas un salto de linea al fichero.

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class Reto05 {

    static final String FRASE = "Java 25 prepara el salto a Spring Boot.";

    static void escribir(Path path, String texto) throws IOException {
        Files.writeString(path, texto, StandardCharsets.UTF_8);
    }

    static String leer(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    static String aTexto(boolean valor) {
        return String.valueOf(valor).toUpperCase(Locale.ROOT);
    }

    static String generarClave(int numeroCaracteres, String igualdadExacta) {
        return "CLAVE=R5-" + numeroCaracteres + "-" + igualdadExacta;
    }

    public static void main(String[] args) {
        Path path = Path.of("notas.txt");

        try {
            escribir(path, FRASE);
            String leido = leer(path);

            int numeroCaracteres = leido.length();
            String igualdadExacta = aTexto(leido.equals(FRASE));

            System.out.println("Contenido: " + leido);
            System.out.println("Caracteres: " + numeroCaracteres);
            System.out.println("Coincide: " + igualdadExacta);

            System.out.println(generarClave(numeroCaracteres, igualdadExacta));
        } catch (IOException exception) {
            System.out.println("No se pudo leer o escribir: " + exception.getMessage());
        }
    }
}
