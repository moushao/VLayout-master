package www.moushao.com.vlayoutadapter.bean;

import java.util.ArrayList;

/**
 * Created by Moushao on 2017/8/30.
 */

public class BannerBean {
    private ArrayList<String> pic_url;

    public BannerBean(ArrayList<String> pic_url) {
        this.pic_url = pic_url;
    }

    public ArrayList<String> getPic_url() {
        return pic_url;
    }

    public void setPic_url(ArrayList<String> pic_url) {
        this.pic_url = pic_url;
    }
}
