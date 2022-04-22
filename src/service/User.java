package service;

public interface User {
    Boolean login(entity.User user);

    entity.User register(entity.User user);

    Boolean isUsernameAvailable(String username);
}
