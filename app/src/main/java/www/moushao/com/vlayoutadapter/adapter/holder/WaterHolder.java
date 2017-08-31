package www.moushao.com.vlayoutadapter.adapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import www.moushao.com.vlayoutadapter.R;
import www.moushao.com.vlayoutadapter.ScreenUtil;
import www.moushao.com.vlayoutadapter.adapter.VBaseHolder;
import www.moushao.com.vlayoutadapter.bean.WaterCargo;

/**
 * Created by Moushao on 2017/8/30.
 */

public class WaterHolder extends VBaseHolder<WaterCargo> {
    @BindView(R.id.pic) ImageView mPic;
    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.price) TextView mPrice;
    @BindView(R.id.num) TextView mNum;

    public WaterHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, WaterCargo mData) {
        super.setData(ps, mData);
        
        ViewGroup.LayoutParams params = mPic.getLayoutParams();
        params.width = ScreenUtil.getScreenWidth(mContext) / 2 - 2;
        params.height = ScreenUtil.getScreenHeight(mContext) / 4 + (int)(Math.random()*100);
        Glide.with(mContext).load(mData.getPic_url()).centerCrop().error(R.mipmap.ic_launcher).diskCacheStrategy
                (DiskCacheStrategy.ALL).into(mPic);
        
        mTitle.setText(mData.getTitle());
        mPrice.setText("¥ " + mData.getPrice());
        mNum.setText(mData.getBuynum() + "人购买");
    }

    @Override
    public void init() {
        super.init();
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
