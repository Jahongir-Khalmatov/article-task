package lesson7.articletask.service;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.entity.Comment;
import lesson7.articletask.entity.Lavozim;
import lesson7.articletask.entity.Post;
import lesson7.articletask.entity.enums.Huquq;
import lesson7.articletask.payload.CommentDto;
import lesson7.articletask.payload.LavozimDto;
import lesson7.articletask.repository.CommentRepository;
import lesson7.articletask.repository.LavozimRepository;
import lesson7.articletask.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    @GetMapping
public List<Comment> getCommentList(){
    return commentRepository.findAll();
}
public ApiResponse addComment(CommentDto commentDto){
    Optional<Post> optionalPost = postRepository.findById(Long.valueOf(commentDto.getPostId()));
    if (!optionalPost.isPresent())
        return new ApiResponse(false,"bunday post mavjud emas");
    Post post = optionalPost.get();
    Comment comment= new Comment();
        comment.setText(commentDto.getText());
        comment.setPost(post);
        commentRepository.save(comment);
        return new ApiResponse(true,"post qo'shildi");
}
public ApiResponse editComment(Long id,CommentDto commentDto){
    Optional<Comment> optionalComment = commentRepository.findById(id);
    if (!optionalComment.isPresent())
        return new ApiResponse(false,"bunday comment mavjud emas");
    Comment comment = optionalComment.get();
    comment.setText(commentDto.getText());
    Optional<Post> optionalPost = postRepository.findById(Long.valueOf(commentDto.getPostId()));
if (!optionalPost.isPresent())
    return new ApiResponse(false,"bunday post mavjud emas");
    Post post = optionalPost.get();
    comment.setPost(post);
    commentRepository.save(comment);
    return new ApiResponse(true,"Comment o'zgartirildi");
}
public ApiResponse deleteComment(Long id){
    Optional<Comment> optionalComment = commentRepository.findById(id);
    if (!optionalComment.isPresent())
        return new ApiResponse(false,"bunday comment mavjud emas");
    Comment comment = optionalComment.get();
    commentRepository.delete(comment);
    return new ApiResponse(true,"comment o'chirildi");
}


}
