package com.roc.landlords.data;

import com.roc.landlords.Common;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public abstract class Poker {
    protected List<PokerCard> cards = new ArrayList<>();
    protected Container container;

    public Poker(Container c) {
        container = c;
    }

    public List<PokerCard> getCards() {
        return cards;
    }

    private void addCard(PokerCard card) {
        cards.add(card);
    }

    public boolean removeCard(PokerCard card) {
        return cards.remove(card);
    }

    public void moveCard(Poker poker, int num, Point to) {
        IntStream.range(0, num).forEach(i -> {
            PokerCard card = this.popCard();
            Common.move(card, card.getLocation(), to);
            poker.addCard(card);
            container.setComponentZOrder(card, 0);
        });
    }

    public void moveCard(Poker poker, int num, Point to, boolean isFront) {
        IntStream.range(0, num).forEach(i -> {
            PokerCard card = this.popCard();
            Common.move(card, card.getLocation(), to);
            poker.addCard(card);
            container.setComponentZOrder(card, 0);
            if (isFront)
                card.turnFront();
        });
    }

    public PokerCard popCard() {
        return cards.remove(cards.size() - 1);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void sort() {
        Collections.sort(cards);
    }

    public String toString() {
        return cards.toString();
    }
}
