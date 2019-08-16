package vladyslav.shuhai.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vladyslav.shuhai.forum.Entity.Comments;
import vladyslav.shuhai.forum.Entity.Posts;
import vladyslav.shuhai.forum.Entity.Users;
import vladyslav.shuhai.forum.dto.request.CommentsRequest;
import vladyslav.shuhai.forum.repository.CommentsRepository;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class CommentsService {
@Autowired
    private CommentsRepository commentsRepository;
@Autowired
private UsersService usersService;
@Autowired
private PostsService postsService;
    public void create(CommentsRequest request){

        commentsRepository.save(commentsRequestToComments(null,request));
    }
    public Comments findById(Long id){
        return commentsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Comment with id:"+id+"is not exists"));
    }
    private Comments commentsRequestToComments(Comments comment,CommentsRequest request){
        if(comment == null)
        {
            comment = new Comments();
        }
        Calendar calendar = new GregorianCalendar();
        comment.setTime(calendar.getTime());
        comment.setTextField(request.getTextField());
        Users user = usersService.findById(request.getUserId());
        Posts post = postsService.findById(request.getPostId());
        comment.setPosts(post);
        comment.setUser(user);
        return comment;
    }
    public void update(Long id, CommentsRequest request) {
        commentsRepository.save(commentsRequestToComments(findById(id), request));
    }
    public void delete(Long id) {
        commentsRepository.delete(findById(id));
    }

}
