package io.clementleetimfu.educationmanagementsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.clementleetimfu.educationmanagementsystem.mapper.EmployeeMapper;
import io.clementleetimfu.educationmanagementsystem.pojo.PageResult;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeAddDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeQueryRequestDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeQueryResponseDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.entity.Employee;
import io.clementleetimfu.educationmanagementsystem.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PageResult<EmployeeQueryResponseDTO> query(EmployeeQueryRequestDTO employeeQueryRequestDTO) {
        PageHelper.startPage(employeeQueryRequestDTO.getPage(), employeeQueryRequestDTO.getPageSize());

        List<EmployeeQueryResponseDTO> employeeQueryResponseDTOList = employeeMapper.query(employeeQueryRequestDTO);

        Page<EmployeeQueryResponseDTO> page = (Page<EmployeeQueryResponseDTO>) employeeQueryResponseDTOList;
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Transactional
    @Override
    public Boolean add(EmployeeAddDTO employeeAddDTO) {
        Employee employee = modelMapper.map(employeeAddDTO, Employee.class);
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setIsDeleted(false);
        return employeeMapper.add(employee) > 0;
    }
}
