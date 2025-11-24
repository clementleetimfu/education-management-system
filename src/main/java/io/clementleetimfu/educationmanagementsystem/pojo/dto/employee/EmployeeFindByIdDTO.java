package io.clementleetimfu.educationmanagementsystem.pojo.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeFindByIdDTO {
    private Integer id;
    private String username;
    private String name;
    private Integer gender;
    private Integer jobTitle;
    private Integer salary;
    private String image;
    private LocalDate hireDate;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private List<WorkExperienceFindByEmpIdDTO> workExperienceFindByEmpIdDTOList;
}
