package lesson7.articletask.controller;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.entity.Comment;
import lesson7.articletask.entity.Post;
import lesson7.articletask.payload.CommentDto;
import lesson7.articletask.payload.PostDto;
import lesson7.articletask.service.CommentService;
import lesson7.articletask.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PreAuthorize(value = "hasAnyAuthority('VIEW_COMMENT')")
    @GetMapping
    public List<Comment> getPostList(){
    return commentService.getCommentList();
}
@PreAuthorize(value = "hasAnyAuthority('ADD_COMMENT')")
@PostMapping("/add")
    public HttpEntity<?> addPost(@Valid @RequestBody CommentDto commentDto) {
    ApiResponse apiResponse = commentService.addComment(commentDto);
    return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 400).body(apiResponse);
}
    @PreAuthorize(value = "hasAnyAuthority('EDIT_COMMENT')")
            @PutMapping("/{id}")
    public HttpEntity<?> editPost(@Valid @PathVariable Long id, @RequestBody CommentDto commentDto){
        ApiResponse apiResponse = commentService.editComment(id, commentDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:400).body(apiResponse);
    }
    @PreAuthorize(value = "hasAnyAuthority('DELETE_POST')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePost(@PathVariable Long id){
        ApiResponse apiResponse = commentService.deleteComment(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:400).body(apiResponse);
    }


}
