import java.util.ArrayList;
import java.util.Arrays;

public class Operaciones {
    public double binToDec(String bin){
        String []partes = bin.split("\\.");


        for (String c: partes){
            System.out.println(c+"\n"+"***");
        }

        String entera=new StringBuilder(partes[0]).reverse().toString();
        String decimal=new StringBuilder(partes[1]).toString();

        double ac=0;
        double ac2=0;

        for(int k=0;k<entera.length();k++){
            ac=ac+Character.getNumericValue(entera.charAt(k))*Math.pow(2,k);
        }

        for(int k=0;k<decimal.length();k++){
            ac2=ac2+Character.getNumericValue(decimal.charAt(k))*Math.pow(2,-(k+1));

        }
        double total=ac+ac2;
        return total;
    }

    public String decToBin(int dec){
        StringBuilder bin=new StringBuilder();
        while(dec!=0){
            int residuo=dec%2;
            bin.append(residuo);
            dec=dec/2;
        }
        bin.reverse();
        return bin.toString();
    }
}
