package my.social.social.model.news;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

public class NewsRowMapper implements RowMapper<News> {

    @Override
    public News mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("news_id");
        Long userId = rs.getLong("user_id");
        String title = rs.getString("title");
        String message = rs.getString("message");
        Instant timeOfCreation = rs.getTimestamp("time_of_creation").toInstant();

        return News.builder()
                .id(id)
                .userId(userId)
                .title(title)
                .message(message)
                .timeOfCreation(timeOfCreation)
                .build();
    }
}
