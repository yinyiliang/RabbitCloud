package yyl.rabbitcloud.util;

/**
 * Created by yyl on 2017/7/2.
 */

public class SmallToolsHelper {


    /**
     * 身高单位转换
     * @param banboos
     * @return
     */
    public static String unitConversion(String banboos) {
        double value = Double.parseDouble(banboos);
        if (banboos.length() <= 4) {
            return value + "μm";
        } else if (banboos.length() > 4 & banboos.length() < 7) {
            return String.format("%.2f", value / 1000) + "mm";
        } else if (banboos.length() >= 7) {
            return String.format("%.2f", value / 1000000) + "m";
        }
        return "0";
    }

}
