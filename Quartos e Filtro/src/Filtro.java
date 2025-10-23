import java.util.ArrayList;
import java.util.Scanner;
import java.text.Normalizer;

public class Filtro {
    public static Scanner input = new Scanner(System.in);

    public static String[] Selecao_Filtro(String[] aux){
        String[] filtro_tipo = null;
        for (String tipo : aux) {
            if (tipo.equals("0")) { // Preço
                System.out.println("O preco do quarto que voce deseja filtrar:");
                filtro_tipo = input.nextLine().toLowerCase().split(" ");
            }
            else{
                if (tipo.equals("1")) { // Qualidade
                    System.out.println("Fale a qualidade do quarto que voce deseja filtrar:");
                    filtro_tipo = input.nextLine().toLowerCase().split(" ");
                }
                else { // Dois (qualidade/preço)
                    System.out.println("Fale a qualidade/preco do quarto que voce deseja filtrar:");
                    filtro_tipo = input.nextLine().toLowerCase().split(" ");
                }
            }
        }
        return filtro_tipo;
    }
    public static void Comparar(String[] filtro,String[] tipos){

        ArrayList<Quartos> quartos = Quartos.sampleList();
    }

}
