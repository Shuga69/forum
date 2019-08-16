package vladyslav.shuhai.forum.dto.response;

import lombok.Getter;
import lombok.Setter;
import vladyslav.shuhai.forum.Entity.Comments;

import java.util.Date;

@Getter
@Setter
public class CommentsResponse {
    private Long id;
    private String textField;
    private Date time;
    public CommentsResponse(Comments comments){
        id = comments.getId();
        textField = comments.getTextField();
        time = comments.getTime();
    }
}
