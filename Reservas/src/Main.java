import utils.UIHelper;
import view.ReservaView;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        String[] actions = {"Reservar", "Consultar reserva",
                "Cancelar reserva", "Ver Reservas", "Salir"};
        while (!exit) {
            int action = ReservaView.verMenu();
            switch (action){
                case 0 ->{
                    ReservaView.crearReserva();
                }
                case 1 -> {
                    ReservaView.consultarReserva();
                }
                case 2 -> {
                    ReservaView.cancelarReserva();
                }
                case 3 -> {
                    ReservaView.verReservas();
                }
                default -> {
                    exit = true;
                }
            }
        }
    }
}