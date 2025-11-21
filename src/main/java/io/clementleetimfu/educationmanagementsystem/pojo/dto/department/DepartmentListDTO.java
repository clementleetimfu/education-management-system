package io.clementleetimfu.educationmanagementsystem.pojo.dto.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentListDTO {

    private Integer id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}