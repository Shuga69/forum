package vladyslav.shuhai.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vladyslav.shuhai.forum.Entity.Posts;
import vladyslav.shuhai.forum.Entity.Tags;
import vladyslav.shuhai.forum.Entity.Users;
import vladyslav.shuhai.forum.dto.request.TagsRequest;
import vladyslav.shuhai.forum.dto.request.UsersRequest;
import vladyslav.shuhai.forum.repository.TagsRepository;
import vladyslav.shuhai.forum.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagsService {
    @Autowired
    private TagsRepository tagsRepository;
    @Autowired PostsService postsService;
    public void create(TagsRequest request){

        tagsRepository.save(tagsRequestToTags(null,request));
    }
    public Tags findById(Long id){
        return tagsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Tag with id:"+id+"is not exists"));
    }
    private Tags tagsRequestToTags(Tags tags,TagsRequest request){
        if (tags == null){
            tags = new Tags();
        }
         tags.setText(request.getText());
//        List<Long> posts = request.getPostsId();
//        if(posts!=null&&!posts.isEmpty())
//        {
//            List<Posts> collect = posts.stream().map(postsService::findById).collect(Collectors.toList());
//            tags.setPost(collect);
//        }
        return tags;
    }
    public void update(Long id,TagsRequest request){
        tagsRepository.save(tagsRequestToTags(findById(id),request));
    }
    public void delete(Long id){
        tagsRepository.delete(findById(id));
    }
}
