package vladyslav.shuhai.forum.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class CommentsRequest {
    @NotBlank
    private String textField;
    private Date time;
    private Long userId;
    private Long postId;

}
