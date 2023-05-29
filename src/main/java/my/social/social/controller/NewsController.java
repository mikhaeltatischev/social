package my.social.social.controller;

import jakarta.validation.Valid;
import my.social.social.model.news.News;
import my.social.social.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public News add(@Valid @RequestBody News news) {
        return newsService.add(news);
    }

    @GetMapping("/{newsId}")
    public News getById(@PathVariable Long newsId) {
        return newsService.getById(newsId);
    }

    @GetMapping("/users/{userId}")
    public List<News> getNewsForUser(@PathVariable Long userId) {
        return newsService.getNewsForUser(userId);
    }

    @PutMapping
    public News update(@Valid @RequestBody News news) {
        return newsService.update(news);
    }

    @DeleteMapping("/{newsId}")
    public News delete(@PathVariable Long newsId) {
        return newsService.delete(newsId);
    }
}
