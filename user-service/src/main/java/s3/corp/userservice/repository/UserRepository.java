package s3.corp.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s3.corp.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
