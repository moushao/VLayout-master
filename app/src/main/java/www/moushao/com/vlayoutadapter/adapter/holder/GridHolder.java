package www.moushao.com.vlayoutadapter.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import www.moushao.com.vlayoutadapter.R;
import www.moushao.com.vlayoutadapter.adapter.VBaseHolder;
import www.moushao.com.vlayoutadapter.bean.GridBean;

/**
 * Created by Moushao on 2017/8/30.
 */

public class GridHolder extends VBaseHolder<GridBean> {
    @BindView(R.id.icon) ImageView mIcon;
    @BindView(R.id.func) TextView mFunc;

    public GridHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, GridBean data) {
        super.setData(ps, data);
        Glide.with(mContext).load(data.getPic_url()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(mIcon);
        mFunc.setText(data.getFunction());

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
