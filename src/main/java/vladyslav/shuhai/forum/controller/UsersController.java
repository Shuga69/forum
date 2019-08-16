package vladyslav.shuhai.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vladyslav.shuhai.forum.dto.request.UsersRequest;
import vladyslav.shuhai.forum.dto.response.UsersResponse;
import vladyslav.shuhai.forum.service.UsersService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @PostMapping
    public void create(@RequestBody UsersRequest request){
        usersService.create(request);
    }
    @GetMapping("/byId")
    public UsersResponse findById(Long id) {
        return new UsersResponse(usersService.findById(id));
    }
    @PutMapping
    public void update(Long id, @Valid @RequestBody UsersRequest request) {
        usersService.update(id, request);
    }
    @DeleteMapping
    public void delete(Long id) {
        usersService.delete(id);
    }
}
