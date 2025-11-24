package Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class GerenciadorReservas {
    private static List<Dados> reservasAtivas = new ArrayList<>();
    private static int proximoIdReserva = 1001;
    private static final int ID_USUARIO_FIXO = 5001;

    // Novo método: Verifica se o usuário já tem uma reserva ativa
    public static boolean temReservaAtiva(int idUsuario) {
        for (Dados r : reservasAtivas) {
            if (r.getIdUsuario() == idUsuario) {
                return true;
            }
        }
        return false;
    }

    public static int getProximoId() {
        return proximoIdReserva++;
    }

    // O método registrar agora verifica se o usuário pode reservar
    public static boolean registrarReserva(int idQuarto, double valorTotal, int dias) {
        if (temReservaAtiva(ID_USUARIO_FIXO)) {
            // Retorna false se já houver uma reserva
            return false;
        }

        Dados novaReserva = new Dados(
                getProximoId(),
                idQuarto,
                ID_USUARIO_FIXO,
                valorTotal,
                dias
        );

        reservasAtivas.add(novaReserva);

        System.out.println("--- RESERVA REGISTRADA ---");
        System.out.println("ID Reserva: " + novaReserva.getIdReserva());
        // ... (resto do log)

        return true; // Retorna true se a reserva foi feita com sucesso
    }

    // Novo método: Cancela uma reserva pelo ID
    public static boolean cancelarReserva(int idReserva) {
        // Usa Iterator para remover com segurança enquanto itera
        Iterator<Dados> iterator = reservasAtivas.iterator();
        while (iterator.hasNext()) {
            Dados r = iterator.next();
            if (r.getIdReserva() == idReserva && r.getIdUsuario() == ID_USUARIO_FIXO) {
                iterator.remove();
                System.out.println("Reserva ID " + idReserva + " cancelada.");
                return true;
            }
        }
        return false; // Reserva não encontrada ou não pertence ao usuário
    }

    public static List<Dados> getReservasAtivas() {
        return reservasAtivas;
    }

    public static int getIdUsuarioFixo() {
        return ID_USUARIO_FIXO;
    }
}