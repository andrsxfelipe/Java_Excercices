package dao;

import config.ConfigBD;
import domain.Reserva;
import domain.Sala;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    public static void crearReserva(Reserva reserva){
        String sql = "INSERT INTO reserva (sala_id, fecha, inicio, fin) VALUES (?,?,?,?)";
        try (Connection conn = ConfigBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setInt(1,reserva.getSala().getId());
            stmt.setObject(2,reserva.getFecha());
            stmt.setObject(3, reserva.getInicio());
            stmt.setObject(4, reserva.getFin());

            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Reserva consultarReserva(int id){
        String sql = "SELECT * FROM reservas WHERE id = ?";
        Reserva reserva = null;
        try (Connection conn = ConfigBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                reserva = new Reserva(
                        rs.getInt("id"),
                        new Sala(rs.getInt("sala_id")),
                        rs.getObject("fecha", LocalDate.class),
                        rs.getObject("inicio", LocalTime.class),
                        rs.getObject("fin", LocalTime.class)
                );
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return reserva;
    }

    public static boolean cancelarReserva(int id){
        String sql = "DELETE FROM reservas WHERE id = ?";

        try (Connection conn = ConfigBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setInt(1,id);

            int rows = stmt.executeUpdate();
            return (rows>0);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static List<Reserva> verReservas(){
        String sql = "SELECT * FROM reservas";
        List<Reserva> reservas = new ArrayList();

        try (Connection conn = ConfigBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                reservas.add(new Reserva(
                        rs.getInt("id"),
                        new Sala(rs.getInt("id_sala")),
                        rs.getObject("fecha", LocalDate.class),
                        rs.getObject("inicio", LocalTime.class),
                        rs.getObject("fin", LocalTime.class)
                ));
            }

            return reservas;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return reservas;
    }
}