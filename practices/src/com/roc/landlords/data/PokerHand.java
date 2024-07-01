package com.roc.landlords.data;

import java.awt.*;

public class PokerHand extends Poker {
    public PokerSet set;

    public PokerHand(Container c) {
        super(c);
        set = new PokerSet(container);
    }
}
