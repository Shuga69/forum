package vladyslav.shuhai.forum.service;



import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import vladyslav.shuhai.forum.Entity.Chat;
import vladyslav.shuhai.forum.Entity.Forums;
import vladyslav.shuhai.forum.Entity.Users;
import vladyslav.shuhai.forum.dto.request.UsersRequest;
import vladyslav.shuhai.forum.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ChatService chatService;
    public void create(UsersRequest request){
      usersRepository.save(usersRequestToUsers(null,request));
    }
    public void update(Long id, UsersRequest request) {
        usersRepository.save(usersRequestToUsers(findById(id), request));
    }
    public void delete(Long id) {
        usersRepository.delete(findById(id));
    }
    private Users usersRequestToUsers(Users user,UsersRequest request){
        if(user == null)
        {
            user = new Users();
        }
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setPassword(request.getPassword());
        List<Long> chats = request.getChatsId();
        if(chats!=null&&!chats.isEmpty())
        {
            List<Chat> collect = chats.stream().map(chatService::findById).collect(Collectors.toList());
            user.setChats(collect);
        }
        return user;
    }
    public Users findById(Long id){
        return usersRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User with id:"+id+"is not exists"));
    }
}
