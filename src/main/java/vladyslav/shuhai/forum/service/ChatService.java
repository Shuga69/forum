package vladyslav.shuhai.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vladyslav.shuhai.forum.Entity.Chat;
import vladyslav.shuhai.forum.Entity.Users;
import vladyslav.shuhai.forum.dto.request.ChatRequest;
import vladyslav.shuhai.forum.dto.request.UsersRequest;
import vladyslav.shuhai.forum.repository.ChatRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {
@Autowired
    private ChatRepository chatRepository;
@Autowired
private UsersService usersService;
    public void create(ChatRequest request){
        chatRepository.save(chatRequestToChat(null,request));
    }
    public Chat findById(Long id){
        return chatRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Chat with id:"+id+"is not exists"));
    }
    private Chat chatRequestToChat(Chat chat,ChatRequest request){
        if (chat == null){
            chat = new Chat();
        }
       chat.setUsersCount(chat.getUsers().size());
        List<Long> users = request.getUsersId();
        if(users!=null&&!users.isEmpty())
        {
            List<Users> collect = users.stream().map(usersService::findById).collect(Collectors.toList());
            chat.setUsers(collect);
        }
        return chat;
    }
    public void update(Long id,ChatRequest request){
        chatRepository.save(chatRequestToChat(findById(id),request));
    }
    public void delete(Long id){
        chatRepository.delete(findById(id));
    }
}
