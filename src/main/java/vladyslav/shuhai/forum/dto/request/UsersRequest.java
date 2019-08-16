package vladyslav.shuhai.forum.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class UsersRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private Boolean gender;
    @Email
    private String email;
    @NotBlank
    private String password;
    private List<Long> chatsId;
}
