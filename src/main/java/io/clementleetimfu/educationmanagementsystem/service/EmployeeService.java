package io.clementleetimfu.educationmanagementsystem.service;

import io.clementleetimfu.educationmanagementsystem.pojo.PageResult;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeAddDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeFindByIdDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeSearchRequestDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeSearchResponseDTO;

import java.util.List;

public interface EmployeeService {
    PageResult<EmployeeSearchResponseDTO> searchEmployee(EmployeeSearchRequestDTO employeeSearchRequestDTO);

    Boolean addEmployee(EmployeeAddDTO employeeAddDTO);

    Boolean deleteEmployeeByIds(List<Integer> ids);

    EmployeeFindByIdDTO findEmployeeById(Integer id);
}