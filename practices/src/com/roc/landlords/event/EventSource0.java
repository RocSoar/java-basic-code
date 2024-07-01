package com.roc.landlords.event;

import java.util.ArrayList;
import java.util.List;

public class EventSource0 {
    private final List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void clearListener() {
        listeners.clear();
    }

    public void triggerEvent() {
        listeners.forEach(EventListener::onEvent);
    }

    @FunctionalInterface
    public interface EventListener {
        void onEvent();
    }
}