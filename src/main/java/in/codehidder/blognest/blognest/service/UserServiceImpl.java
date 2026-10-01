package in.codehidder.blognest.blognest.service;

import in.codehidder.blognest.blognest.dto.UserRequestDto;
import in.codehidder.blognest.blognest.dto.UserResponseDto;
import in.codehidder.blognest.blognest.entity.User;
import in.codehidder.blognest.blognest.exception.DuplicateMobileNumberException;
import in.codehidder.blognest.blognest.exception.ResourceNotFoundException;
import in.codehidder.blognest.blognest.exception.UserAlreadyExistsException;
import in.codehidder.blognest.blognest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        boolean exists = userRepository.existsByEmail(userRequestDto.getEmail());

        if (exists) {
            throw new UserAlreadyExistsException(
                    "User with email: " + userRequestDto.getEmail() + " already exists"
            );
        }

        boolean phoneExists = userRepository.existsByPhone(userRequestDto.getPhone());

        if (phoneExists) {
            throw new DuplicateMobileNumberException("Mobile number is already registered");
        }

        User user = modelMapper.map(userRequestDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .toList();
    }

    @Override
    public UserResponseDto updateUserById(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));

        modelMapper.map(userRequestDto, user);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    @Override
    public void deleteUserById(Long id) {
        boolean exists = userRepository.existsById(id);

        if (!exists) {
            throw new ResourceNotFoundException("User with id: " + id + " not found");
        }

        userRepository.deleteById(id);
    }
}