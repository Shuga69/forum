package vladyslav.shuhai.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vladyslav.shuhai.forum.dto.request.MessageRequest;
import vladyslav.shuhai.forum.dto.response.MessageResponse;
import vladyslav.shuhai.forum.service.MessageService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/personalmessage")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @PostMapping
    public void create(@RequestBody MessageRequest request)
    {
        messageService.create(request);
    }
    @GetMapping("/byId")
    public MessageResponse findById(Long id) {
        return new MessageResponse(messageService.findById(id));
    }
    @PutMapping
    public void update(Long id, @Valid @RequestBody MessageRequest request) {
        messageService.update(id, request);
    }
    @DeleteMapping
    public void delete(Long id) {
        messageService.delete(id);
    }

}
