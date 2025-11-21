package io.clementleetimfu.educationmanagementsystem.controller;

import io.clementleetimfu.educationmanagementsystem.pojo.Result;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentAddDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentFindByIdDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentListDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.department.DepartmentUpdateDTO;
import io.clementleetimfu.educationmanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public Result<List<DepartmentListDTO>> findAll() {
        return Result.success(departmentService.findAll());
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteById(@PathVariable("id") Integer id) {
        return Result.success(departmentService.deleteById(id));
    }

    @PostMapping
    public Result<Boolean> add(@RequestBody DepartmentAddDTO departmentAddDTO) {
        return Result.success(departmentService.add(departmentAddDTO));
    }

    @GetMapping("/{id}")
    public Result<DepartmentFindByIdDTO> findById(@PathVariable("id") Integer id) {
        return Result.success(departmentService.findById(id));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody DepartmentUpdateDTO departmentUpdateDTO) {
        return Result.success(departmentService.update(departmentUpdateDTO));
    }

}
