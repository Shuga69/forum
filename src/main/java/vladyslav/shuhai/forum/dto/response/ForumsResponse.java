package vladyslav.shuhai.forum.dto.response;

import lombok.Getter;
import lombok.Setter;
import vladyslav.shuhai.forum.Entity.Forums;
@Setter
@Getter
public class ForumsResponse {
    private String theme;
    private Long id;
    public ForumsResponse(Forums forums){
        theme = forums.getTheme();
        id = forums.getId();
    }



}
