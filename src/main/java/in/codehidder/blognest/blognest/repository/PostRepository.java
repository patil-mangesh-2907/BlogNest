package in.codehidder.blognest.blognest.repository;

import in.codehidder.blognest.blognest.entity.Post;
import in.codehidder.blognest.blognest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUser(Long userId);
    List<Post> findAllByCategory(Long categoryId);

    boolean existsById(Long id);

    Long user(User user);
}
