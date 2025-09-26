import ui.UIHelper;
import service.ProductService;
public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        String[] actions = {"Agregar Producto", "Listar Inventario", "Actualizar Precio", "Actualizar Stock",
                "Eliminar Producto", "Buscar por Nombre", "Salir"};
        while (!exit) {
            int action = UIHelper.menu("Bienvenido", actions);
            switch (action) {
                case 0 -> {
                    ProductService.addProduct();
                }
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
            }
        }
    }

}
