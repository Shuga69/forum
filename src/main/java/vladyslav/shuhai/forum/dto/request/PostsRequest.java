package vladyslav.shuhai.forum.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PostsRequest {
    @NotBlank
    private String msgTheme;
    @NotBlank
    private String msgText;
    private Long userId;
    private Long forumId;
    private List<Long> tagsId;
}
