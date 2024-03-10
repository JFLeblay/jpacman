package nl.tudelft.jpacman.utils;

import nl.tudelft.jpacman.ui.Action;

import java.util.List;
import java.util.Map;

public class ObjectValidator {
    /**
     * Throws an <code>IllegalArgumentException</code> if object is Null
     *
     * @param obj  Instance to check
     * @param name Name of the argument to check
     */
    public static void isArgNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalStateException(String.format("Object %s cannot be Null", name));
        }
    }

    /**
     * Throws an <code>IllegalStateException</code> if object is Null
     *
     * @param obj  Instance to check
     * @param name Name of the argument to check
     */
    public static void isNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalStateException(String.format("Object %s cannot be Null", name));
        }
    }

    /**
     * Throws an <code>IllegalStateException</code> if list is empty
     *
     * @param list the <code>java.util.List</code> to check
     * @param name the name of the parameter to check
     */
    public static <T> void isNotEmpty(List<T> list, String name) {
        if (list.isEmpty()) {
            throw new IllegalStateException(String.format("List %s cannot be empty", name));
        }
    }

    public static <K, V> void isNotEmpty(Map<K, V> map, String name) {
        if (map.isEmpty()) {
            throw new IllegalStateException(String.format("Map %s cannot be empty", name));
        }
    }
}
