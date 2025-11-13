package FormatTelefone;

public class Formatador {

    public static String formatarTelefone(String numero) {
        numero = numero.replaceAll("\\D", "");

        // Verifica o tamanho e aplica o formato adequado
        if (numero.length() == 11) {
            return String.format("(%s) %s-%s",
                    numero.substring(0, 2),
                    numero.substring(2, 7),
                    numero.substring(7));
        } else if (numero.length() == 10) {
            return String.format("(%s) %s-%s",
                    numero.substring(0, 2),
                    numero.substring(2, 6),
                    numero.substring(6));
        } else {
            // Caso o número não tenha tamanho válido
            return numero;
        }
    }
}