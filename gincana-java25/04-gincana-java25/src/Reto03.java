//RETO 3 - Figuras que hablan
//
//Crea una clase abstracta Figura con area() y dos clases: Cuadrado y Circulo.
//Usa lado 4 y radio 1. Calcula las dos areas mediante referencias de tipo Figura.
//Determina cual esta mas cerca de 3.14. Imprime nombre de la ganadora y areas.
//Ultima linea: CLAVE=R3-ganadora-areaCirculo-areaCuadrado
//Ganadora en mayusculas, areas con dos decimales y punto (Locale.ROOT).


import java.util.Locale;

public class Reto03 {

    static abstract class Figura {
        protected String nombre;

        Figura(String nombre) {
            this.nombre = nombre;
        }

        public abstract double area();

        public String getNombre() {
            return nombre;
        }
    }

    static class Cuadrado extends Figura {
        private double lado;

        Cuadrado(double lado) {
            super("Cuadrado");
            this.lado = lado;
        }

        @Override
        public double area() {
            return lado * lado;
        }
    }

    static class Circulo extends Figura {
        private double radio;

        Circulo(double radio) {
            super("Circulo");
            this.radio = radio;
        }

        @Override
        public double area() {
            return Math.PI * radio * radio;
        }
    }

    static double distancia(double a, double b) {
        if (a > b) {
            return a - b;
        }
        return b - a;
    }

    static Figura masCercana(Figura x, Figura y, double objetivo) {
        double distanciaX = distancia(x.area(), objetivo);
        double distanciaY = distancia(y.area(), objetivo);
        if (distanciaX <= distanciaY) {
            return x;
        }
        return y;
    }

    static String formatear(double valor) {
        return String.format(Locale.ROOT, "%.2f", valor);
    }

    static String generarClave(String ganadora, String areaCirculo, String areaCuadrado) {
        return "CLAVE=R3-" + ganadora + "-" + areaCirculo + "-" + areaCuadrado;
    }

    public static void main(String[] args) {
        Figura cuadrado = new Cuadrado(4);
        Figura circulo = new Circulo(1);

        Figura ganadora = masCercana(cuadrado, circulo, 3.14);

        String nombreGanadora = ganadora.getNombre().toUpperCase(Locale.ROOT);
        String areaCirculo = formatear(circulo.area());
        String areaCuadrado = formatear(cuadrado.area());

        System.out.println("Area cuadrado: " + areaCuadrado);
        System.out.println("Area circulo: " + areaCirculo);
        System.out.println("Ganadora: " + nombreGanadora);

        System.out.println(generarClave(nombreGanadora, areaCirculo, areaCuadrado));
    }
}