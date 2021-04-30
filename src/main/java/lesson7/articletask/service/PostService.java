package lesson7.articletask.service;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.entity.Post;
import lesson7.articletask.payload.PostDto;
import lesson7.articletask.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public ApiResponse addPost(PostDto postDto) {
        boolean exists = postRepository.existsByUrl(postDto.getUrl());
        if (exists) return new ApiResponse(false, "bunday yo'lda post mavjud");
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setText(postDto.getText());
        post.setUrl(postDto.getUrl());
        postRepository.save(post);
        return new ApiResponse(true, "post qo'shildi");
    }
    public ApiResponse editPost(Long id,PostDto postDto){

        Optional<Post> optionalPost = postRepository.findById(id);
        if (!optionalPost.isPresent())
            return new ApiResponse(false,"post topilmadi");
        Post post = optionalPost.get();
        boolean exists = postRepository.existsByTextAndTitle(postDto.getText(), postDto.getTitle());
        if (exists)
            return new ApiResponse(false,"Bunday title va text li post mavjud");
        post.setText(postDto.getText());
        post.setTitle(postDto.getTitle());
        post.setUrl(postDto.getUrl());
        postRepository.save(post);
        return new ApiResponse(true,"post saqlandi");
    }
    public ApiResponse deletePost(Long id){
        Optional<Post> optionalPost = postRepository.findById(id);
        if (!optionalPost.isPresent())
            return new ApiResponse(false,"bunday post mavjud emas");
        Post post = optionalPost.get();
        postRepository.delete(post);
        return new ApiResponse(false,"post o'chirildi");
    }
    public List<Post> getPostList(){
        return postRepository.findAll();
    }
}