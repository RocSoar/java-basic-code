package com.roc.landlords.event;

import java.util.ArrayList;
import java.util.List;

public class EventSource2<T, K> {
    private final List<EventListener<T, K>> listeners = new ArrayList<>();

    public void addListener(EventListener<T, K> listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener<T, K> listener) {
        listeners.remove(listener);
    }

    public void triggerEvent(T arg, K arg2) {
        listeners.forEach(listener -> listener.onEvent(arg, arg2));
    }

    @FunctionalInterface
    public interface EventListener<T, K> {
        void onEvent(T arg, K arg2);
    }
}

