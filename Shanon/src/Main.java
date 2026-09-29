import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion;
        Shanon doc = new Shanon();
        System.out.println("Nombre del archivo demo disponible es «Cuento»");
        System.out.println("Ingrese el nombre del archivo (sin extension .txt): ");
        String nombreArchivo = in.nextLine();
        do{
            System.out.println("1. Obtener datos de archivo (sin contexto)");
            System.out.println("2. Obtener datos de archivo (con contexto)");
            System.out.println("3. Obtener información de archivo");
            System.out.println("4. Histograma");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = in.nextInt();
            in.nextLine();


            switch (opcion) {
                case 1:
                    System.out.println("Sin contexto toma en cuenta todos los caracteres del código ASCII imprimibles\ndesde el 32 hasta el 254 excluyendo el 127(caracter de control)\n");
                    doc.limpiarFrecuencias();
                    doc.datosArchivoSinContexto(nombreArchivo);
                    break;
                case 2:
                    System.out.println("Con contexto se refiere a que identifica cuantos caracteres del código ASCII\nse utilizarón y es lo que calcula dentro del logaritmo\n");
                    doc.limpiarFrecuencias();
                    doc.datosArchivoContexto(nombreArchivo);
                    break;
                case 3:
                    doc.limpiarFrecuencias();
                    doc.informacionArchivo(nombreArchivo);
                    break;
                case 4:
                    doc.limpiarFrecuencias();
                    doc.histogramaArchivo(nombreArchivo);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("entrada invalida");
                    break;
            }

        } while(opcion!=5);
    }
}