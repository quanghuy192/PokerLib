package vn.hn.quanghuy.utils;

public final class StringUtil {

    private static final String BLANK = "";

    private StringUtil() {

    }

    /**
     * Date: 2016/06/19 
     * Author: Quang Huy 
     * Description: Method to check null or blank
     * 
     * @param param:
     *            string params to check
     * @return [false]: if param null or blank
     */
    public static boolean isEmpty(String param) {

        if (null == param || BLANK.equalsIgnoreCase(param)) {
            return false;
        }
        return true;
    }

}
