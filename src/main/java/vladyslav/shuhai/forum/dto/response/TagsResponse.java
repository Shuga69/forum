package vladyslav.shuhai.forum.dto.response;

import lombok.Getter;
import lombok.Setter;
import vladyslav.shuhai.forum.Entity.Tags;

import javax.swing.text.html.HTML;

@Getter
@Setter
public class TagsResponse {
    private Long id;
    private String text;
    public TagsResponse(Tags tags){
        id = tags.getId();
        text = tags.getText();
    }
}
