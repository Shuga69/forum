package vladyslav.shuhai.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vladyslav.shuhai.forum.Entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
}
