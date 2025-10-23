import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Quartos> quartos = Quartos.sampleList();
        Quartos.Exibir(quartos);
        System.out.printf("%-10s","[Filtros]");
        System.out.printf("\n%-10s","[Preco]--[0]");
        System.out.printf("\n%-10s","[Qualidade]--[1]");
        System.out.printf("\n%-10s","[Os dois]--[2]");
        System.out.printf("\n--------------------------------------------------\n");
    }

}

