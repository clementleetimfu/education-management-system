package io.clementleetimfu.educationmanagementsystem.mapper;

import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentFindByIdDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentListDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    List<DepartmentListDTO> findAll();

    Integer deleteById(@Param("id") Integer id);

    Integer add(Department department);

    DepartmentFindByIdDTO findById(@Param("id") Integer id);

    Integer update(Department department);
}
