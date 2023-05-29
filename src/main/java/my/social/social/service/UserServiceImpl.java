package my.social.social.service;

import my.social.social.model.user.User;
import my.social.social.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService{

    private final UserStorage userStorage;

    @Autowired
    public UserServiceImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public User add(User user) {
        return userStorage.add(user);
    }

    @Override
    public Long deleteById(Long id) {
        return userStorage.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        return userStorage.getById(id);
    }

    @Override
    public List<User> getUsers() {
        return userStorage.getUsers();
    }

    @Override
    public User update(User user) {
        userStorage.getById(user.getId());
        return userStorage.update(user);
    }
}
