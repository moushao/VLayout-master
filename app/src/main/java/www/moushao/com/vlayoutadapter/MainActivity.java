package www.moushao.com.vlayoutadapter;

import android.graphics.Color;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import www.moushao.com.vlayoutadapter.adapter.VBaseAdapter;
import www.moushao.com.vlayoutadapter.adapter.holder.BannerHolder;
import www.moushao.com.vlayoutadapter.adapter.holder.ButtomHolder;
import www.moushao.com.vlayoutadapter.adapter.holder.GridHolder;
import www.moushao.com.vlayoutadapter.adapter.holder.HeadlinesHolder;
import www.moushao.com.vlayoutadapter.adapter.holder.NewForceHolder;
import www.moushao.com.vlayoutadapter.adapter.holder.WaterHolder;
import www.moushao.com.vlayoutadapter.base.BaseActivity;
import www.moushao.com.vlayoutadapter.bean.BannerBean;
import www.moushao.com.vlayoutadapter.bean.GridBean;
import www.moushao.com.vlayoutadapter.bean.Headlines;
import www.moushao.com.vlayoutadapter.bean.HomeData;
import www.moushao.com.vlayoutadapter.bean.TmallMarket;
import www.moushao.com.vlayoutadapter.bean.WaterCargo;
import www.moushao.com.vlayoutadapter.event.ItemListener;
import www.moushao.com.vlayoutadapter.mvp.presenter.BasePresenter;
import www.moushao.com.vlayoutadapter.mvp.presenter.MainPresenter;
import www.moushao.com.vlayoutadapter.mvp.view.MainView;


public class MainActivity extends BaseActivity implements MainView {
    public static final String TAG = "MainActivity";
    @BindView(R.id.recycler) RecyclerView mRecycler;
    private Context mContext;
    private DelegateAdapter delegateAdapter;
    private VBaseAdapter bannerAdapter, gridAdapter, headLineAdapter, newForceAdapter, haohuoAdapter, plugInAdapter,
            waterfallAdapter, buttomAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initInjector() {
        mContext = this;
    }

    @Override
    protected void initEventAndData() {
        initRecyclerView();
        ((MainPresenter) mPresenter).getHomePageData(mContext);
    }


    private void initRecyclerView() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        //设置缓存view个数(当视图中view的个数很多时，设置合理的缓存大小，防止来回滚动时重新创建 View)
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 1);
        viewPool.setMaxRecycledViews(1, 10);
        viewPool.setMaxRecycledViews(2, 2);
        viewPool.setMaxRecycledViews(3, 2);
        viewPool.setMaxRecycledViews(4, 6);
        viewPool.setMaxRecycledViews(5, 8);
        viewPool.setMaxRecycledViews(6, 8);
        viewPool.setMaxRecycledViews(7, 1);

        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();

        bannerAdapter = new VBaseAdapter(mContext)//
                .setData(new ArrayList<BannerBean>())//
                .setLayout(R.layout.recyc_banner)//
                .setLayoutHelper(new LinearLayoutHelper())//
                .setHolder(BannerHolder.class)//
                .setListener(new ItemListener() {
                    @Override
                    public void onItemClick(View view, int position, Object mData) {
                        Toast.makeText(mContext, "点击了banner的第" + position + "个图片", Toast.LENGTH_SHORT).show();
                    }
                });

        gridAdapter = new VBaseAdapter(mContext)//
                .setData(new ArrayList<GridBean>())//
                .setLayout(R.layout.recyc_grid)//
                .setHolder(GridHolder.class)//
                .setLayoutHelper(getGridLayoutHelp())//
                .setListener(new ItemListener<GridBean>() {
                    @Override
                    public void onItemClick(View view, int position, GridBean mData) {
                        Toast.makeText(mContext, mData.getFunction(), Toast.LENGTH_SHORT).show();
                    }
                });
        headLineAdapter = new VBaseAdapter(mContext)//
                .setData(new ArrayList<Headlines>())//
                .setLayout(R.layout.recyc_head_line)//
                .setHolder(HeadlinesHolder.class)//
                .setLayoutHelper(getSingleLayoutHelper())//
                .setListener(new ItemListener() {
                    @Override
                    public void onItemClick(View view, int position, Object mData) {
                        Toast.makeText(mContext, "淘宝头条,再点王者荣耀就要掉分", Toast.LENGTH_SHORT).show();
                    }
                });

        newForceAdapter = new VBaseAdapter(mContext)//
                .setData(new ArrayList<String>())//
                .setLayout(R.layout.recyc_new_force)//
                .setHolder(NewForceHolder.class)//
                .setLayoutHelper(getNewForceHelper())//
                .setListener(new ItemListener() {
                    @Override
                    public void onItemClick(View view, int position, Object mData) {
                        Toast.makeText(mContext, "新势力！我知道这图很丑，将就看吧", Toast.LENGTH_SHORT).show();
                    }
                });

        haohuoAdapter = new VBaseAdapter(mContext)//
                .setData(new ArrayList<String>())//
                .setLayout(R.layout.recyc_haohuo)//
                .setHolder(NewForceHolder.class)//
                .setLayoutHelper(getHaohuoHelper())//
                .setListener(new ItemListener() {
                    @Override
                    public void onItemClick(View view, int position, Object mData) {
                        Toast.makeText(mContext, "第" + position + "个淘宝好货,GridLayoutHelper有个Bug", Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        plugInAdapter = new VBaseAdapter(mContext)//
                .setData(new ArrayList<String>())//
                .setLayout(R.layout.recyc_haohuo)//
                .setHolder(NewForceHolder.class)//
                .setLayoutHelper(getNewForceHelper());


        waterfallAdapter = new VBaseAdapter(mContext)//
                .setData(new ArrayList<WaterCargo>())//
                .setLayout(R.layout.recyc_water)//
                .setHolder(WaterHolder.class)//
                .setLayoutHelper(getWaterHelper())//
                .setListener(new ItemListener<WaterCargo>() {
                    @Override
                    public void onItemClick(View view, int position, WaterCargo mData) {
                        Toast.makeText(mContext, "瀑布流布局，只卖" + mData.getPrice(), Toast.LENGTH_SHORT).show();
                    }
                });

        buttomAdapter = new VBaseAdapter(mContext)//
                .setData(new ArrayList<String>())//
                .setLayout(R.layout.layout_textview)//
                .setHolder(ButtomHolder.class)//
                .setLayoutHelper(new SingleLayoutHelper())//
                .setListener(new ItemListener() {
                    @Override
                    public void onItemClick(View view, int position, Object mData) {
                    }
                });

        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(gridAdapter);
        delegateAdapter.addAdapter(headLineAdapter);
        delegateAdapter.addAdapter(newForceAdapter);
        delegateAdapter.addAdapter(haohuoAdapter);
        delegateAdapter.addAdapter(plugInAdapter);
        delegateAdapter.addAdapter(waterfallAdapter);
        delegateAdapter.addAdapter(buttomAdapter);
        mRecycler.setAdapter(delegateAdapter);
    }

    private LayoutHelper getWaterHelper() {
        StaggeredGridLayoutHelper staggerHelper = new StaggeredGridLayoutHelper(2, 8);
        staggerHelper.setMargin(0, 20, 0, 10);
        return staggerHelper;
    }

    private LayoutHelper getHaohuoHelper() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        //是否自动扩展
        gridLayoutHelper.setAutoExpand(false);
        //自定义设置某些位置的Item的占格数
        gridLayoutHelper.setSpanSizeLookup(new GridLayoutHelper.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Log.e("position", position + "");
                if (position == 13) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        //        gridLayoutHelper.setPadding(0, 20, 0, 10);
        //        gridLayoutHelper.setBgColor(Color.parseColor("#FFFFFF"));
        gridLayoutHelper.setVGap(1);
        gridLayoutHelper.setHGap(1);

        return gridLayoutHelper;
    }

    private LayoutHelper getNewForceHelper() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        //        singleLayoutHelper.setBgColor(Color.parseColor("#FF0000"));
        singleLayoutHelper.setMargin(0, 20, 0, 20);
        return singleLayoutHelper;
    }

    private LayoutHelper getSingleLayoutHelper() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setBgColor(Color.parseColor("#FFFFFF"));
        singleLayoutHelper.setPadding(20, 10, 0, 20);
        return singleLayoutHelper;
    }

    private LayoutHelper getGridLayoutHelp() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        //是否自动扩展
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setPadding(0, 20, 0, 10);
        gridLayoutHelper.setBgColor(Color.parseColor("#FFFFFF"));
        gridLayoutHelper.setVGap(20);
        return gridLayoutHelper;
    }


    /**
     * @param mContext 上下文
     * @param from     从哪儿跳来的
     */
    public static void startAction(Context mContext, String from) {
        Intent itt = new Intent(mContext, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.FROM, from);
        itt.putExtras(bundle);
        mContext.startActivity(itt);
    }

    @Override
    public void showProgressDialog(String loadMessage) {

    }

    @Override
    public void disProgressDialog() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void getHomeDataSuccess(HomeData mData) {
        ArrayList<BannerBean> b = new ArrayList<BannerBean>();
        b.add(mData.getBanner());
        bannerAdapter.setData(b);
        bannerAdapter.notifyDataSetChanged();

        gridAdapter.setData(mData.getGrid());
        gridAdapter.notifyDataSetChanged();

        headLineAdapter.setData(mData.getHeadlines());
        headLineAdapter.notifyDataSetChanged();

        newForceAdapter.setData(mData.getForce());
        newForceAdapter.notifyDataSetChanged();

        haohuoAdapter.setData(mData.getHaohuo());
        haohuoAdapter.notifyDataSetChanged();

        ArrayList<String> sList = new ArrayList<>();
        sList.add("https://aecpm.alicdn.com/tfscom/TB1p8ibSVXXXXXsXXXXXXXXXXXX.jpg");
        plugInAdapter.setData(sList);
        plugInAdapter.notifyDataSetChanged();

        waterfallAdapter.setData(mData.getWatercargo());
        waterfallAdapter.notifyDataSetChanged();

        buttomAdapter.setItem("1");
        buttomAdapter.notifyDataSetChanged();
    }


}
