package com.micro.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    String apiPath;
    HttpStatus errorCode;
    String errorMessage;
    LocalDateTime errorTime;
}
