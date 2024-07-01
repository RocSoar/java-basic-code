package com.roc.landlords;

import com.roc.landlords.UI.GameJFrame;
import com.roc.landlords.data.*;
import com.roc.landlords.data.enums.Joker;
import com.roc.landlords.data.enums.Rank;
import com.roc.landlords.data.enums.Suit;

import java.util.List;

public class App {
    public static void main(String[] args) {
////        PokerDeck deck = new PokerDeck();
//        List<PokerHand> hands = deck.dealHands();
//        PokerSet remains = deck.dealHoleCards();
//        hands.forEach(p -> System.out.println(p.getCards()));
//        System.out.println(remains.getCards());
//        System.out.println(deck);
        new GameJFrame();
//        PokerCard card = new PokerCard(Suit.Clubs, Rank.Three);
//        PokerCard card2 = new PokerCard(Suit.Clubs, Rank.Three);
//        System.out.println(card == card2);
//        System.out.println(card.frontImagePath);

    }
}
