package repository;

public interface User {
    entity.User Store(entity.User user);

    entity.User Fetch(String username);
}
