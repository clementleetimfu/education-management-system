package io.clementleetimfu.educationmanagementsystem.controller;

import io.clementleetimfu.educationmanagementsystem.annotation.AddActivityLog;
import io.clementleetimfu.educationmanagementsystem.pojo.PageResult;
import io.clementleetimfu.educationmanagementsystem.pojo.Result;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeAddDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeFindByIdDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeSearchRequestDTO;
import io.clementleetimfu.educationmanagementsystem.pojo.dto.employee.EmployeeSearchResponseDTO;
import io.clementleetimfu.educationmanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/search")
    public Result<PageResult<EmployeeSearchResponseDTO>> searchEmployee(@ModelAttribute("employeeSearchRequestDTO")
                                                                        EmployeeSearchRequestDTO employeeSearchRequestDTO) {
        return Result.success(employeeService.searchEmployee(employeeSearchRequestDTO));
    }

    @AddActivityLog
    @DeleteMapping
    public Result<Boolean> deleteEmployeeByIds(@RequestParam("ids") List<Integer> ids) {
        return Result.success(employeeService.deleteEmployeeByIds(ids));
    }

    @AddActivityLog
    @PostMapping
    public Result<Boolean> addEmployee(@RequestBody EmployeeAddDTO employeeAddDTO) {
        return Result.success(employeeService.addEmployee(employeeAddDTO));
    }







    @GetMapping("/{id}")
    public Result<EmployeeFindByIdDTO> findEmployeeById(@PathVariable("id") Integer id) {
        return Result.success(employeeService.findEmployeeById(id));
    }

//    // delete - ok
//    // findbyid
//    // update
//    // find all

}