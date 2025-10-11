package view;

import controller.ReservaController;
import utils.UIHelper;

import javax.swing.*;

public class ReservaView {
    public static int verMenu() {
        String[] actions = {"Reservar", "Consultar reserva",
                "Cancelar reserva", "Ver Reservas", "Salir"};
        return UIHelper.menu("Bienvenido", actions);
    }
    public static void crearReserva(){
        JTextField idSalaField = new JTextField();
        JTextField fechaField = new JTextField();
        JTextField horaInicioField = new JTextField();
        JTextField horaFinField = new JTextField();

        Object[] newReservationFields = {
                "ID de la sala: ", idSalaField,
                "Fecha de la reserva: ", fechaField,
                "Hora de inicio: ", horaInicioField,
                "Hora de fin: ", horaFinField
        };

        int confirm = UIHelper.confirm("Agregar Producto",newReservationFields);
        if (confirm == JOptionPane.OK_OPTION) {
            String idSala = idSalaField.getText();
            String fecha = fechaField.getText();
            String horaInicio = horaInicioField.getText();
            String horaFin = horaFinField.getText();

            ReservaController.crearReserva(idSala, fecha, horaInicio, horaFin);
        }
    }

    public static void consultarReserva(){
        String id = UIHelper.input("Ingrese el id de la reserva que desea consultar: ");
        ReservaController.consultarReserva(id);
    }

    public static void cancelarReserva(){
        String id = UIHelper.input("Ingrese el id de la reserva que desea cancelar: ");
        ReservaController.cancelarReserva(id);
    }

    public static void verReservas(){
        ReservaController.verReservas();
    }
}
