package vladyslav.shuhai.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vladyslav.shuhai.forum.Entity.Chat;
import vladyslav.shuhai.forum.Entity.Message;
import vladyslav.shuhai.forum.Entity.Users;
import vladyslav.shuhai.forum.dto.request.MessageRequest;
import vladyslav.shuhai.forum.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ChatService chatService;
    public void create(MessageRequest request){
        messageRepository.save(messageRequestToMessage(null,request));
    }
    public Message findById(Long id){
        return messageRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Message with id:"+id+"is not exists"));
    }
    private Message messageRequestToMessage(Message message,MessageRequest request){
        if (message == null){
            message = new Message();
        }
        message.setText(request.getText());
        Users user = usersService.findById(request.getUsersId());
        Chat chat = chatService.findById(request.getChatId());
        message.setChat(chat);
        message.setUser(user);
        return message;
    }
    public void update (Long id , MessageRequest request) {
        messageRepository.save(messageRequestToMessage(findById(id),request));
    }
    public void delete(Long id){
        messageRepository.delete(findById(id));
    }
}
