package EjerciciosRepaso;
import java.util.Scanner;

public class EjercicioArraysBidimensionals {
    public static void main(String[] args) {
        String[] alumnes = new String[100];
        int[][] notes = new int[100][100];

        leerDatosEntrada(alumnes, notes);
        int numeroDeUFs = calcularNumeroDeUFs(alumnes, notes);
        mostrarTablaNotas(alumnes, notes, numeroDeUFs);
    }

    public static void leerDatosEntrada(String[] alumnes, int[][] notes) {
        Scanner sc = new Scanner(System.in);
        int numeroDeAlumnes = 0;

        while (sc.hasNext()) {
            // leemos la entrada, si en la linea hay un 0, el programa se termina
            String input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }
            // dividimos la linea de entrada en partes utilizando un espacio como separador
            String[] parts = input.split(" ");
            // agregamos la primera parte, al array de alumnos
            alumnes[numeroDeAlumnes] = parts[0];

            // leemos el resto de la linea, guardando cada numero en un array de alumnoNotas
            for (int i = 1; i < parts.length; i++) {
                notes[numeroDeAlumnes][i - 1] = Integer.parseInt(parts[i]);
            }
            numeroDeAlumnes++;
        }
    }
    // Calculamos cuantas UF's habran, segun el numero de notas de los alumnos
    public static int calcularNumeroDeUFs(String[] alumnes, int[][] notes) {
        int numeroDeUFs = 0;
        for (int i = 0; i < alumnes.length; i++) {
            for (int j = 0; j < notes[i].length; j++) {
                if (notes[i][j] != 0) {
                    numeroDeUFs++;
                }
            }
        }
        return numeroDeUFs;
    }

    public static void mostrarTablaNotas(String[] alumnes, int[][] notes, int numeroDeUFs) {
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
        System.out.println();
        // Organizamos los datos de la tabla para que ocupen un espacio si o si
        for (int i = 0; i < alumnes.length; i++) {
            if (alumnes[i] != null) {
                System.out.printf("| %-13s |", alumnes[i]);
                for (int j = 0; j < maxNotas; j++) {
                    // Si el alumno tiene menos notas que el máximo, mostrar 0
                    int nota = (j < notes[i].length) ? notes[i][j] : 0;
                    System.out.printf(" %3d |", nota);
                }
                System.out.println();
            }
        }
    }
}
