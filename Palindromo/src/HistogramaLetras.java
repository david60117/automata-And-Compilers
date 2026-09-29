import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HistogramaLetras {
    private Map<Character, Integer> frecuencias;

    public HistogramaLetras() {
        this.frecuencias = new HashMap<>();
    }


    public void contarFrecuencias(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);

            if (Character.isLetter(letra)) {
                letra = Character.toLowerCase(letra);
                frecuencias.put(letra, frecuencias.getOrDefault(letra, 0) + 1);
            }
        }
    }

    public void imprimirHistogramaHorizontal() {
        for (char letra = 'a'; letra <= 'z'; letra++) {

            if (frecuencias.containsKey(letra)) {
                int conteo = frecuencias.get(letra);

                System.out.print(letra + ": ");

                for (int j = 0; j < conteo; j++) {
                    System.out.print("*");
                }
                System.out.print("(" + conteo + ")");
                System.out.println();
            }
        }
    }


    public void leerYProcesarArchivo(String nombre) {
        File myObj = new File(nombre + ".txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                contarFrecuencias(data);
            }
            System.out.println("Archivo procesado correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("An error had occurred.");
            e.printStackTrace();
        }
    }

    public void limpiarFrecuencias() {
        frecuencias.clear();
    }

}