package yyl.rabbitcloud.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * RecyclerView grid行间距间隔
 * Created by yyl on 2017/6/19.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount; //一行多少个
    private int vSpacing; //间距
    private int hSpacing;
    private boolean includeEdge = true; //是否包括外边距
    private boolean hasHeader;

    public SpaceItemDecoration(int spanCount, int vSpacing, int hSpacing, boolean hasHeader) {
        this.spanCount = spanCount;
        this.vSpacing = vSpacing;
        this.hSpacing = hSpacing;
        this.hasHeader = hasHeader;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int pos = position;

        //如果有header 当position为0时，就不设置间隔
        if (hasHeader) {
            if (position == 0) {
                outRect.set(0,0,0,0);
                return;
            } else {
                //其他不为0时 需要手动给position-1
                pos = position - 1;
            }
        }

        int column = pos % spanCount; // item column

        if (includeEdge) {
            outRect.left = hSpacing - column * hSpacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * hSpacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

            if (pos < spanCount) { // top edge
                outRect.top = vSpacing;
            }
            outRect.bottom = vSpacing; // item bottom
        } else {
            outRect.left = column * hSpacing / spanCount; // column * ((1f / spanCount) * spacing)
            outRect.right = hSpacing - (column + 1) * hSpacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (pos >= spanCount) {
                outRect.top = vSpacing; // item top
            }
        }

    }

}
