// RETO 2 - Estudiantes con memoria
//
//
//
//Crea un record Student(String name, int age). Valida nombre no vacio y edad no negativa.
//
//Dos estudiantes son iguales si tienen la misma edad y nombre ignorando mayusculas.
//
//Sobrescribe equals y hashCode de forma coherente.
//
//
//
//Compara a = Student("Ada", 30), b = Student("ada", 30) y c = Student("Joe", 25).
//
//Crea un HashSet con los tres. Imprime los dos resultados de igualdad y el tamano del set.
//
//Ultima linea: CLAVE=R2-igualdadAB-igualdadAC-tamanoSet
//
//Usa TRUE/FALSE en mayusculas (String.valueOf(boolean).toUpperCase(Locale.ROOT)).

import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

public class Reto02 {

    public record Student(String name, int age) {

        public Student {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            }
            if (age < 0) {
                throw new IllegalArgumentException("La edad no puede ser negativa");
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student other)) return false;
            return age == other.age && name.equalsIgnoreCase(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name.toLowerCase(Locale.ROOT), age);
        }
    }

    static String aTexto(boolean valor) {
        return String.valueOf(valor).toUpperCase(Locale.ROOT);
    }

    static String comparar(Student x, Student y) {
        return aTexto(x.equals(y));
    }

    static Set<Student> crearSet(Student a, Student b, Student c) {
        Set<Student> students = new HashSet<>();
        students.add(a);
        students.add(b);
        students.add(c);
        return students;
    }

    static String generarClave(String igualdadAB, String igualdadAC, int tamanoSet) {
        return "CLAVE=R2-" + igualdadAB + "-" + igualdadAC + "-" + tamanoSet;
    }

    public static void main(String[] args) {
        Student a = new Student("Ada", 30);
        Student b = new Student("ada", 30);
        Student c = new Student("Joe", 25);

        String igualdadAB = comparar(a, b);
        String igualdadAC = comparar(a, c);
        int tamanoSet = crearSet(a, b, c).size();

        System.out.println("a.equals(b): " + igualdadAB);
        System.out.println("a.equals(c): " + igualdadAC);
        System.out.println("Tamano del set: " + tamanoSet);

        System.out.println(generarClave(igualdadAB, igualdadAC, tamanoSet));
    }
}