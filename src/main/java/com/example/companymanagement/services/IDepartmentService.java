package com.example.companymanagement.services;

import com.example.companymanagement.dtos.ApiResponse;
import com.example.companymanagement.dtos.DepartmentDto;

public interface IDepartmentService {

    ApiResponse add(DepartmentDto departmentDto);

    ApiResponse delete(Long id);

    ApiResponse editName(Long id, DepartmentDto departmentDto);

    ApiResponse editHead(Long id, String departmentHead);

    ApiResponse getAll();

    ApiResponse getById(Long id);

    ApiResponse searchByName(DepartmentDto departmentDto);

}