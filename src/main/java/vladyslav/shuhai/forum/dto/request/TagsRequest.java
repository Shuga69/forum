package vladyslav.shuhai.forum.dto.request;

import lombok.Getter;
import lombok.Setter;
import vladyslav.shuhai.forum.Entity.Posts;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class TagsRequest {
    @NotBlank
private String text;

}
