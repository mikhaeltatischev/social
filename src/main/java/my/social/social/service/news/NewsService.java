package my.social.social.service.news;

import my.social.social.model.news.News;

import java.util.List;

public interface NewsService {

    News add(News news);

    News getById(Long newsId);

    List<News> getNewsForUser(Long userId);

    News update(News news);

    News delete(Long newsId);
}
