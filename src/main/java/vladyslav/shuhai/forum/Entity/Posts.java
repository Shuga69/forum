package vladyslav.shuhai.forum.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String msgTheme;

    private String msgText;

    private Date msgTime;


    @ManyToOne
    private Users user;
    @OneToMany(mappedBy = "posts")
    private List <Comments> comments = new ArrayList<>();
    @ManyToOne
    private Forums forums;
    @ManyToMany(mappedBy = "post")
    private List <Tags> tags = new ArrayList<>();
}
