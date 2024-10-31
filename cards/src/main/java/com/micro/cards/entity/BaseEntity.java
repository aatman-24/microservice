package com.micro.cards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Getter @Setter
@ToString
public class BaseEntity {
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
