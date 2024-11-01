package com.micro.cards.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class CardsDto {

    @NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotEmpty(message = "Card number cannot be empty")
    @Pattern(regexp = "^[0-9]{12}$", message = "Card number must be 12 digits")
    private String cardNumber;

    @NotEmpty(message = "Card type cannot be empty")
    private String cardType;

    @Positive(message = "Total limit cannot be negative")
    private Long totalLimit;

    @PositiveOrZero(message = "Amount used cannot be negative")
    private Long amountUsed;

    @PositiveOrZero(message = "AvailableAmount used cannot be negative")
    private Long availableAmount;
}
