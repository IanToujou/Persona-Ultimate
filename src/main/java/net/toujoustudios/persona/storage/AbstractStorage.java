package net.toujoustudios.persona.storage;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Base class for handling object storage and persistence.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
public abstract class AbstractStorage<K, V> {

    @Getter
    protected final Map<K, V> instances = new HashMap<>();

    /**
     * Retrieves an object from memory or loads it if not present.
     *
     * @param key The key to look up.
     * @param creator A function to create a new instance of V if not found.
     * @return The object associated with the key.
     */
    public V get(K key, Function<K, V> creator) {
        return instances.computeIfAbsent(key, k -> {
            V value = creator.apply(k);
            load(k, value);
            return value;
        });
    }

    /**
     * Loads data into the object from storage.
     *
     * @param key The key.
     * @param value The object to load data into.
     */
    public abstract void load(K key, V value);

    /**
     * Saves an object to storage.
     *
     * @param key The key of the object to save.
     */
    public abstract void save(K key);

    /**
     * Saves all currently loaded objects.
     */
    public void saveAll() {
        instances.keySet().forEach(this::save);
    }

    /**
     * Removes an object from memory.
     *
     * @param key The key of the object to unload.
     */
    public void unload(K key) {
        save(key);
        instances.remove(key);
    }

}
