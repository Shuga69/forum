package vladyslav.shuhai.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import vladyslav.shuhai.forum.Entity.Forums;
import vladyslav.shuhai.forum.Entity.Posts;
import vladyslav.shuhai.forum.Entity.Tags;
import vladyslav.shuhai.forum.Entity.Users;
import vladyslav.shuhai.forum.dto.request.ForumsRequest;
import vladyslav.shuhai.forum.dto.request.PaginationRequest;
import vladyslav.shuhai.forum.dto.request.PostsRequest;
import vladyslav.shuhai.forum.dto.response.PageResponse;
import vladyslav.shuhai.forum.dto.response.PostsResponse;
import vladyslav.shuhai.forum.repository.PostsRepository;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private ForumsService forumsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private TagsService tagsService;
    public void create(PostsRequest request){

        postsRepository.save(postsRequestToPosts(null,request));
    }
    public Posts findById(Long id){
        return postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Post with id:"+id+"is not exists"));
    }
    public PageResponse<PostsResponse> findPage(PaginationRequest paginationRequest) {
        Page<Posts> page = postsRepository.findAll(paginationRequest.toPageable());
        return new PageResponse<>(page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(PostsResponse::new).collect(Collectors.toList()));
    }
    private Posts postsRequestToPosts(Posts post,PostsRequest request){
        if(post == null)
        {
            post = new Posts();
        }
        Calendar calendar = new GregorianCalendar();
        post.setMsgTime(calendar.getTime());
        post.setMsgTheme(request.getMsgTheme());
        post.setMsgText(request.getMsgText());
        List<Long> tags = request.getTagsId();
        if(tags!=null&&!tags.isEmpty())
        {
            List<Tags> collect = tags.stream().map(tagsService::findById).collect(Collectors.toList());
            post.setTags(collect);
        }
        Forums forum = forumsService.findById(request.getForumId());
        Users user = usersService.findById(request.getUserId());
        post.setForums(forum);
        post.setUser(user);
        return post;
    }
    public void update(Long id, PostsRequest request) {
        postsRepository.save(postsRequestToPosts(findById(id), request));
    }
    public void delete(Long id) {
        postsRepository.delete(findById(id));
    }
}
