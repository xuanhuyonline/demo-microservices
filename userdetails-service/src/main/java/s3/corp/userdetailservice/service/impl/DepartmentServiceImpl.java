package s3.corp.userdetailservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import s3.corp.userdetailservice.dto.DepartmentDto;
import s3.corp.userdetailservice.entity.Department;
import s3.corp.userdetailservice.exception.ResourceNotFoundException;
import s3.corp.userdetailservice.repository.DepartmentRepository;
import s3.corp.userdetailservice.service.DepartmentService;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" +  id));
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }
}
