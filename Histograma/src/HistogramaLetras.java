import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HistogramaLetras {
    private Map<Character, Integer> frecuencias;


    public HistogramaLetras() {
        this.frecuencias = new HashMap<>();
    }


    public long contarFrecuencias(String cadena, char caracter) {
        long count = cadena.chars()
                .filter(ch -> ch == caracter)
                .count();
        return count;
    }


    public void imprimirHistogramaHorizontal(String cad) {
        int total = 0;
        System.out.println(total = cad.length());
        Map<String, Integer> frecuencias = new HashMap<>();


        for (char l = ' '; l <= '~'; l++) {
            String aux = "";
            aux += l;

            frecuencias.put(aux, (int) contarFrecuencias(cad, aux.charAt(0)));
        }


        // 2. Convertir el Map a un ArrayList usando entrySet()
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(frecuencias.entrySet());

        // 3. Recorrer la lista para generar el histograma
        for (Map.Entry<String, Integer> entry : lista) {
            String clave = entry.getKey();
            int valor = entry.getValue();
            if (valor != 0) {

                String barras = "*".repeat(valor);
                float probabilidad = (((float) valor) / (float) total);
                System.out.println(clave + ": " + barras + " " + valor + " (" + probabilidad * 100 + "%)");

            }


        }
    }


    public void leerYProcesarArchivo(String nombre) {
        File myObj = new File(nombre + ".txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                imprimirHistogramaHorizontal(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error had occurred.");
            e.printStackTrace();
        }
    }

    public void limpiarFrecuencias() {
        frecuencias.clear();
    }




}