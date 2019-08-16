package vladyslav.shuhai.forum.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ForumsRequest {
    @NotBlank
    private String theme;
}
