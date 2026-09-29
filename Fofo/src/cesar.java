import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class cesar {

    String origi;
    String cifrado;


    cesar() {
        this.origi = "";
        this.cifrado = "";
    }


    String removerEspacios(String texto) {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != ' ') {
                cad.append(texto.charAt(i));
            }
        }
        String nospaces = cad.toString();
        return nospaces;
    }

    String silabas(String og) {
        StringBuilder resultado = new StringBuilder();
        int k = 0;
        int aux = 0;
        char vocalActual = ' ';

        while (k < og.length()) {
            // Si hay al menos 2 caracteres
            if (k + 2 <= og.length()) {
                String silaba = og.substring(k, k + 2);

                boolean tieneVocal = silaba.contains("a") || silaba.contains("e") ||
                        silaba.contains("i") || silaba.contains("o") ||
                        silaba.contains("u");

                if (tieneVocal) {
                    if (silaba.contains("a")) vocalActual = 'a';
                    else if (silaba.contains("e")) vocalActual = 'e';
                    else if (silaba.contains("i")) vocalActual = 'i';
                    else if (silaba.contains("o")) vocalActual = 'o';
                    else if (silaba.contains("u")) vocalActual = 'u';
                    resultado.append(silaba);

                    aux = 2;
                } else {
                    resultado.append(og.charAt(k));
                    aux = 1;
                }
            } else {
                resultado.append(og.charAt(k));
                aux = 1;
            }

            k += aux;
            if (k <= og.length()) {
                resultado.append("f").append(vocalActual).append(" ");
            }
        }

        return resultado.toString();
    }

    public void cifrarArchivo(String nombre) {

        File myObj = new File(nombre+".txt");
        String data;

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                String dataSinEspacios = removerEspacios(data);
                String dataCifrada = silabas(dataSinEspacios);
                System.out.println(dataCifrada);

                try {
                    FileWriter myWriter = new FileWriter(nombre+"_cifrado.txt");
                    myWriter.write(dataCifrada);
                    myWriter.close();
                    System.out.println("Save as "+nombre+"_cifrado.txt");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}