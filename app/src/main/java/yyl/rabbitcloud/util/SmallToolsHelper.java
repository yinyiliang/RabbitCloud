package yyl.rabbitcloud.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

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

    /**
     * 根据子item的高度 动态测量GridView的实际高度
     * @param gridView
     */
    public static void setGridViewHeightByChildren(GridView gridView) {
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        //总高度
        int totalHeight = 0;
        int lineNum = gridView.getNumColumns(); //得到布局文件中设置的一行显示几个
        View item = listAdapter.getView(0,null,gridView);
        item.measure(0,0); //计算子item的高度
        //得到总高度
        totalHeight = item.getMeasuredHeight()*lineNum;

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);
    }

}
