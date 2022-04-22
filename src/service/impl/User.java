package service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import utility.logger.Level;
import utility.logger.Log;

public class User implements service.User {

    repository.User userRepo;

    public User(repository.User userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Boolean login(entity.User user) {
        entity.User temp = userRepo.Fetch(user.getUsername());
        if (temp == null) {
            return false;
        }

        BCrypt.Result result;
        try {
            result = BCrypt.verifyer().verify(user.getPassword().toCharArray(),
                    temp.getPassword());
            Log.println(Level.INFO, "BCrypt Operation Succeed");
        } catch (Exception e) {
            Log.println(Level.ERROR, e.getMessage());
            return false;
        }

        if (result.verified) {
            Log.println(Level.INFO,
                    String.format("Logged In As User(%s,%s," + "%s)",
                            temp.getId(), temp.getUsername(),
                            temp.getPassword()));
            return true;
        } else {
            Log.println(Level.ERROR,
                    String.format("Failed To Login As User" + "(%s,%s)", user.getUsername(),
                            user.getPassword()));
            return false;
        }
    }

    @Override
    public entity.User register(entity.User user) {
        boolean available = isUsernameAvailable(user.getUsername());
        if (!available) {
            Log.println(Level.ERROR,
                    String.format("Failed To Register User" + "(%s,%s,%s)",
                            user.getId(), user.getUsername(),
                            user.getPassword()));
            return null;
        }

        String hashedPassword = null;
        try {
            hashedPassword = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST,
                    user.getPassword().toCharArray());
            Log.println(Level.INFO, "BCrypt Compare Hash And Password Success");
        } catch (Exception e) {
            Log.println(Level.ERROR, e.getMessage());
        }

        user.setPassword(hashedPassword);

        entity.User rtn = userRepo.Store(user);
        if (rtn != null) {
            Log.println(Level.INFO,
                    String.format("Registered A New User(%s," + "%s,%s)",
                            rtn.getId(), rtn.getUsername(), rtn.getPassword()));
            return rtn;
        } else {
            Log.println(Level.ERROR,
                    String.format("Failed To Register User" + "(%s,%s)",
                            user.getUsername(), user.getPassword()));
            return null;
        }
    }

    @Override
    public Boolean isUsernameAvailable(String username) {
        entity.User user = userRepo.Fetch(username);
        if (user == null) {
            Log.println(Level.INFO,
                    String.format("Username %s Is Not Exist " + "In Database",
                            username));
            return true;
        } else {
            Log.println(Level.INFO,
                    String.format("Username %s Is Exist In " + "Database",
                            username));
            return false;
        }
    }
}
