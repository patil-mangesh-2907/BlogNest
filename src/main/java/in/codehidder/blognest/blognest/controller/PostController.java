package in.codehidder.blognest.blognest.controller;

import in.codehidder.blognest.blognest.dto.PostRequestDto;
import in.codehidder.blognest.blognest.dto.PostResponseDto;
import in.codehidder.blognest.blognest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
