package vladyslav.shuhai.forum.dto.response;

import lombok.Getter;
import lombok.Setter;
import vladyslav.shuhai.forum.Entity.Chat;

@Getter
@Setter
public class ChatResponse {
    private Long id;
    private Integer usersCount;
    public ChatResponse(Chat chat){
        id = chat.getId();
        usersCount = chat.getUsersCount();
    }
}
