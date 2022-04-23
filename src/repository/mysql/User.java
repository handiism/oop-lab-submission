package repository.mysql;

import utility.database.Database;
import utility.logger.Level;
import utility.logger.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User implements repository.User {
    private final Database database;
    private PreparedStatement pstmt;

    public User(Database database) {
        this.database = database;
    }

    @Override
    public entity.User Store(entity.User user) {
        try {
            pstmt = database.connection().prepareStatement("INSERT INTO users (username,password) VALUES (?, ?)",
                    new String[] { "id", "username", "password" });
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());

            pstmt.executeUpdate();
            Log.println(Level.INFO, String.format("INSERT INTO users (username,password) VALUES (%s, %s)",
                    user.getUsername(), user.getPassword()));

            ResultSet keys = pstmt.getGeneratedKeys();

            if (keys.next()) {
                user.setId(keys.getInt(1));
            }

            if (keys.next()) {
                user.setUsername(keys.getString(1));
            }

            if (keys.next()) {
                user.setPassword(keys.getString(1));
            }

            Log.println(Level.INFO, String.format("Store User{%d,%S,%s}",
                    user.getId(), user.getUsername(), user.getPassword()));
            return user;
        } catch (Exception e) {
            Log.println(Level.ERROR, e.getMessage());
            return null;
        }
    }

    @Override
    public entity.User Fetch(String username) {
        entity.User user = new entity.User();
        try {
            pstmt = database.connection().prepareStatement("SELECT * FROM users WHERE username = ?");
            pstmt.setString(1, username);

            ResultSet keys = pstmt.executeQuery();
            Log.println(Level.INFO, String.format("SELECT * FROM users WHERE username = '%s'", username));

            if (keys.next()) {
                user.setId(keys.getInt("id"));
                user.setUsername(keys.getString("username"));
                user.setPassword(keys.getString("password"));
            }

            if (user.getId() == 0 || user.getUsername() == null || user.getPassword() == null) {
                return null;
            }

            Log.println(Level.INFO, String.format("Fetch User{%d,%S,%s}",
                    user.getId(), user.getUsername(), user.getPassword()));
            return user;
        } catch (Exception e) {
            Log.println(Level.ERROR, e.getMessage());
            return null;
        }
    }
}
