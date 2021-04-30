package lesson7.articletask.controller;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.entity.Post;
import lesson7.articletask.payload.PostDto;
import lesson7.articletask.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;
    @PreAuthorize(value = "hasAnyAuthority('VIEW_POST')")
    @GetMapping
    public List<Post> getPostList(){
    return postService.getPostList();
}
@PreAuthorize(value = "hasAnyAuthority('ADD_POST')")
@PostMapping("/add")
    public HttpEntity<?> addPost(@Valid @RequestBody PostDto postDto) {
    ApiResponse apiResponse = postService.addPost(postDto);
    return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 400).body(apiResponse);
}
    @PreAuthorize(value = "hasAnyAuthority('EDIT_POST')")
            @PutMapping("/{id}")
    public HttpEntity<?> editPost(@Valid @PathVariable Long id, @RequestBody PostDto postDto){
        ApiResponse apiResponse = postService.editPost(id, postDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:400).body(apiResponse);
    }
    @PreAuthorize(value = "hasAnyAuthority('DELETE_POST')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePost(@PathVariable Long id){
        ApiResponse apiResponse = postService.deletePost(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:400).body(apiResponse);
    }


}
