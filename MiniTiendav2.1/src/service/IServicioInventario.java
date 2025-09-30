package service;

import model.Producto;

import java.util.List;

public interface IServicioInventario {
    void agregarProducto(Producto p);
    void actualizarPrecio(int id, double nuevoPrecio);
    void actualizarStock(int id, int nuevoStock);
    void eliminarProducto(int id);
    List<Producto> buscarPorNombre(String NOmbre);
}
