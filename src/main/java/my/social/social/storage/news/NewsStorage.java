package my.social.social.storage.news;

import my.social.social.model.news.News;

import java.util.List;

public interface NewsStorage {

    News add(News news);

    News getById(Long newsId);

    List<News> getNewsForUser(Long userId);

    News update(News news);

    News delete(Long newsId);
}
