package vladyslav.shuhai.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vladyslav.shuhai.forum.Entity.Tags;

@Repository
public interface TagsRepository extends JpaRepository<Tags,Long> {
}
