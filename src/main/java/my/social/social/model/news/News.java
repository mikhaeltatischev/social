package my.social.social.model.news;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@Builder
public class News {

    private Long id;
    private Long userId;
    private String title;
    private String message;
    @NotNull
    @Past
    private Instant timeOfCreation;
    private List<String> photos;

    public Map<String, Object> toMap() {
        Map<String, Object> values = new HashMap<>();
        values.put("userId", userId);
        values.put("title", title);
        values.put("message", message);
        values.put("time_of_creation", timeOfCreation);

        return values;
    }
}
