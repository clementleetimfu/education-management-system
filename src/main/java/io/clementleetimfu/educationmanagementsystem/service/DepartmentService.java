package io.clementleetimfu.educationmanagementsystem.service;

import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentAddDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentFindAllDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentUpdateDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentFindAllDTO> findAllDepartment();

    Boolean deleteDepartmentById(Integer id);

    Boolean addDepartment(DepartmentAddDTO departmentAddDTO);

    Boolean updateDepartmentName(DepartmentUpdateDTO departmentUpdateDTO);
}
