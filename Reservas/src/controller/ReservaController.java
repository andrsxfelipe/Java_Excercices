package controller;

import domain.Reserva;
import domain.Sala;
import service.ReservaService;
import utils.UIHelper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReservaController {
    public static void crearReserva(String idStr, String fechaStr, String inicioStr, String finStr){
        final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final DateTimeFormatter FORMAT_24H = DateTimeFormatter.ofPattern("H:mm");

        int id = Integer.parseInt(idStr);
        LocalDate fecha = LocalDate.parse(fechaStr.trim(), FORMAT);
        LocalTime inicio = LocalTime.parse(inicioStr.trim(), FORMAT_24H);
        LocalTime fin = LocalTime.parse(finStr.trim(), FORMAT_24H);

        Reserva reserva = new Reserva(new Sala(id),fecha, inicio, fin);

        ReservaService.crearReserva(reserva);
    }

    public static void consultarReserva(String idStr){
        int id = Integer.parseInt(idStr);
        UIHelper.show(ReservaService.consultarReserva(id));
    }

    public static void cancelarReserva(String idStr){
        int id = Integer.parseInt(idStr);

        if (ReservaService.cancelarReserva(id)){
            UIHelper.show("Reserva cancelada!");
        } else {
            UIHelper.show("Hubo un error en cancelar la reserva, asegurese de ingresar un id válido.");
        }
    }

    public static void verReservas(){
        List<String> reservas = ReservaService.verReservas();
        StringBuilder sb = new StringBuilder();
        for (String r: reservas){
            sb.append(r).append("\n");
        }
        UIHelper.show(sb.toString());
    }
}
