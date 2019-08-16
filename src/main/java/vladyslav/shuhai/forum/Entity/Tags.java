package vladyslav.shuhai.forum.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String text;
    @ManyToMany
    private List<Posts> post = new ArrayList<>();

}
