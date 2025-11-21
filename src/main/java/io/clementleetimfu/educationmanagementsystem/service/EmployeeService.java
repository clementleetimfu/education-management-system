package io.clementleetimfu.educationmanagementsystem.service;

import io.clementleetimfu.educationmanagementsystem.pojo.PageResult;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeAddDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeQueryRequestDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeQueryResponseDTO;

public interface EmployeeService {
    PageResult<EmployeeQueryResponseDTO> query(EmployeeQueryRequestDTO employeeQueryRequestDTO);

    Boolean add(EmployeeAddDTO employeeAddDTO);
}