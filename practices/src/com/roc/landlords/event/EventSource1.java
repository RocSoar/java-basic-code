package com.roc.landlords.event;

import java.util.ArrayList;
import java.util.List;

public class EventSource1<T> {
    private final List<EventListener<T>> listeners = new ArrayList<>();

    public void addListener(EventListener<T> listener) {
        listeners.add(listener);
    }

    public void clearListener() {
        listeners.clear();
    }

    public void triggerEvent(T arg) {
        listeners.forEach(listener -> listener.onEvent(arg));
    }

    @FunctionalInterface
    public interface EventListener<T> {
        void onEvent(T arg);
    }
}
