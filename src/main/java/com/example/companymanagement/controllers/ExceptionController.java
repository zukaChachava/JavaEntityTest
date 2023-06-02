package com.example.companymanagement.controllers;

import com.example.companymanagement.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResponse uncaughtExceptionHandler(Exception e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.addError("Unknown", e.getMessage());

        return apiResponse;
    }

}
