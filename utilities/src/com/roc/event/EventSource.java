package com.roc.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class EventSource0 {
    private final List<EventListener> listeners = new ArrayList<>();

    void addListener(EventListener listener) {
        listeners.add(listener);
    }

    void clearListener() {
        listeners.clear();
    }

    void triggerEvent() {
        listeners.forEach(EventListener::onEvent);
    }

    @FunctionalInterface
    interface EventListener {
        void onEvent();
    }
}

class EventSource1<T> {
    private final List<EventListenerWrapper<T>> listeners = new ArrayList<>();

    void addListener(EventListener<T> listener) {
        listeners.add(new EventListenerWrapper<>(listener));
    }

    //TODO: remove方法没有实装, 包装器类做不到
    void removeListener(EventListener<T> listener) {
        listeners.remove(new EventListenerWrapper<>(listener));
    }

    void clearListener() {
        listeners.clear();
    }

    void triggerEvent(T arg) {
        listeners.forEach(w -> w.listener.onEvent(arg));
    }

    @FunctionalInterface
    interface EventListener<T> {
        void onEvent(T arg);
    }

    private static class EventListenerWrapper<T> {
        private final EventListener<T> listener;

        public EventListenerWrapper(EventListener<T> listener) {
            this.listener = listener;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EventListenerWrapper<?> that = (EventListenerWrapper<?>) o;
            return listener.equals(that.listener);
        }

        @Override
        public int hashCode() {
            return Objects.hash(listener);
        }
    }
}

class EventSource2<T, K> {
    private final List<EventListener<T, K>> listeners = new ArrayList<>();

    void addListener(EventListener<T, K> listener) {
        listeners.add(listener);
    }

    void removeListener(EventListener<T, K> listener) {
        listeners.remove(listener);
    }

    void triggerEvent(T arg, K arg2) {
        listeners.forEach(listener -> listener.onEvent(arg, arg2));
    }

    @FunctionalInterface
    interface EventListener<T, K> {
        void onEvent(T arg, K arg2);
    }
}

