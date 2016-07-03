package vn.hn.quanghuy.utils;

import java.util.Random;

public final class PercentUtil {

    private static final int MAX_PERCENT = 100;
    private static final int MIN_PERCENT = 0;
    private static final Random r = new Random();
    
    private static final String ERROR_MSG = "Percent not valid !";

    /**
     * Date: 2016/06/19 
     * Author: Quang Huy 
     * Description: Private contructor, Utilities class
     * 
     */
    private PercentUtil() {

    }

    /**
     * Date: 2016/06/19 
     * Author: Quang Huy 
     * Description: Method to export random result from percent
     * 
     * @param percent:
     *            percent input
     * @return [false]: if result > percent, [true] another
     * @throws IllegalArgumentException : if percent is invalid
     */
    public static final boolean exportRandomFromPercent(final int percent) {
        
        if(!isValidPercert(percent)){
            throw new IllegalArgumentException(ERROR_MSG);
        }

        int result = r.nextInt(MAX_PERCENT);

        if (result <= percent) {
            return true;
        }

        return false;
    }

    /**
     * Date: 2016/06/19 
     * Author: Quang Huy 
     * Description: Method to export random result from percent Max, percent Min
     * 
     * @param percent:
     *            percent input
     * @return [false]: if result > percentMax or result < percentMin, [true] another
     * @throws IllegalArgumentException : if percent is invalid
     */
    public static final boolean exportRandomFromPercent(final int percentMin,
            final int percentMax) {
        
        if(!isValidPercert(percentMax)){
            throw new IllegalArgumentException(ERROR_MSG);
        }
        
        if(!isValidPercert(percentMin)){
            throw new IllegalArgumentException(ERROR_MSG);
        }

        int result = r.nextInt(MAX_PERCENT);

        if (result <= percentMax && result > percentMin) {
            return true;
        }

        return false;
    }

    /**
     * Date: 2016/06/19 
     * Author: Quang Huy 
     * Description: Method to export random result from percent Max, percent Min
     * 
     * @return : export random percent
     */
    public static final int exportRandomValue() {

        int result = r.nextInt(MAX_PERCENT);

        return result;
    }

    /**
     * Date: 2016/06/19 
     * Author: Quang Huy 
     * Description: Method to export random result from percent Max, percent Min
     * 
     * @param percent:
     *            percent input
     * @return [false]: if result > percentMax or result < percentMin, [true] another
     */
    private static boolean isValidPercert(final int percent) {

        if (percent >= MIN_PERCENT && percent <= MAX_PERCENT) {
            return true;
        }
        return false;
    }

}
