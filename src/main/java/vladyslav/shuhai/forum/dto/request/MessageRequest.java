package vladyslav.shuhai.forum.dto.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequest {
    private String text;
    private Long usersId;
    private Long chatId;
}
