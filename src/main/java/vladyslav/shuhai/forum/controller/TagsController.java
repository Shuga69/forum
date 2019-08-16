package vladyslav.shuhai.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vladyslav.shuhai.forum.dto.request.TagsRequest;
import vladyslav.shuhai.forum.dto.response.TagsResponse;
import vladyslav.shuhai.forum.service.TagsService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/tags")
public class TagsController {
    @Autowired
    private TagsService tagsService;
    @PostMapping
    public void create (@Valid @RequestBody TagsRequest request){
        tagsService.create(request);
    }
    @GetMapping("/byId")
    public TagsResponse findById(Long id) {
        return new TagsResponse(tagsService.findById(id));
    }
    @PutMapping
    public void update(Long id, @Valid @RequestBody TagsRequest request) {
        tagsService.update(id, request);
    }
    @DeleteMapping
    public void delete(Long id) {
        tagsService.delete(id);
    }

}
