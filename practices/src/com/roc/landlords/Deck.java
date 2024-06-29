package com.roc.landlords;

import com.roc.landlords.enums.Rank;
import com.roc.landlords.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements CardOperable {
    private final List<PokerCard> cards = new ArrayList<>();

    public Deck() {
        setUp();
    }

    public List<PokerCard> getCards() {
        return cards;
    }

    private void setUp() {
        cards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new PokerCard(suit, rank));
            }
        }
    }

    public void reSet() {
        setUp();
    }

    @Override
    public void addCard(PokerCard card) {

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
        return cards.remove(cards.size() - 1);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }
}
