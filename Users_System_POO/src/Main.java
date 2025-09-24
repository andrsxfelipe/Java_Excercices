import security.Autenticable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

abstract class User implements Autenticable {
    String name;
    String email;
    String password;
    boolean isActive;

    public User(String name, String email, String password, boolean isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    @Override
    public boolean authenticate(String email,String password) {
        return this.password.equals(password) && this.email.equals(email) && isActive;
    }

    @Override
    public void setPassword(String password) {

    }

    abstract void enterProgram();

    void checkMyProfile(){
        JOptionPane.showMessageDialog(null,"Mi perfil:\n - Nombre: "+name+"\n - Email: "+email+(isActive ? "\n - Activo":"\n - Inactivo"));
    }
}

class Admin extends User {
    public Admin(String name, String email, String password, boolean isActive) {
        super(name, email, password, isActive);
    }

    @Override
    public void enterProgram(){
        String[] adminActions = {"Ver mi perfil","Bloquear usuario","Lista de usuarios"};
        int action = JOptionPane.showOptionDialog(
                null,
                "¿Qué deseas hacer?",
                "Admin - Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                adminActions,
                adminActions[0]
        );
        switch (action){
            case 0:
                checkMyProfile();
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }
}

class Costumer extends User {
    public Costumer(String name, String email, String password, boolean isActive) {
        super(name, email, password, isActive);
    }

    @Override
    public void enterProgram(){
        String[] costumerActions = {"Ver mi perfil","Actualizar info"};

        int action = JOptionPane.showOptionDialog(
                null,
                "¿Qué deseas hacer?",
                "Cliente - Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                costumerActions,
                costumerActions[0]
        );
        switch (action){
            case 0:
                break;
            case 1:
                break;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        final List<User> users = new ArrayList<>();
        boolean exit = false;
        boolean auth = false;
        User authUser = null;
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        Object[] message = {
                "Username:", userField,
                "Password:", passField
        };
        int option = JOptionPane.showConfirmDialog(
                null, message, "Login",
                JOptionPane.OK_CANCEL_OPTION
        );
        if (option == JOptionPane.OK_OPTION) {
            String user = userField.getText();
            String password = new String(passField.getPassword());
            for (User u : users ){
                if (u.authenticate(user, password)){
                    authUser = u;
                    break;
                }
            }
            if (authUser != null){
                int action = authUser.enterProgram();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas");
            }
        }
    }
}