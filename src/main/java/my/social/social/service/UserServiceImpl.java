package my.social.social.service;

import my.social.social.model.user.User;
import my.social.social.storage.UserStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserStorage userStorage;


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
        return userStorage.update(user);
    }
}
