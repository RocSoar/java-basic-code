package com.roc.landlords;

public interface CardOperable {
    void addCard(PokerCard card);

    boolean removeCard(PokerCard card);

    void moveCard(CardOperable co, PokerCard card);

    PokerCard popCard();

    void shuffle();
}