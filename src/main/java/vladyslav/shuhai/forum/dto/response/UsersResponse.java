package vladyslav.shuhai.forum.dto.response;

import lombok.Getter;
import lombok.Setter;
import vladyslav.shuhai.forum.Entity.Users;

@Getter
@Setter
public class UsersResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean gender;
    private String email;
    private String password;
    public UsersResponse(Users users){
        id = users.getId();
        firstName = users.getFirstName();
        lastName = users.getLastName();
        gender = users.getGender();
        email = users.getEmail();
        password = users.getPassword();
    }

}
