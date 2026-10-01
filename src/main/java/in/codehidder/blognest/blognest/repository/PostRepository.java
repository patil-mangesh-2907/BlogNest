package in.codehidder.blognest.blognest.repository;

import in.codehidder.blognest.blognest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUser_Id(Long userId);

    List<Post> findAllByCategory_Id(Long categoryId);

    boolean existsById(Long id);
}