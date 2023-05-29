package my.social.social.storage.news;

import my.social.social.exception.NewsNotFoundException;
import my.social.social.model.news.News;
import my.social.social.model.news.NewsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class NewsDbStorage implements NewsStorage {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsDbStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public News add(News news) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("news")
                .usingGeneratedKeyColumns("news_id");

        Long newsId = simpleJdbcInsert.executeAndReturnKey(news.toMap()).longValue();
        news.setId(newsId);

        return news;
    }

    @Override
    public News getById(Long newsId) {
        String sql = "SELECT * FROM news WHERE news_id = ?";

        News news = jdbcTemplate.query(sql, new NewsRowMapper(),newsId)
                .stream()
                .findAny()
                .orElseThrow(() -> new NewsNotFoundException("News with id : " + newsId + " not found."));

        return news;
    }

    @Override
    public List<News> getNewsForUser(Long userId) {
        String sql = "SELECT * FROM news WHERE user_id = ?";

        List<News> news = jdbcTemplate.query(sql, new NewsRowMapper(), userId);

        return news;
    }

    @Override
    public News update(News news) {
        String sql = "UPDATE news SET user_id = ?, title = ?, message = ? WHERE news_id = ?";

        jdbcTemplate.update(sql, news.getUserId(), news.getTitle(), news.getMessage(), news.getId());

        return news;
    }

    @Override
    public News delete(Long newsId) {
        News news = getById(newsId);
        String sql = "DELETE FROM news WHERE news_id = ?";

        jdbcTemplate.update(sql, newsId);

        return news;
    }
}
