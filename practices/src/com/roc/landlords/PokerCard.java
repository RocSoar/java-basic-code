package com.roc.landlords;

import com.roc.landlords.enums.Rank;
import com.roc.landlords.enums.Suit;

public record PokerCard(Suit suit, Rank rank) implements Comparable<PokerCard> {
    @Override
    public int compareTo(PokerCard o) {
        return rank.ordinal() - o.rank.ordinal();
    }
}
