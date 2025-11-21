package io.clementleetimfu.educationmanagementsystem.service.impl;

import io.clementleetimfu.educationmanagementsystem.exception.BusinessException;
import io.clementleetimfu.educationmanagementsystem.exception.ErrorCodeEnum;
import io.clementleetimfu.educationmanagementsystem.mapper.DepartmentMapper;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentAddDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentFindByIdDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentListDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentUpdateDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.entity.Department;
import io.clementleetimfu.educationmanagementsystem.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentListDTO> findAll() {
        List<DepartmentListDTO> departmentListDTOList = departmentMapper.findAll();
        if (departmentListDTOList.isEmpty()){
            throw new BusinessException(ErrorCodeEnum.DEPARTMENT_NOT_FOUND);
        }
        return departmentListDTOList;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return departmentMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean add(DepartmentAddDTO departmentAddDTO) {
        Department department = modelMapper.map(departmentAddDTO, Department.class);
        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());
        department.setIsDeleted(Boolean.FALSE);
        return departmentMapper.add(department) > 0;
    }

    @Override
    public DepartmentFindByIdDTO findById(Integer id) {
        DepartmentFindByIdDTO departmentFindByIdDTO = departmentMapper.findById(id);
        if (departmentFindByIdDTO == null) {
            throw new BusinessException(ErrorCodeEnum.DEPARTMENT_NOT_FOUND);
        }
        return departmentFindByIdDTO;
    }

    @Override
    public Boolean update(DepartmentUpdateDTO departmentUpdateDTO) {
        Department department = modelMapper.map(departmentUpdateDTO, Department.class);
        department.setUpdateTime(LocalDateTime.now());
        return departmentMapper.update(department) > 0;
    }

}
