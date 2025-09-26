package dao;

import model.Producto;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public void insertar(Producto p){
        String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,p.getNombre());
            stmt.setDouble(2, p.getPrecio());
            stmt.setInt(3,p.getStock());

            stmt.executeUpdate();
            System.out.println("Producto agregado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
