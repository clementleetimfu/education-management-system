package io.clementleetimfu.educationmanagementsystem.service;

import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentAddDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentFindByIdDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentListDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentUpdateDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentListDTO> findAll();

    Boolean deleteById(Integer id);

    Boolean add(DepartmentAddDTO departmentAddDTO);

    DepartmentFindByIdDTO findById(Integer id);

    Boolean update(DepartmentUpdateDTO departmentUpdateDTO);
}
