public class VerificadorPalindromo {
    private String cadenaOriginal;
    private String cadenaInvertida;

    public VerificadorPalindromo(String cadena) {
        this.cadenaOriginal = cadena;
        this.cadenaInvertida = "";
    }

    public void invertirCadena() {
        for (int i = this.cadenaOriginal.length() - 1; i >= 0; i--) {
            this.cadenaInvertida += this.cadenaOriginal.charAt(i);
        }
    }

    public void mostrarCadenas() {
        System.out.println("Cadena original: " + this.cadenaOriginal);
        System.out.println("Cadena en reversa: " + this.cadenaInvertida);
    }

    public void verificar() {
        for (int i = 0; i < this.cadenaOriginal.length(); i++) {
            if (this.cadenaOriginal.charAt(i) != this.cadenaInvertida.charAt(i)) {
                System.out.println("No es un palindromo");
                return;
            }
        }
        System.out.println("Es un palindromo");
    }
}