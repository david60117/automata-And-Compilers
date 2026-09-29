public class Operaciones {
    private static final int MIN_ASCII = 65;
    private static final int MAX_ASCII = 90;
    private static final int RANGO = MAX_ASCII - MIN_ASCII + 1;

    public String desplazarString(String palabra) {
        String resultado = "";
        resultado += palabra + "\n";

        for (int i = palabra.length() - 1; i > 0; i--) {
            String subpalabra = palabra.substring(0, i);
            int desplazamiento = palabra.length() - i;

            // Contar coincidencias
            int coincidencias = 0;
            for (int j = 0; j < subpalabra.length(); j++) {
                int posOriginal = desplazamiento + j;
                if (subpalabra.charAt(j) == palabra.charAt(posOriginal)) {
                    coincidencias++;
                }
            }

            // Formato con espacios alineado a derecha
            String linea = String.format("%" + palabra.length() + "s", subpalabra);
            resultado += linea + " (" + coincidencias + ")\n";
        }

        return resultado;
    }
}
