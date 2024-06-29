package com.roc.landlords.enums;

import com.roc.landlords.PokerCard;
import com.roc.landlords.CardOperable;

import java.util.ArrayList;
import java.util.List;

public class Hand implements CardOperable {
    private final List<PokerCard> cards = new ArrayList<>();

    public Hand() {
    }

    public List<PokerCard> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    @Override
    public void addCard(PokerCard card) {
        cards.add(card);
    }

    @Override
    public boolean removeCard(PokerCard card) {
        return cards.remove(card);
    }

    @Override
    public void moveCard(CardOperable co, PokerCard card) {

    }

    @Override
    public PokerCard popCard() {
        return null;
    }

    @Override
    public void shuffle() {

    }
}
