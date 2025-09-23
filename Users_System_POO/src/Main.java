import javax.swing.*;
import service.UserService;

public class Main {
    private final UserService userService;

    public Main(){
        this.userService = new UserService();
    }

    public static void main(String[] args) {
        boolean exit = false;
        boolean auth = false;
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
            auth = userService.auth(user,password);
        }
    }
}