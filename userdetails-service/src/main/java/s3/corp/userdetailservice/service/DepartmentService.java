package s3.corp.userdetailservice.service;

import s3.corp.userdetailservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto getDepartmentById(Long id);

}
