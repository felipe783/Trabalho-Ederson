import java.util.Scanner;
import java.time.LocalDate;

public class Reserva {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja reservar um quarto?( 1- sim / 0 -nao):");
        int opcao = sc.nextInt();

        if (opcao == 1) {
            System.out.print("Digite o tipo de quarto desejado \n1 -Básica: R$119,90\n2-Média-R$349,90\n3-Vip-R$689,90\n4-Suite Vip-R$1245,90: ");
            int quarto = sc.nextInt();
            System.out.print("Escolha o dia de entrada da reserva:");
            int entrada = sc.nextInt();
            System.out.println("Escolha o dia de saida da reserva:");
            int saida = sc.nextInt();
            System.out.print("Escolha o quarto desejado:\n" +
                    "1 - 101" +
                    "2 - 102" +
                    "3 - 201" +
                    "4 - 202");
            int numeroQuarto = sc.nextInt();

            ValorReserva valor = new ValorReserva(entrada,saida,quarto);



            System.out.print("Reserva concluida!\n" +
                    "Data programada: %d até %d Valor total: R$"),entrada,saida;


        }


    }
}
