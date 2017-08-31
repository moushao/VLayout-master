package www.moushao.com.vlayoutadapter.base;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import www.moushao.com.vlayoutadapter.mvp.presenter.BasePresenter;
import www.moushao.com.vlayoutadapter.mvp.view.BaseView;


public abstract class BaseActivity<T extends BasePresenter<BaseView>> extends AppCompatActivity implements IBase{
    public BasePresenter mPresenter;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mPresenter = getPresenter();
        initInjector();
        if (mPresenter != null && this instanceof BaseView) {
            mPresenter.attach((BaseView) this);
        }
        onSaveState(savedInstanceState);
        initEventAndData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {

        if (mPresenter != null && this instanceof BaseView) {
            mPresenter.detachView();
            mPresenter = null;
        }
        //mRxManager.clear();
        unbinder.unbind();
        super.onDestroy();
    }

    public void onSaveState(Bundle savedInstanceState) {
    }

    /**
     * 获取布局
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initInjector();

    /**
     * 设置监听
     */
    protected abstract void initEventAndData();

    private void initTheme() {
    }

}
