package www.moushao.com.vlayoutadapter.mvp.model;

import android.content.Context;

import com.google.gson.Gson;

import www.moushao.com.vlayoutadapter.GetJsonDataUtil;
import www.moushao.com.vlayoutadapter.bean.HomeData;
import www.moushao.com.vlayoutadapter.event.MVPCallBack;

/**
 * Created by Moushao on 2017/8/30.
 */

public class MainModel {

    public void getHomePageData(Context context, MVPCallBack<HomeData> mvpCallBack) {
        String s = new GetJsonDataUtil().getJson(context, "data.json");
        HomeData mData = new Gson().fromJson(s, HomeData.class);
        mvpCallBack.succeed(mData);
    }
}
