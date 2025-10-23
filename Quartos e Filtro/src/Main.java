import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
        System.out.println("Quais filtro voce deseja adicionar:");
        String[] Filtro_Desejado = input.nextLine().toLowerCase().split(" ");

        /**Selecionar quais seram os filtros**/
        String[] resultado = Filtro.Selecao_Filtro(Filtro_Desejado);

        /**Aplicar o filtro**/

        System.out.printf("Quartos disponiveis conforme o filtro:");
        for(Quartos q : quartos){
            /*if(q.Comparar(filtro_tipo)){
                System.out.print(q);
            }*/
        }
    }
}
