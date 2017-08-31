package www.moushao.com.vlayoutadapter.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import www.moushao.com.vlayoutadapter.R;
import www.moushao.com.vlayoutadapter.adapter.VBaseHolder;

/**
 * Created by Moushao on 2017/8/30.
 */

public class NewForceHolder extends VBaseHolder<String> {
    @BindView(R.id.icon) ImageView mIcon;

    public NewForceHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, String mData) {
        super.setData(ps, mData);
        Glide.with(mContext).load(mData).centerCrop().error(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy
                .ALL).into(mIcon);
    }

    @Override
    public void init() {
        super.init();
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
