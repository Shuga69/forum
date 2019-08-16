package vladyslav.shuhai.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.web.bind.annotation.*;
import vladyslav.shuhai.forum.dto.request.ForumsRequest;
import vladyslav.shuhai.forum.dto.response.ForumsResponse;
import vladyslav.shuhai.forum.repository.ForumsRepository;
import vladyslav.shuhai.forum.service.ForumsService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/forums")
public class ForumsController {

    @Autowired
    private ForumsService forumsService;
    @PostMapping
    public void create(@RequestBody ForumsRequest request)
    {
        forumsService.create(request);
    }
    @GetMapping
    public List<ForumsResponse> findAll(){
        return forumsService.findAll();
    }
    @GetMapping("/byId")
    public ForumsResponse findById(Long id) {
        return new ForumsResponse(forumsService.findById(id));
    }
    @PutMapping
    public void update(Long id, @Valid @RequestBody ForumsRequest request) {
        forumsService.update(id, request);
    }
    @DeleteMapping
    public void delete(Long id) {
        forumsService.delete(id);
    }
}
