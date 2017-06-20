package yyl.rabbitcloud.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import yyl.rabbitcloud.R;

/**
 * Created by yyl on 2017/6/19.
 */

public class SearchBar extends RelativeLayout implements View.OnClickListener, View.OnFocusChangeListener {

    private View mContainerView;
    private ImageButton search_img_bt;
    private RelativeLayout search_edit_content;
    private EditText search_edit;
    private TextView search_tv;
    private ImageView search_clear;

    private boolean isInterceptChild = false;

    private OnSearchBarClickListener mListener;

    public SearchBar(Context context) {
        this(context,null);
    }

    public SearchBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SearchBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        initListener();
    }

    private void init(Context context) {
        mContainerView = LayoutInflater.from(context).inflate(R.layout.widget_searchbar,this,false);

        search_img_bt = (ImageButton) mContainerView.findViewById(R.id.search_img_bt);
        search_edit_content = (RelativeLayout) mContainerView.findViewById(R.id.search_edit_content);
        search_edit = (EditText) mContainerView.findViewById(R.id.search_edit);
        search_tv = (TextView) mContainerView.findViewById(R.id.search_tv);
        search_clear = (ImageView) mContainerView.findViewById(R.id.search_clear);

        measureView(mContainerView);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                mContainerView.getMeasuredHeight());
        addView(mContainerView, params);

        if (isInterceptChild) {
            search_img_bt.setVisibility(GONE);
            search_tv.setVisibility(GONE);
        } else {
            search_img_bt.setVisibility(VISIBLE);
            search_tv.setVisibility(VISIBLE);
        }
    }

    private void initListener() {
        search_img_bt.setOnClickListener(this);
        search_edit.setOnFocusChangeListener(this);
        search_tv.setOnClickListener(this);
        search_clear.setOnClickListener(this);
    }

    public void setListener(OnSearchBarClickListener listener) {
        mListener = listener;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isInterceptChild;
    }

    public void setInterceptChild(boolean interceptChild) {
        isInterceptChild = interceptChild;
        if (isInterceptChild) {
            search_img_bt.setVisibility(GONE);
            search_tv.setVisibility(GONE);
        } else {
            search_img_bt.setVisibility(VISIBLE);
            search_tv.setVisibility(VISIBLE);
        }
    }

    /**
     * 测量子view
     *
     * @param child
     */
    private void measureView(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
                    MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_img_bt:
                if (mListener != null) {
                    mListener.onClickBack();
                }
                break;
            case R.id.search_tv:
                if (mListener != null) {
                    mListener.onClickSearch();
                }
                break;
            case R.id.search_clear:
                search_edit.setText("");
                break;
        }
    }

    /**
     * 为搜索栏添加文字变化监听
     */
    public void addTextChangeListener(TextWatcher textWatcher){
        search_edit.addTextChangedListener(textWatcher);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (hasFocus) {
            search_clear.setVisibility(VISIBLE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        } else {
            search_clear.setVisibility(GONE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public interface OnSearchBarClickListener {

        void onClickBack();

        void onClickSearch();

    }
}
