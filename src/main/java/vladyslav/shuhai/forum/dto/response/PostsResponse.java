package vladyslav.shuhai.forum.dto.response;

import lombok.Getter;
import lombok.Setter;
import vladyslav.shuhai.forum.Entity.Posts;

import java.sql.Time;
import java.util.Date;
@Getter
@Setter
public class PostsResponse {
    private String msgTheme;
    private String msgText;
    private Date msgTime;
    private Long id;
    public PostsResponse(Posts posts){
        id = posts.getId();
        msgTheme = posts.getMsgTheme();
        msgText = posts.getMsgText();
        msgTime = posts.getMsgTime();
    }
}
