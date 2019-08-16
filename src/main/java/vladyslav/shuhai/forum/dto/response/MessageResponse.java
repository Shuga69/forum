package vladyslav.shuhai.forum.dto.response;

import lombok.Getter;
import lombok.Setter;
import vladyslav.shuhai.forum.Entity.Message;

@Getter
@Setter
public class MessageResponse {
    private Long id;
    private String text;
    public MessageResponse(Message message){
        id = message.getId();
        text = message.getText();
    }
}
