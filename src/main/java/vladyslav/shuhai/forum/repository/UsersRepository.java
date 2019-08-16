package vladyslav.shuhai.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vladyslav.shuhai.forum.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
}
