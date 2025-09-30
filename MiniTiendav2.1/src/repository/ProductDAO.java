package repository;

import model.Producto;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO implements IRepositorio<Producto>{

    @Override
    public void crear(Producto p) {
        String sql = "INSERT INTO productos (nombre,precio,stock) VALUES (?,?,?)";
        try(Connection conn = ConexionBD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1,p.getNombre());
            stmt.setDouble(2,p.getPrecio());
            stmt.setInt(3,p.getStock());

            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Producto buscarPorId(int id) {
        String sql ="SELECT * FROM productos WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Producto p) {

    }

    @Override
    public void eliminar(int id) {

    }
}
