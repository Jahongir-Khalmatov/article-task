package lesson7.articletask.repository;

import lesson7.articletask.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    boolean existsByUrl(String url);
    boolean existsByTextAndTitle(String text, String title);
    String findByUrl(String url);
}
