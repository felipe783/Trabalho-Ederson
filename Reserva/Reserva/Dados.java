package Reserva;

public class Dados {
    private int idReserva;
    private int idQuarto; // O número do quarto (q.getNumero())
    private int idUsuario;
    private double valorTotal;
    private int dias;

    public Dados(int idReserva, int idQuarto, int idUsuario, double valorTotal, int dias) {
        this.idReserva = idReserva;
        this.idQuarto = idQuarto;
        this.idUsuario = idUsuario;
        this.valorTotal = valorTotal;
        this.dias = dias;
    }

    // Getters para acessar as informações (necessários para a consulta/cancelamento)
    public int getIdReserva() { return idReserva; }
    public int getIdQuarto() { return idQuarto; }
    public int getIdUsuario() { return idUsuario; }

    public double getValorTotal() { return valorTotal;
    }
    public int getDias() { return dias; }
    // ... outros getters
}
