import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Shanon {
    private Map<Character, Integer> frecuencias;


    public Shanon() {
        this.frecuencias = new HashMap<>();
    }

    private long contarFrecuencias(String cadena, char caracter) {
        long count = cadena.chars()
                .filter(ch -> ch == caracter)
                .count();
        return count;
    }

    private double obtenerDatosContexto(String cad) {
        double numSimbolos = 0;
        Map<String, Integer> frecuencias = new HashMap<>();

        for (char l = ' '; l <= '■'; l++) {
            String aux = "";
            aux += l;

            frecuencias.put(aux, (int) contarFrecuencias(cad, aux.charAt(0)));
        }

        List<Map.Entry<String, Integer>> lista = new ArrayList<>(frecuencias.entrySet());

        for (Map.Entry<String, Integer> entry : lista) {
            int valor = entry.getValue();
            if (valor != 0) {
                numSimbolos += 1;
            }
        }

        double datos = cad.length()*(Math.log(numSimbolos) / Math.log(2));
        return datos;
    }

    private double obtenerDatosSinContexto(String cad) {
        double datos = cad.length()*(Math.log(222) / Math.log(2));
        return datos;
    }

    private double obtenerInfomacion(String cad) {
        double total = 0;
        double ac=0;
        double info=0;
        System.out.println(total = cad.length());
        Map<String, Integer> frecuencias = new HashMap<>();


        for (char l = ' '; l <= '■'; l++) {
            String aux = "";
            aux += l;

            frecuencias.put(aux, (int) contarFrecuencias(cad, aux.charAt(0)));
        }

        List<Map.Entry<String, Integer>> lista = new ArrayList<>(frecuencias.entrySet());

        for (Map.Entry<String, Integer> entry : lista) {
            int valor = entry.getValue();
            if (valor != 0) {
                double probabilidad = (((double) valor) / total);
                double informacion = probabilidad * (Math.log(1 / probabilidad) / Math.log(2));
                ac += informacion;

            }
            info=ac*total;
        }
        return info;
    }

    public void imprimirHistogramaHorizontal(String cad) {
        int total = 0;
        System.out.println(total = cad.length());
        Map<String, Integer> frecuencias = new HashMap<>();

        for (char l = ' '; l <= '■'; l++) {
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
                double probabilidad = (((double) valor) / (double) total);
                System.out.println(clave + ": " + barras + " " + valor + " (" + probabilidad * 100 + "%)");

            }

        }
        System.out.print("\n");
    }

    private String leerArchivo(String nombre){
        File myObj = new File(nombre + ".txt");
        StringBuilder contenido = new StringBuilder();
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                contenido.append(myReader.nextLine());
                if (myReader.hasNextLine()) {
                    contenido.append(" ");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error had occurred.");
            e.printStackTrace();

        }
        return contenido.toString();
    }

    public void histogramaArchivo(String nombre) {
        imprimirHistogramaHorizontal(leerArchivo(nombre));
    }

    public void datosArchivoContexto(String nombre) {
        System.out.println("El archivo tine: " + obtenerDatosContexto(leerArchivo(nombre)) + " bits de datos");
        System.out.print("\n");
    }

    public void datosArchivoSinContexto(String nombre) {
        System.out.println("El archivo tine: " + obtenerDatosSinContexto(leerArchivo(nombre)) + " bits de datos");
        System.out.print("\n");
    }

    public void informacionArchivo(String nombre) {
        System.out.println("El archivo tine: " + obtenerInfomacion(leerArchivo(nombre)) + " bits de información");
        System.out.print("\n");
    }

    public void limpiarFrecuencias() {
        frecuencias.clear();
    }

}