package s3.corp.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import s3.corp.userservice.entity.User;
import s3.corp.userservice.exception.ResourceNotFoundException;
import s3.corp.userservice.repository.UserRepository;
import s3.corp.userservice.response.UserResponse;
import s3.corp.userservice.service.UserService;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return userResponse;
    }
}
