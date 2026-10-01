package in.codehidder.blognest.blognest.repository;

import in.codehidder.blognest.blognest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsById(Long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phoneNumber);
}
