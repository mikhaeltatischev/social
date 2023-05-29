package my.social.social.service.user;

import my.social.social.model.user.User;

import java.util.List;

public interface UserService {

    User add(User user);

    Long delete(Long id);

    User getById(Long id);

    List<User> getUsers();

    User update(User user);
}
