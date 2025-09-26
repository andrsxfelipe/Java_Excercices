package service;

import dao.ProductoDAO;
import model.Producto;
import ui.UIHelper;

import javax.swing.*;

public class ProductService {
    private static ProductoDAO dao = new ProductoDAO();
    public static void addProduct(){
        JTextField nameField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField stockField = new JTextField();

        Object[] newProductFields = {
                "Producto:",nameField,
                "Precio:",priceField,
                "Cantidad:",stockField
        };
        int confirmAddProduct = UIHelper.confirm("Agregar Producto",newProductFields);
        if (confirmAddProduct == JOptionPane.OK_OPTION){
            String productName = nameField.getText();
            String productPriceStr = priceField.getText();
            double productPrice = Double.parseDouble(productPriceStr);
            String productStockStr = stockField.getText();
            int productStock = Integer.parseInt(productStockStr);

            Producto product = new Producto(productName,productPrice,productStock);
            dao.insertar(product);
        }
    }
}
