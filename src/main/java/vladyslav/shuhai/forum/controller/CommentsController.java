package vladyslav.shuhai.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vladyslav.shuhai.forum.dto.request.CommentsRequest;
import vladyslav.shuhai.forum.dto.response.CommentsResponse;
import vladyslav.shuhai.forum.service.CommentsService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
    @PostMapping
    public void create(@RequestBody CommentsRequest request)
    {
        commentsService.create(request);
    }
    @GetMapping("/byId")
    public CommentsResponse findById(Long id) {
        return new CommentsResponse(commentsService.findById(id));
    }
    @PutMapping
    public void update(Long id, @Valid @RequestBody CommentsRequest request) {
        commentsService.update(id, request);
    }
    @DeleteMapping
    public void delete(Long id) { commentsService.delete(id); }

}
