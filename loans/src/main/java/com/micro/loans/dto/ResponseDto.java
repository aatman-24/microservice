package com.micro.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    String statusCode;
    String statusMessage;
}
