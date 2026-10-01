package in.codehidder.blognest.blognest.service;

import in.codehidder.blognest.blognest.dto.PostRequestDto;
import in.codehidder.blognest.blognest.dto.PostResponseDto;

import java.util.List;

public interface PostService {
    PostResponseDto createPost(PostRequestDto requestDto, Long userId, Long categoryId);

    PostResponseDto getPostById(Long id);

    List<PostResponseDto> getAllPosts();

    PostResponseDto updatePostById(Long id, PostRequestDto requestDto);

    void deletePostById(Long id);

    List<PostResponseDto> getAllByUser(Long userId);

    List<PostResponseDto> getAllByCategory(Long categoryId);

    List<PostResponseDto> searchPost(String keyword);
}
