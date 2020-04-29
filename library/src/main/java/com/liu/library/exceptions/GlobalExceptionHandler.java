package com.liu.library.exceptions;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MyExceptions.class)
    public ErrorMessage showErrorMessage(MyExceptions e){
        return new ErrorMessage(e.getCode(),e.getMessage());
    }
}
