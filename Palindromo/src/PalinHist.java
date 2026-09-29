import java.util.Scanner;

public class PalinHist {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("1. Verificar palindromo");
            System.out.println("2. Histograma de letras");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = in.nextInt();
            in.nextLine();


            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cadena: ");
                    String cad = in.nextLine();

                    VerificadorPalindromo verificador = new VerificadorPalindromo(cad);
                    verificador.invertirCadena();
                    verificador.mostrarCadenas();
                    verificador.verificar();
                    break;
                case 2:
                    HistogramaLetras histograma = new HistogramaLetras();
                    histograma.limpiarFrecuencias();
                    System.out.println("Ingrese el nombre del archivo: ");
                    String nombreArchivo = in.nextLine();
                    histograma.leerYProcesarArchivo(nombreArchivo);
                    System.out.println("Histograma del archivo:");
                    histograma.imprimirHistogramaHorizontal();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("entrada invalida");
                    break;
            }

        } while(opcion!=3);
    }
}