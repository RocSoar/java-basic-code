package com.roc.defaultDict;

import java.util.HashMap;
import java.util.function.Supplier;

public class DefaultDict<K, V> extends HashMap<K, V> {
    private final V defaultValue;
    private final Supplier<V> defaultValueSupplier;

    public DefaultDict(V defaultValue) {
        this.defaultValue = defaultValue;
        this.defaultValueSupplier = null;
    }

    public DefaultDict(Supplier<V> defaultValueSupplier) {
        this.defaultValue = null;
        this.defaultValueSupplier = defaultValueSupplier;
    }

    @Override
    public V get(Object key) {
        return super.getOrDefault(key, createDefaultValue());
    }

    public V getOrDefaultAndPut(K key) {
        if (super.containsKey(key))
            return super.get(key);

        V defaultValue = createDefaultValue();
        super.put(key, defaultValue);
        return defaultValue;
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    private V createDefaultValue() {
        return defaultValueSupplier == null ? defaultValue : defaultValueSupplier.get();
    }
}


