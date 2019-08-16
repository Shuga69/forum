package vladyslav.shuhai.forum.dto.request;

import lombok.Getter;
import lombok.Setter;
import vladyslav.shuhai.forum.Entity.Chat;

import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
public class ChatRequest {
    @Positive
    private Integer usersCount;
    private List<Long> usersId;
}
