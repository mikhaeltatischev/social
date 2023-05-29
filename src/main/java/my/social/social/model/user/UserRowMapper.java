package my.social.social.model.user;

import my.social.social.model.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long userId = rs.getLong("user_id");
        String login = rs.getString("login");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String username = rs.getString("username");
        LocalDate birthday = rs.getDate("birthday").toLocalDate();
        String city = rs.getString("city");

        return new User(userId, login, email, phone, username, birthday, city);
    }
}
