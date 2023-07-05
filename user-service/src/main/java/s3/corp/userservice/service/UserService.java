package s3.corp.userservice.service;

import s3.corp.userservice.repository.UserRepository;
import s3.corp.userservice.response.UserResponse;

public interface UserService {
    UserResponse getUserById(Long id);
}
