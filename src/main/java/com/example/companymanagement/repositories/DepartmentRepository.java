package com.example.companymanagement.repositories;

import com.example.companymanagement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByNameAndHead(String name, String head);

    List<Department> findByHead(String head);

    Optional<Department> findById(Long id);

}