package s3.corp.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import s3.corp.userservice.entity.User;
import s3.corp.userservice.exception.ResourceNotFoundException;
import s3.corp.userservice.repository.UserRepository;
import s3.corp.userservice.response.AddressDto;
import s3.corp.userservice.response.DepartmentDto;
import s3.corp.userservice.response.UserResponse;
import s3.corp.userservice.service.UserService;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Value("${user.details.url}")
    private String userDetailsUrl;

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        DepartmentDto departmentDto = restTemplate.getForObject(userDetailsUrl + "/departments/{id}", DepartmentDto.class, user.getDepartmentId());

        AddressDto addressDto = restTemplate.getForObject(userDetailsUrl + "/address/{id}", AddressDto.class, user.getAddressId());


        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        userResponse.setDepartment(departmentDto);
        userResponse.setAddress(addressDto);
        return userResponse;
    }
}
