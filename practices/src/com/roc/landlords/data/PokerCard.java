package com.roc.landlords.data;

import com.roc.landlords.data.enums.Joker;
import com.roc.landlords.data.enums.Rank;
import com.roc.landlords.data.enums.Suit;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public final class PokerCard extends JLabel implements Comparable<PokerCard>, MouseListener {
    private final Suit suit;
    private final Rank rank;
    private final Joker joker;
    private final String name;
    public ImageIcon frontImage;
    public ImageIcon rearImage = new ImageIcon("practices/image/poker/Rear.png");
    public boolean isRear = true;
    public boolean canClick = false;
    public boolean selected = false;

    public PokerCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.joker = null;
        this.name = rank + " of " + suit;
        init();
    }

    public PokerCard(Joker joker) {
        this.suit = null;
        this.rank = null;
        this.joker = joker;
        this.name = joker + " Joker";
        init();
    }

    private void init() {
        frontImage = new ImageIcon("practices/image/poker/" + name + ".png");
        setSize(71, 96);
        setLocation(350, 150);
        setIcon(rearImage);
        setVisible(true);
        addMouseListener(this);
    }

    public void turnFront() {
        isRear = false;
        setIcon(frontImage);
    }

    public void turnBack() {
        isRear = true;
        setIcon(rearImage);
    }

    @Override
    public int compareTo(PokerCard o) {
        if (joker != null && o.joker != null)
            return o.joker.ordinal() - joker.ordinal();
        else if (joker != null)
            return -1;
        else if (o.joker != null)
            return 1;
        else
            return o.rank.ordinal() - rank.ordinal();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokerCard card)) return false;
        return suit == card.suit && rank == card.rank && joker == card.joker;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank, joker);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!canClick)
            return;

        if (selected)
            setLocation(getX(), getY() + 20);
        else
            setLocation(getX(), getY() - 20);

        selected = !selected;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
