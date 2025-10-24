import java.util.ArrayList;
import java.util.Scanner;

public class Main_FQ {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        //Cria o objeto de quartos pra exibir
        ArrayList<Quartos> quartos = Quartos.sampleList();
        Quartos.Exibir(quartos);
        System.out.printf("%-10s","[Filtros]");
        System.out.printf("\n%-10s","[Preco]--[0]");
        System.out.printf("\n%-10s","[Qualidade]--[1]");
        System.out.printf("\n%-10s","[Os dois]--[2]");
        System.out.printf("\n--------------------------------------------------\n");

        /**Selecionar o tipo do filtro**/
        System.out.println("Qual filtro voce deseja adicionar:");
        String[] Filtro_Desejado = new String[]{input.nextLine()};

        /**Selecionar quais seram os filtros**/
        String[] resultado = Filtro.Selecao_Filtro(Filtro_Desejado);


        /**Aplicar o filtro**/
        System.out.printf("\nQuartos disponiveis conforme o filtro:");
        //Entra com oq ele quer filtrar,e qual foi o selecionado
        Filtro.Comparar(resultado, Filtro_Desejado);
    }
}