package com.micro.cards.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resouceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with the given input data %s : %s", resouceName, fieldName, fieldValue));
    }
}
