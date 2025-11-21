package io.clementleetimfu.educationmanagementsystem.exception;

public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
    }
}
