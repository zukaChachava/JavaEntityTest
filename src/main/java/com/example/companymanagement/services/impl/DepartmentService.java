package com.example.companymanagement.services.impl;

import com.example.companymanagement.apiUtil.IncorrectParameterException;
import com.example.companymanagement.dtos.ApiResponse;
import com.example.companymanagement.dtos.DepartmentDto;
import com.example.companymanagement.entities.Department;
import com.example.companymanagement.repositories.DepartmentRepository;
import com.example.companymanagement.services.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {


    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ApiResponse add(DepartmentDto departmentDto) {

        if (departmentDto == null || departmentDto.getName() == null) {
            throw new IncorrectParameterException("departmentDto");
        }

        return new ApiResponse("department", this.departmentRepository.save(new Department(departmentDto)));

    }

    @Override
    public ApiResponse delete(Long id) {
//        if (id == null || id <= 0) {
//            return new ApiResponse().addError("id", "incorrect value");
//        }
        return new ApiResponse("department", null);
    }

    @Override
    public ApiResponse editName(Long id, DepartmentDto departmentDto) {
        if (id == null || id <= 0) {
            return new ApiResponse().addError("id", "incorrect value");
        }
        if (departmentDto != null && departmentDto.getName() != null) {
            //return new ApiResponse("department", this.departmentUtils.editDepartmentName(id, departmentDto.getName()));
        }
        return new ApiResponse().addError("INCORRECT_PARAM", "INCORRECT_NAME");
    }

    @Override
    public ApiResponse editHead(Long id, String departmentHead) {
        return null;
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("departments", this.departmentRepository.findAll());
    }

    @Override
    public ApiResponse getById(Long id) {

        if (id == null || id <= 0) {
            return new ApiResponse().addError("id", "incorrect value");
        }

       // Department department = departmentUtils.findById(id);

//        if (department == null) {
//            return new ApiResponse().addError("department", "not found");
//        }

        return new ApiResponse("department", null);
    }

    @Override
    public ApiResponse searchByName(DepartmentDto departmentDto) {

        if (departmentDto == null || departmentDto.getName() == null) {
            return new ApiResponse().addError("name", "not found");
        }
//        Department department = departmentUtils.findByName(departmentDto.getName());
//        if (department == null) {
//            return new ApiResponse().addError("department", "not found");
//        }
        return new ApiResponse("department", null);
    }

}
