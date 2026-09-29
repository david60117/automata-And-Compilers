import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operaciones ob = new Operaciones();
        Scanner in = new Scanner(System.in);
        System.out.println("Dame un numero binario: ");
        String bin = in.nextLine();

        System.out.println("En binario es: "+ob.binToDec(bin));
    }
}