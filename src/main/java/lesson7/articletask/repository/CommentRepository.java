package lesson7.articletask.repository;

import lesson7.articletask.entity.Comment;
import lesson7.articletask.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
