package www.moushao.com.vlayoutadapter.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import butterknife.BindView;
import www.moushao.com.vlayoutadapter.R;
import www.moushao.com.vlayoutadapter.adapter.VBaseHolder;
import www.moushao.com.vlayoutadapter.bean.BannerBean;

/**
 * Created by Moushao on 2017/8/30.
 */

public class BannerHolder extends VBaseHolder<BannerBean> {
    @BindView(R.id.banner) Banner mBanner;

    public BannerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, BannerBean data) {
        super.setData(ps, data);
        initBanner();
    }

    private void initBanner() {
        //        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) mBanner.getLayoutParams();
        //                linearParams.height = (int) (ScreenUtil.getScreenWidth(mContext) / 2.4);// 控件的宽强制设成30   
        //                mBanner.setLayoutParams(linearParams); //使设置好的布局参数应用到控件
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置图片集合
        mBanner.setImages(mData.getPic_url());
        //设置图片加载器
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                Glide.with(mContext).load((String) o).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into
                        (imageView);
            }
        });

        //设置点击事件监听
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                mListener.onItemClick(mView, i,mData);
            }
        });
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }
}
