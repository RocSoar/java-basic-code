package com.roc.landlords.event;

import com.roc.landlords.data.PokerCard;

import java.util.List;

public class EventManager {
    static EventSource0 start = new EventSource0();
    public static EventSource1<List<PokerCard>> afterDeckCreated = new EventSource1<>();
    static EventSource2<String, Integer> deadEvent = new EventSource2<>();
}


