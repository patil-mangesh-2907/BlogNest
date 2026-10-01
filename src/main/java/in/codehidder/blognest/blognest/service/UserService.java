package in.codehidder.blognest.blognest.service;

import in.codehidder.blognest.blognest.dto.UserRequestDto;
import in.codehidder.blognest.blognest.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUserById(Long id, UserRequestDto userRequestDto);

    void deleteUserById(Long id);
}
