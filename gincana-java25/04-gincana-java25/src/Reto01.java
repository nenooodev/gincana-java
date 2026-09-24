import java.util.List;
import java.util.Locale;

public class Reto01 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(25, 18, 25, 41, 9, 30, 25, 12);

        int cantidad = numeros.size();
        int minimo = numeros.stream().mapToInt(n -> n).min().getAsInt();
        int maximo = numeros.stream().mapToInt(n -> n).max().getAsInt();
        double media = numeros.stream().mapToInt(n -> n).average().orElse(0);
        long apariciones25 = numeros.stream().filter(n -> n == 25).count();

        String mediaTexto = String.format(Locale.ROOT, "%.3f", media);

        System.out.println("Cantidad: " + cantidad);
        System.out.println("Minimo: " + minimo);
        System.out.println("Maximo: " + maximo);
        System.out.println("Media: " + mediaTexto);
        System.out.println("Apariciones del 25: " + apariciones25);

        System.out.println("CLAVE=R1-" + cantidad + "-" + minimo + "-" + maximo
                + "-" + mediaTexto + "-" + apariciones25);
    }
}