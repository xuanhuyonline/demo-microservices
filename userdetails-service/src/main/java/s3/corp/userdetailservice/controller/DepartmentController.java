package s3.corp.userdetailservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import s3.corp.userdetailservice.dto.DepartmentDto;
import s3.corp.userdetailservice.service.DepartmentService;

@RestController
@RequestMapping("departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

}
