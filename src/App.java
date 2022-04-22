import ui.Login;
import utility.database.Database;
import utility.database.MySQLDatabase;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Database database = new MySQLDatabase();
        repository.User userRepo = new repository.mysql.User(database);
        service.User userService = new service.impl.User(userRepo);
        JFrame frame = new Login(userService);
        frame.setVisible(true);
    }
}