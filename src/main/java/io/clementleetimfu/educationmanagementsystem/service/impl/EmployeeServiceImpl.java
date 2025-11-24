package io.clementleetimfu.educationmanagementsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.clementleetimfu.educationmanagementsystem.mapper.EmployeeMapper;
import io.clementleetimfu.educationmanagementsystem.mapper.WorkExperienceMapper;
import io.clementleetimfu.educationmanagementsystem.pojo.PageResult;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.*;
import io.clementleetimfu.educationmanagementsystem.pojo.entity.Employee;
import io.clementleetimfu.educationmanagementsystem.pojo.entity.WorkExperience;
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

    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    @Override
    public PageResult<EmployeeSearchResponseDTO> searchEmployee(EmployeeSearchRequestDTO employeeSearchRequestDTO) {

        PageHelper.startPage(employeeSearchRequestDTO.getPage(), employeeSearchRequestDTO.getPageSize());

        List<EmployeeSearchResponseDTO> employeeSearchResponseDTOList = employeeMapper.searchEmployee(employeeSearchRequestDTO);

        Page<EmployeeSearchResponseDTO> page = (Page<EmployeeSearchResponseDTO>) employeeSearchResponseDTOList;
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addEmployee(EmployeeAddDTO employeeAddDTO) {
        Employee employee = modelMapper.map(employeeAddDTO, Employee.class);
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setIsDeleted(false);
        Integer addEmployeeResult = employeeMapper.addEmployee(employee);

        List<WorkExperienceAddDTO> workExperienceAddDTOList = employeeAddDTO.getWorkExperienceList();
        List<WorkExperience> workExperienceList = workExperienceAddDTOList.stream()
                .map(workExperienceAddDTO -> {
                    WorkExperience workExperience = modelMapper.map(workExperienceAddDTO, WorkExperience.class);
                    workExperience.setEmpId(employee.getId());
                    workExperience.setCreateTime(LocalDateTime.now());
                    workExperience.setUpdateTime(LocalDateTime.now());
                    workExperience.setIsDeleted(Boolean.FALSE);
                    return workExperience;
                }).toList();
        Integer addWorkExperienceResult = workExperienceMapper.addWorkExperienceByBatch(workExperienceList);

        return addEmployeeResult > 0 && addWorkExperienceResult > 0;
    }

    @Override
    public Boolean deleteEmployeeByIds(List<Integer> ids) {
        return employeeMapper.deleteEmployeeByIds(ids) > 0;
    }

    @Override
    public EmployeeFindByIdDTO findEmployeeById(Integer id) {
        return null;
    }


}
