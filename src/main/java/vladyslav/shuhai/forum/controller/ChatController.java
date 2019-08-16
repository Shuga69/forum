package vladyslav.shuhai.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vladyslav.shuhai.forum.dto.request.ChatRequest;
import vladyslav.shuhai.forum.dto.response.ChatResponse;
import vladyslav.shuhai.forum.service.ChatService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;
    @PostMapping
    public void create(@RequestBody ChatRequest request)
    {
        chatService.create(request);
    }
    @GetMapping("/byId")
    public ChatResponse findById(Long id) {
        return new ChatResponse(chatService.findById(id));
    }
    @PutMapping
    public void update(Long id, @Valid @RequestBody ChatRequest request) {
        chatService.update(id, request);
    }
    @DeleteMapping
    public void delete(Long id) {
        chatService.delete(id);
    }
}
