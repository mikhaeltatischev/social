package my.social.social.storage;

import my.social.social.model.user.User;

import java.util.List;

public interface UserStorage {
    User add(User user);

    Long deleteById(Long id);

    User getById(Long id);

    List<User> getUsers();

    User update(User user);
}
