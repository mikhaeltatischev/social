package my.social.social;

import lombok.RequiredArgsConstructor;
import my.social.social.controller.NewsController;
import my.social.social.exception.NewsNotFoundException;
import my.social.social.model.news.News;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@AutoConfigureTestDatabase
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NewsControllerTest {

    private final NewsController newsController;

    @BeforeEach
    public void clearDb() {

    }

    @Test
    public void createAndGetNewsWithId1() throws Exception {
        News news = News.builder()
                .userId(1L)
                .title("title first film")
                .message("message")
                .timeOfCreation(Instant.now())
                .photos(List.of("photo-url"))
                .build();

        assertThat(newsController.add(news))
                .hasFieldOrPropertyWithValue("id", 1L);

        assertThat(newsController.getById(1L))
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("title", "title first film");
    }

    @Test
    public void getNonExistentNews() throws Exception {
        assertThrows(NewsNotFoundException.class, () -> newsController.getById(969L));
    }
}
