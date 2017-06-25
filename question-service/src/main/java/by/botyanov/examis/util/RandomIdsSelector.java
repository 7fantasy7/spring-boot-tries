package by.botyanov.examis.util;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RandomIdsSelector {

    private final static SecureRandom RANDOM = new SecureRandom();

    public static Collection<Long> randomIds(long upperRage, int count) {
        return randomIds(1, upperRage, count);
    }

    public static Collection<Long> randomIds(long lowerRange, long upperRage, int count) {
        Set<Long> ids = new HashSet<>(count);
        while (ids.size() < count) {
            ids.add(nextLong(lowerRange, upperRage));
        }
        return ids;
    }

    private static long nextLong(long lowerRange, long upperRange) {
        return (long) (RANDOM.nextDouble() * (upperRange - lowerRange)) + lowerRange;
    }

    private RandomIdsSelector() {
        throw new UnsupportedOperationException();
    }

}
