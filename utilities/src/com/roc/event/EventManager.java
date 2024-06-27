package com.roc.event;

public class EventManager {
    static EventSource0 startEvent = new EventSource0();
    static EventSource1<String> loadEvent = new EventSource1<>();
    static EventSource2<String, Integer> deadEvent = new EventSource2<>();
}


