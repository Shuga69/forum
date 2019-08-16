package vladyslav.shuhai.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vladyslav.shuhai.forum.Entity.Forums;
import vladyslav.shuhai.forum.dto.request.ForumsRequest;
import vladyslav.shuhai.forum.dto.response.ForumsResponse;
import vladyslav.shuhai.forum.repository.ForumsRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ForumsService {
@Autowired
    private ForumsRepository forumsRepository;
    public void create(ForumsRequest request){
        forumsRepository.save(categoryRequestToCategory(null, request));
    }
    public List<ForumsResponse> findAll(){
        return forumsRepository.findAll().stream()
                .map(ForumsResponse::new).collect(Collectors.toList());
    }
    public Forums findById(Long id){
        return forumsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Forum with id:"+id+"is not exists"));
    }
    public void update(Long id, ForumsRequest request) {
        forumsRepository.save(categoryRequestToCategory(findById(id), request));
    }
    private Forums categoryRequestToCategory(Forums forums, ForumsRequest request) {
        if (forums == null) {
            forums = new Forums();
        }
        forums.setTheme(request.getTheme());
        return forums;
    }
    public void delete(Long id) {
        forumsRepository.delete(findById(id));
    }
    //findAllPosts findOnePost
}
