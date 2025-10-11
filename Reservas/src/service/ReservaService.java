package service;

import dao.ReservaDAO;
import domain.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaService {
    public static void crearReserva (Reserva reserva){
        ReservaDAO.crearReserva(reserva);
    }

    public static String consultarReserva(int id){
        Reserva reserva = ReservaDAO.consultarReserva(id);
        if (reserva != null){
            return "FORMATEO DE LA INFO DE LA RESERVA";
        } else {
            return "La reserva con el ID que proporcionas no existe.";
        }
    }

    public static boolean cancelarReserva(int id){
        boolean rows = ReservaDAO.cancelarReserva(id);
        return rows;
    }

    public static List<String> verReservas(){
        List<Reserva> reservasList = ReservaDAO.verReservas();
        List<String> reservas = new ArrayList<>();
        if (!reservasList.isEmpty()) {
            for (Reserva r : reservasList) {
                reservas.add("- ID:" + r.getId() + " | Nro de sala: " + r.getSala().getId() + " | Fecha: " + r.getFecha() +
                        " Hora de inicio: " + r.getInicio() + " Hora de finalización: " + r.getFin());
            }
            return reservas;
        }
        else {
            reservas.add("No se encontraron reservas");
            return reservas;
        }
    }
}
