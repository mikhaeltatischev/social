package my.social.social.service.news;

import my.social.social.model.news.News;
import my.social.social.storage.news.NewsStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class NewsServiceImpl implements NewsService {

    private final NewsStorage newsStorage;

    @Autowired
    public NewsServiceImpl(NewsStorage newsStorage) {
        this.newsStorage = newsStorage;
    }

    @Override
    public News add(News news) {
        return newsStorage.add(news);
    }

    @Override
    public News getById(Long newsId) {
        return newsStorage.getById(newsId);
    }

    @Override
    public List<News> getNewsForUser(Long userId) {
        return newsStorage.getNewsForUser(userId);
    }

    @Override
    public News update(News news) {
        return newsStorage.update(news);
    }

    @Override
    public News delete(Long newsId) {
        return newsStorage.delete(newsId);
    }
}
