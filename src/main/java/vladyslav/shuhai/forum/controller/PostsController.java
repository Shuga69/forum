package vladyslav.shuhai.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vladyslav.shuhai.forum.dto.request.ForumsRequest;
import vladyslav.shuhai.forum.dto.request.PaginationRequest;
import vladyslav.shuhai.forum.dto.request.PostsRequest;
import vladyslav.shuhai.forum.dto.response.ForumsResponse;
import vladyslav.shuhai.forum.dto.response.PageResponse;
import vladyslav.shuhai.forum.dto.response.PostsResponse;
import vladyslav.shuhai.forum.service.PostsService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostsService postsService;
    @PostMapping
    public void create(@RequestBody PostsRequest request)
    {
        postsService.create(request);
    }
    @GetMapping("/byId")
    public PostsResponse findById(Long id) {
        return new PostsResponse(postsService.findById(id));
    }
    @GetMapping("/byPages")
    public PageResponse<PostsResponse> findAll(PaginationRequest paginationRequest) {
        return postsService.findPage(paginationRequest);
    }
    @PutMapping
    public void update(Long id, @Valid @RequestBody PostsRequest request) {
        postsService.update(id, request);
    }
    @DeleteMapping
    public void delete(Long id) {
        postsService.delete(id);
    }

}
