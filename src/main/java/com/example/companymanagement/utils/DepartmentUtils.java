package com.example.companymanagement.utils;

import com.example.companymanagement.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentUtils {

    private static DepartmentUtils departmentUtils;

    private List<Department> departments;

    private DepartmentUtils() {
        departments = new ArrayList<>();
    }

    public static DepartmentUtils getInstance() {
        if (departmentUtils == null) {
            departmentUtils = new DepartmentUtils();
        }
        return departmentUtils;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Boolean addDepartment(Department department) {
        return this.departments.add(department);
    }

    public Department findById(Long id) {
        return this.departments.stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElse(null);
    }
    public Department findByName(String name){
        return this.departments.stream()
                .filter(c -> c.getName().contains(name))
                .findAny()
                .orElse(null);
    }

    public Long generateId() {
        int size = this.departments.size();
        if (size == 0) {
            return 1L;
        }
        return this.departments.get(size - 1).getId() + 1;
    }
    public Department deleteDepartment(Long id){
        Department department =  this.departments.stream().filter(i ->i.getId().equals(id)).findAny().orElse(null);
    if (department != null){
        this.departments.remove(department);
    }
    return department;
    }
    public Department editDepartmentName(Long id, String newName){
        Department department =  this.departments.stream().filter(i ->i.getId().equals(id)).findAny().orElse(null);
        if (department != null){
            department.setName(newName);
        }
        return department;
    }

}
