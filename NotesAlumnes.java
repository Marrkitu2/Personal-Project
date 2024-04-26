import java.util.Scanner;

public class EjercicioArraysBidimensionals {
    public static void main(String[] args) {
        String[] alumnes = new String[100]; // Cambia el tamaño según tus necesidades
        int[][] notes = new int[100][100]; // Cambia el tamaño según tus necesidades

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
        System.out.print("| notes/alumnes |");
        for (int i = 1; i <= numeroDeUFs; i++) {
            System.out.printf(" UF%d |", i);
        }
        System.out.println();
        // organizamos los datos de la tabla para que ocupen un espacio si o si
        for (int i = 0; i < alumnes.length; i++) {
            if (alumnes[i] != null) {
                System.out.printf("| %-13s |", alumnes[i]);
                for (int j = 0; j < notes[i].length; j++) {
                    System.out.printf(" %3d |", notes[i][j]);
                }
                System.out.println();
            }
        }
    }
}
