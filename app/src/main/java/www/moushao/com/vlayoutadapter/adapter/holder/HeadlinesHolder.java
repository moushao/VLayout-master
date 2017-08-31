package www.moushao.com.vlayoutadapter.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.loader.ImageLoader;

import butterknife.BindView;
import www.moushao.com.vlayoutadapter.R;
import www.moushao.com.vlayoutadapter.adapter.VBaseHolder;
import www.moushao.com.vlayoutadapter.bean.Headlines;

/**
 * Created by Moushao on 2017/8/30.
 */

public class HeadlinesHolder extends VBaseHolder<Headlines> {
    @BindView(R.id.icon) ImageView mPic;

    public HeadlinesHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, Headlines data) {
        super.setData(ps, data);
        Glide.with(mContext).load(data.getUrl_pic()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(mPic);
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
