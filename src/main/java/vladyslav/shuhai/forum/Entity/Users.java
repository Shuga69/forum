package vladyslav.shuhai.forum.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean gender;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Posts> posts = new ArrayList<>();
    @ManyToMany
    private List<Chat> chats = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Comments> comments = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();
}
