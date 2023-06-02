package com.example.companymanagement.controllers;

import com.example.companymanagement.dtos.ApiResponse;
import com.example.companymanagement.dtos.DepartmentDto;
import com.example.companymanagement.services.IDepartmentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final IDepartmentService departmentService;

    @Autowired
    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResponse addDepartment(@RequestBody DepartmentDto dto) {
        return this.departmentService.add(dto);
    }

    @GetMapping("/getAll")
    public ApiResponse getDepartments() {
        return this.departmentService.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteDepartment(@PathParam("id") Long id){
        return this.departmentService.delete(id);
    }
    @PutMapping("/edit/{id}")
    public ApiResponse editName(@PathParam("id") Long id,@RequestBody DepartmentDto dto){
        return this.departmentService.editName(id,dto);
    }
    @PostMapping("/find")
    public ApiResponse getByName(@RequestBody DepartmentDto dto){
        return this.departmentService.searchByName(dto);
    }
}
