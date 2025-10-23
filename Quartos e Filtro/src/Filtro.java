import java.util.ArrayList;
import java.util.Scanner;

public class Filtro {
    public static Scanner input = new Scanner(System.in);

    public static void Exibir(String[] a){
        for (String b : a) {
            System.out.println(b);
        }
    }
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

    public static void main(String[] args){
        ArrayList<Quartos> quartos = new ArrayList<>();
        System.out.printf("\n-----------------------------------");
        System.out.printf("\nFiltros");
        System.out.printf("\n[Preco]--[0]");
        System.out.printf("\n[Qualidade]--[1]");
        System.out.printf("\n[Os dois]--[2]");
        System.out.printf("\n-----------------------------------\n");

        // Input usuario
        System.out.println("Quais filtro voce deseja adicionar:");
        String[] Filtro_Desejado = input.nextLine().toLowerCase().split(" ");
        String[] resultado = Selecao_Filtro(Filtro_Desejado);
        Exibir(resultado);
    }
}
