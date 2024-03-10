package nl.tudelft.jpacman.utils;

import java.util.List;

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
        assert !list.isEmpty();
    }
}
