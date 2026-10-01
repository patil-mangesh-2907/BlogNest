package in.codehidder.blognest.blognest.service;

import in.codehidder.blognest.blognest.dto.PostRequestDto;
import in.codehidder.blognest.blognest.dto.PostResponseDto;
import in.codehidder.blognest.blognest.entity.Category;
import in.codehidder.blognest.blognest.entity.Post;
import in.codehidder.blognest.blognest.entity.User;
import in.codehidder.blognest.blognest.exception.ResourceNotFoundException;
import in.codehidder.blognest.blognest.repository.CategoryRepository;
import in.codehidder.blognest.blognest.repository.PostRepository;
import in.codehidder.blognest.blognest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostResponseDto createPost(PostRequestDto requestDto, Long userId, Long categoryId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + userId + " not found"));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + categoryId + " not found"));

        Post post = modelMapper.map(requestDto, Post.class);
        post.setUser(user);
        post.setCategory(category);

        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostResponseDto.class);
    }

    @Override
    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id: " + id + " not found"));

        return modelMapper.map(post, PostResponseDto.class);
    }

    @Override
    public List<PostResponseDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream()
                .map(post -> modelMapper.map(post, PostResponseDto.class))
                .toList();
    }

    @Override
    public PostResponseDto updatePostById(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id: " + id + " not found"));

        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
        post.setImage(requestDto.getImage());

        Post updatedPost = postRepository.save(post);

        return modelMapper.map(updatedPost, PostResponseDto.class);
    }

    @Override
    public void deletePostById(Long id) {
        boolean exists = postRepository.existsById(id);

        if (!exists) {
            throw new ResourceNotFoundException("Post with id: " + id + " not found");
        }

        postRepository.deleteById(id);
    }

    @Override
    public List<PostResponseDto> getAllByUser(Long userId) {
        List<Post> posts = postRepository.findAllByUser(userId);

        return posts.stream()
                .map(post -> modelMapper.map(post, PostResponseDto.class))
                .toList();
    }

    @Override
    public List<PostResponseDto> getAllByCategory(Long categoryId) {
        List<Post> posts = postRepository.findAllByCategory(categoryId);

        return posts.stream()
                .map(post -> modelMapper.map(post, PostResponseDto.class))
                .toList();
    }

    @Override
    public List<PostResponseDto> searchPost(String keyword) {
        return List.of();
    }
}
