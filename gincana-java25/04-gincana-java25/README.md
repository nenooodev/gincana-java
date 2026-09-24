# Gincana Java 25: descifra el siguiente reto

Actividad practica de repaso de Java antes del trabajo de servidor. Tiempo:
**dos horas** en parejas o equipos de tres. No tiene nota independiente.

El primer reto se lee aqui. Los siguientes enunciados estan en
`retos-cifrados/`: no se pueden leer hasta calcular la clave del reto anterior.
Cada equipo crea sus programas; el descifrador solo usa la **ultima linea** de su
salida, que debe ser `CLAVE=...`. Puedes imprimir antes los resultados para
comprobarlos. El descifrador no ejecuta ni corrige el programa: descifra usando
la clave que produces.

## Preparacion (JDK 25)

Desde esta carpeta, compila el descifrador:

```bash
javac -d out src/SiguienteReto.java
```

Haz tus programas en una carpeta `equipo-NOMBRE/reto01/`,
`equipo-NOMBRE/reto02/`, etc. Para desbloquear, ejecuta tu programa y pasa
directamente su salida al descifrador. Ejemplo desde la carpeta de la gincana:

```bash
javac -d equipo-demo/reto01/out equipo-demo/reto01/Reto01.java
java -cp equipo-demo/reto01/out Reto01 | java -cp out SiguienteReto 1
```

Sustituye `equipo-demo` por tu carpeta, `Reto01` por tu clase y `1` por el reto
que acabas de resolver. Si trabajas en IntelliJ y prefieres ejecutar allí tu
programa, copia su ultima linea y prueba manualmente con
`java -cp out SiguienteReto 1 TU_CLAVE` desde esta misma carpeta.
No hace falta instalar librerias ni conectarse a Internet.

## Reto 1 - Brujula de numeros

Crea `Reto01.java`. Con esta lista de enteros:

```text
25, 18, 25, 41, 9, 30, 25, 12
```

Calcula la cantidad, el minimo, el maximo, la media con **tres decimales** y
cuantas veces aparece el 25. Imprime esos datos para comprobarlos. La ultima
linea debe formarse a partir de tus resultados, exactamente con este formato:

```text
CLAVE=R1-cantidad-minimo-maximo-media-aparicionesDel25
```

Usa punto decimal, sin espacios y con `Locale.ROOT` para que funcione tambien
en equipos configurados en espanol. Por ejemplo, una media de 7 se escribe
`7.000`. No escribas a mano los numeros de la clave: calculalos con el programa.

Cuando hayas generado la clave, desbloquea el siguiente reto. En
[`PISTAS.md`](PISTAS.md) hay dos pistas por reto si te atascas mas de 10 minutos.

## Entrega

Guarda el codigo de los retos completados y un `README.md` del equipo con sus
integrantes, comandos de compilacion/ejecucion, una decision de diseno y algo
aprendido. Entrega un ZIP sin `out/`, `.idea/` ni archivos compilados. No importa
si no llegais al reto 6: es mas importante poder explicar vuestro codigo.
Reto2:


RETO 2 - Estudiantes con memoria

Crea un record Student(String name, int age). Valida nombre no vacio y edad no negativa.
Dos estudiantes son iguales si tienen la misma edad y nombre ignorando mayusculas.
Sobrescribe equals y hashCode de forma coherente.

Compara a = Student("Ada", 30), b = Student("ada", 30) y c = Student("Joe", 25).
Crea un HashSet con los tres. Imprime los dos resultados de igualdad y el tamano del set.
Ultima linea: CLAVE=R2-igualdadAB-igualdadAC-tamanoSet
Usa TRUE/FALSE en mayusculas (String.valueOf(boolean).toUpperCase(Locale.ROOT)).
