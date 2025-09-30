package repository;

public interface IRepositorio<T> {
    void crear(T t);
    T buscarPorId(int id);
    void actualizar(T t);
    void eliminar(int id);
}
