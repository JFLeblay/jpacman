package nl.tudelft.jpacman.utils;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static java.security.SecureRandom.getInstanceStrong;

public class Math {

    private static Random random;
    static {
        try {
            Math.random = getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Singleton, always return the same instance
     * @return java.util.Random
     */
    public static Random getRandom() {
        return Math.random;
    }
}
