package com.roc.landlords;

import com.roc.landlords.enums.Hand;
import com.roc.landlords.enums.Rank;
import com.roc.landlords.enums.Suit;

public class PokerGame {
    public static void main(String[] args) {
        PokerCard card = new PokerCard(Suit.Club, Rank.Ace);
        PokerCard card2 = new PokerCard(Suit.Club, Rank.Ace);
        Hand hand = new Hand();
        hand.addCard(card);
        System.out.println(hand);
    }
}
