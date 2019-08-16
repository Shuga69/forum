package vladyslav.shuhai.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vladyslav.shuhai.forum.Entity.Comments;



@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {
}
