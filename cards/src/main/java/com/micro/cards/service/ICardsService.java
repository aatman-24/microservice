package com.micro.cards.service;

import com.micro.cards.dto.CardsDto;

public interface ICardsService {
    public void createCard(String mobileNumber);

    public CardsDto fetchCardsDetails(String mobileNumber);

    public boolean updateCard(CardsDto cardsDto);

    boolean deleteCard(String mobileNumber);
}
