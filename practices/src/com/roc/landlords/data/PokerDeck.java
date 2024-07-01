package com.roc.landlords.data;

import com.roc.landlords.data.enums.Joker;
import com.roc.landlords.data.enums.Rank;
import com.roc.landlords.data.enums.Suit;
import com.roc.landlords.event.EventManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PokerDeck extends Poker {
    public PokerDeck(Container c) {
        super(c);
        init();
    }

    private void init() {
        cards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new PokerCard(suit, rank));
            }
        }
        cards.add(new PokerCard(Joker.Black));
        cards.add(new PokerCard(Joker.Colored));
        EventManager.afterDeckCreated.triggerEvent(cards);
    }

    public void reset() {
        init();
    }

    public List<PokerHand> dealHands() {
        return dealHands(3, 17);
    }

    public List<PokerHand> dealHands(int handsNum, int cardsPerHand) {
        int count = handsNum * cardsPerHand;
        if (cards.size() < count)
            return null;
        this.shuffle();
        List<PokerHand> hands = new ArrayList<>();
        IntStream.range(0, handsNum).forEach(i -> hands.add(new PokerHand(container)));
        IntStream.range(0, count).forEach(i -> {
            int index = i % handsNum;
            if (index == 0)
                this.moveCard(hands.get(0), 1, new Point(50, 60 + i * 5));
            else if (index == 1)
                this.moveCard(hands.get(1), 1, new Point(180 + i * 7, 450), true);
            else if (index == 2)
                this.moveCard(hands.get(2), 1, new Point(700, 60 + i * 5));
        });
        hands.forEach(Poker::sort);
        return hands;
    }

    public PokerSet dealHoleCards() {
        return dealHoleCards(3);
    }

    public PokerSet dealHoleCards(int num) {
        if (cards.size() < num)
            return null;
        this.shuffle();
        PokerSet set = new PokerSet(container);
        IntStream.range(0, num).forEach(i -> this.moveCard(set, 1, new Point(270 + (75 * i), 10)));
        this.sort();
        return set;
    }
}
