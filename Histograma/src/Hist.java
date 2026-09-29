import java.util.Scanner;

public class Hist {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("1. Histograma de letras");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            opcion = in.nextInt();
            in.nextLine();


            switch (opcion) {
                case 1:
                    HistogramaLetras histograma = new HistogramaLetras();
                    histograma.limpiarFrecuencias();
                    System.out.println("Nombre del archivo demo disponible es «Cuento»");
                    System.out.println("Ingrese el nombre del archivo (sin extension .txt): ");
                    String nombreArchivo = in.nextLine();
                    histograma.leerYProcesarArchivo(nombreArchivo);
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("entrada invalida");
                    break;
            }

        } while(opcion!=3);
    }
}