package yyl.rabbitcloud.livebycate;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseActivity;
import yyl.rabbitcloud.di.component.AppComponent;

/**
 * Created by yyl on 2017/6/19.
 */

public class LiveTypeDetailActivity extends BaseActivity {

    private String mTypeString;

    @Override
    protected void requestLayout() {
        setContentView(R.layout.activity_livetype_detail);
    }

    @Override
    protected void initToolBar() {
        String typeName = getIntent().getStringExtra("typeName");
        mToolbar.setTitle(typeName);
    }

    public static void toLiveTypeDetailActivity(BaseActivity activity,String typeName, String type) {
        Intent intent = new Intent(activity, LiveTypeDetailActivity.class);
        intent.putExtra("typeName", typeName);
        intent.putExtra("typeString",type);
        activity.startActivity(intent);
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initData() {
        mTypeString = getIntent().getStringExtra("typeString");

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void initListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
