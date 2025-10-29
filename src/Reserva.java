import java.time.*;
public class Reserva {
    private Quarto quarto;
    private Usuario usuario;
    private LocalDateTime time;
    private boolean ativa;

    public Reserva(Quarto quarto, Usuario usuario) {
        this.quarto = quarto;
        this.usuario = usuario;
        this.time = LocalDateTime.now();
        this.ativa = true;
    }

    public void cancelarReserva(){
        if(!ativa){
            System.out.println("A reserva ja foi cancelada!");
            return;
        }

        Duration duracao = Duration.between(time, LocalDateTime.now());
        long horas = duracao.toHours();

        if(horas >= 24){
            System.out.println("Cancelamento após 24h de limite! taxa de R$100 aplicada!");
        }else{
            System.out.println("Cancelamento dentro do prazo! Nenhuma taxa será cobrada!");
        }
        ativa = false;

    }


    public void exibirReserva(){
        System.out.println("\n--- Detalhes da Reserva ---");
        System.out.println("Usuário: " + usuario.getNome() + " (ID: " + usuario.getId() + ")");
        System.out.println("Quarto: " + quarto.getTipo() + " (ID: " + quarto.getID() + ")");
        System.out.println("Preço: R$" + quarto.calculo(quarto.getEntrada(), quarto.getSaida(), quarto.getID()));
        System.out.println("Data da reserva: " + time);
        System.out.println("Status: " + (ativa ? "Ativa" : "Cancelada"));
        System.out.println("----------------------------\n");
    }
    public boolean isAtiva(){
        return ativa;
    }

}
