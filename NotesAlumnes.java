package EjerciciosRepaso;
import java.util.Scanner;

public class EjercicioArraysBidimensionals {
    public static void main(String[] args) {
        String[] alumnes = new String[100];
        int[][] notes = new int[100][100];

        leerDatosEntrada(alumnes, notes);
        mostrarTablaNotas(alumnes, notes);
    }

    public static void leerDatosEntrada(String[] alumnes, int[][] notes) {
        Scanner sc = new Scanner(System.in);
        int numeroDeAlumnes = 0;

        while (sc.hasNext()) {
            // leemos la entrada, si en la linea hay un 0, el programa se termina
            String seguentEntrada = sc.nextLine();
            if (seguentEntrada.equals("0")) {
                break;
            }
            // dividimos la linea de entrada en partes utilizando un espacio como separador
            String[] parts = seguentEntrada.split(" ");
            // agregamos la primera parte, al array de alumnos
            alumnes[numeroDeAlumnes] = parts[0];

            // leemos el resto de la linea, guardando cada numero en un array de alumnoNotas
            for (int i = 1; i < parts.length; i++) {
                notes[numeroDeAlumnes][i - 1] = Integer.parseInt(parts[i]);
            }
            numeroDeAlumnes++;
        }
    }

    public static void mostrarTablaNotas(String[] alumnes, int[][] notes) {
        // Encontrar el máximo número de notas entre todos los alumnos
        int maxNotas = 0;
        for (int i = 0; i < alumnes.length; i++) {
            int numNotasAlumno = 0;
            for (int j = 0; j < notes[i].length; j++) {
                if (notes[i][j] != 0) {
                    numNotasAlumno++;
                }
            }
            maxNotas = Math.max(maxNotas, numNotasAlumno);
        }

        System.out.print("| notes/alumnes |");
        for (int i = 1; i <= maxNotas; i++) {
            System.out.printf(" UF%d |", i);
        }
        System.out.println(" Total |"); // Nueva cabecera para Total

        // Organizamos los datos de la tabla para que ocupen un espacio si o si
        for (int i = 0; i < alumnes.length; i++) {
            if (alumnes[i] != null) {
                System.out.printf("| %-13s |", alumnes[i]);
                int sumNotas = 0; // Variable para sumar las notas de las UF's
                int numNotas = 0; // Variable para contar las UF's con notas
                for (int j = 0; j < maxNotas; j++) {
                    // Si el alumno tiene menos notas que el máximo, mostrar 0 y no sumar
                    int nota = (j < notes[i].length) ? notes[i][j] : 0;
                    if (nota != 0) {
                        sumNotas += nota; // Sumar las notas válidas
                        numNotas++; // Contar las UF's con notas
                    }
                    System.out.printf(" %3d |", nota);
                }
                // Calcular el promedio y redondear según las condiciones
                double promedio = (double) sumNotas / numNotas;
                int total = (int) Math.round(promedio);
                System.out.printf(" %5d |%n", total); // Imprimir el Total
            }
        }
    }
}
