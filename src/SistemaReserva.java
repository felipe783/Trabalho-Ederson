import java.util.Scanner;

public class SistemaReserva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        int quartoID;
        int entrada;
        int saida;

        System.out.println("Digite o seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o seu ID: ");
        int ID = sc.nextInt();

        Usuario usuario = new Usuario(ID,nome);
        Reserva reserva = null;
        do{
            System.out.println("======MENU======:");
            System.out.println("1. Iniciar nova reserva");
            System.out.println("2. Consultar reservas ativas");
            System.out.println("3. Cancelar reserva");
            System.out.println("0. Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Sistema Encerrado! ");
                    break;
                case 1:
                    if (reserva != null && reserva.isAtiva()){
                        System.out.println("Você ja tem uma reserva ativa! ");
                        break;
                    }
                    System.out.print("Digite o tipo de quarto desejado \n1 -Básica: R$119,90\n2-Média-R$349,90\n3-Vip-R$689,90\n4-Suite Vip-R$1245,90: ");
                    quartoID = sc.nextInt();
                    System.out.print("Escolha o dia de entrada da reserva:");
                    entrada = sc.nextInt();
                    System.out.println("Escolha o dia de saida da reserva:");
                    saida = sc.nextInt();

                    Quarto q1 = new Quarto(1,"Básica",119.90,entrada,saida);
                    Quarto q2 = new Quarto(2, "Média",349.90,entrada,saida);
                    Quarto q3 = new Quarto(3, "VIP",689.90,entrada,saida);
                    Quarto q4 = new Quarto(4, "Suite VIP",1245.90,entrada,saida);



                    if (quartoID == 1){
                        reserva = new Reserva(q1,usuario);
                    }else if (quartoID == 2){
                        reserva = new Reserva(q2,usuario);
                    }else if (quartoID == 3){
                        reserva = new Reserva(q3,usuario);
                    }else if (quartoID == 4){
                        reserva = new Reserva(q4,usuario);
                    }

                    System.out.println("Reserva realizada com sucesso!");

                    reserva.exibirReserva();
                    break;
                case 2:
                    if (reserva == null){
                        System.out.println("Você nao possui nenhuma reserva! ");
                        break;
                    }
                    reserva.exibirReserva();
                    break;
                case 3:
                    if (reserva == null){
                        System.out.println("Você nao possui nenhuma reserva! ");
                    }else{
                        reserva.cancelarReserva();
                    }
                    break;
                default:
                    System.out.println("Comando invalido! Tente novamente!");
            }
        }while(opcao != 0);
    sc.close();
    }
}
