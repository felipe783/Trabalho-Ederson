public class Usuario {
    private int ID;
    private String nome;

    public Usuario(int ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public void reservarQuarto(QuartoID quarto){
        ValorReserva valor = new ValorReserva(quarto.entrada,quarto.saida,quarto.ID);
        System.out.println("Reserva concluida!!!");
        System.out.println("Usuário: " + nome + " (ID: " + ID + ")");
        System.out.println("Quarto: " + quarto.tipo + " (ID: " + quarto.ID + ")");
        System.out.println("Preço da reserva: R$" + valor.calculo(quarto.entrada,quarto.saida,quarto.ID));
        System.out.println("Associação: Usuário " + ID + " → Quarto " + quarto.ID);

    }
}
