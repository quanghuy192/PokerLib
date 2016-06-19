package vn.hn.quanghuy.utils;

import java.util.Random;

public final class PercentUtil {

    private static final int MAX_PERCENT = 100;
    private static final Random r = new Random();

    private PercentUtil() {

    }

    public static final boolean exportRandomFromPercent(final int percent) {

        
        int result = r.nextInt(MAX_PERCENT);

        if (result <= percent) {
            return true;
        }

        return false;
    }

    public static final boolean exportRandomFromPercent(final int percentMin,
            final int percentMax) {

        int result = r.nextInt(MAX_PERCENT);

        if (result <= percentMax && result > percentMin) {
            return true;
        }

        return false;
    }
    
    public static final int exportRandomValue() {

        int result = r.nextInt(MAX_PERCENT);

        return result;
    }

}
