package com.ruthvik.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruthvik.CRUD.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}