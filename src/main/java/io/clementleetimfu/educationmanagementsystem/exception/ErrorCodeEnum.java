package io.clementleetimfu.educationmanagementsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    DEPARTMENT_NOT_FOUND(2001, "Department not found");

    private final int code;
    private final String message;

}
