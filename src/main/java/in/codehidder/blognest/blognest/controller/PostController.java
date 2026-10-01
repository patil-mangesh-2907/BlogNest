package in.codehidder.blognest.blognest.controller;

import in.codehidder.blognest.blognest.dto.PostRequestDto;
import in.codehidder.blognest.blognest.dto.PostResponseDto;
import in.codehidder.blognest.blognest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto requestDto,
                                                      @RequestParam Long userId, @RequestParam Long categoryId) {
        PostResponseDto responseDto = postService.createPost(requestDto,userId,categoryId);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id) {
        PostResponseDto responseDto = postService.getPostById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        List<PostResponseDto> responseDtos = postService.getAllPosts();
        return ResponseEntity.ok(responseDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePostById(@PathVariable Long id,
                                                          @RequestBody PostRequestDto requestDto) {
        PostResponseDto responseDto = postService.updatePostById(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<PostResponseDto>> getAllByUser(@PathVariable Long userId) {
        List<PostResponseDto> responseDtos = postService.getAllByUser(userId);
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<List<PostResponseDto>> getAllByCategory(@PathVariable Long categoryId) {
        List<PostResponseDto> responseDtos = postService.getAllByCategory(categoryId);
        return ResponseEntity.ok(responseDtos);
    }
}
