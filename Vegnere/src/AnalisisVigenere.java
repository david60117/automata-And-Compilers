public class AnalisisVigenere {

    public static void main(String[] args) {
        String texto = "KIXIPLACZCCOJXGZLEGXGALDJXGZLLVMVWNAZVWCPSZXAMOAKMTALRGQHZPMZVZM";
        int maxShifts = 18;

        System.out.println("Original: " + texto);
        System.out.println("--------------------------------------------------");

        for (int shift = 1; shift <= maxShifts && shift < texto.length(); shift++) {

            // CONTEO DIRECTO SIN USAR GUIONES:
            int coincidencias = 0;
            for (int i = shift; i < texto.length(); i++) {
                if (texto.charAt(i) == texto.charAt(i - shift)) {
                    coincidencias++;
                }
            }

            // SOLO PARA DIBUJAR:
            StringBuilder visual = new StringBuilder();
            for (int s = 0; s < shift; s++) {
                visual.append("_");
            }
            visual.append(texto, 0, texto.length() - shift);

            System.out.printf("Shift %2d: %s (%d)%n", shift, visual.toString(), coincidencias);
        }
    }
}