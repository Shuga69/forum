package vladyslav.shuhai.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vladyslav.shuhai.forum.Entity.Forums;

@Repository
public interface ForumsRepository extends JpaRepository<Forums,Long> {
}
