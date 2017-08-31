package www.moushao.com.vlayoutadapter.mvp.presenter;

import android.content.Context;

import www.moushao.com.vlayoutadapter.bean.HomeData;
import www.moushao.com.vlayoutadapter.event.MVPCallBack;
import www.moushao.com.vlayoutadapter.mvp.model.MainModel;
import www.moushao.com.vlayoutadapter.mvp.view.MainView;

/**
 * Created by Moushao on 2017/8/30.
 */

public class MainPresenter extends BasePresenter<MainView> {
    MainModel mModel = new MainModel();
    public void getHomePageData(Context context) {
        mModel.getHomePageData(context, new MVPCallBack<HomeData>() {
            @Override
            public void succeed(HomeData mData) {
                if (mView!=null) {
                    mView.getHomeDataSuccess(mData);
                }
            }

            @Override
            public void failed(String message) {

            }
        });
    }
}
