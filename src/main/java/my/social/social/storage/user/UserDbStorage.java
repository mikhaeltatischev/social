package my.social.social.storage.user;

import my.social.social.exception.UserNotFoundException;
import my.social.social.model.user.User;
import my.social.social.model.user.UserRowMapper;
import my.social.social.storage.user.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class UserDbStorage implements UserStorage {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDbStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User add(User user) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("users")
                .usingGeneratedKeyColumns("user_id");

        Long userId = simpleJdbcInsert.executeAndReturnKey(user.toMap()).longValue();
        user.setId(userId);

        return user;
    }

    @Override
    public Long delete(Long id) {
        String sql = "DELETE FROM users WHERE user_id = ?";

        jdbcTemplate.update(sql, id);

        return id;
    }

    @Override
    public User getById(Long id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        return jdbcTemplate.query(sql, new UserRowMapper(), id)
                .stream()
                .findAny()
                .orElseThrow(() -> new UserNotFoundException("User with id - " + id + " not found"));
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM users";

        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public User update(User user) {
        String sql = "UPDATE users SET login = ?, email = ?, phone = ?, username = ?, birthday = ?, city = ? WHERE " +
                "user_id = ?";

        jdbcTemplate.update(sql, user.getLogin(), user.getEmail(), user.getPhone(), user.getUsername(),
                    user.getBirthday(), user.getCity(), user.getId());

        return user;
    }
}
