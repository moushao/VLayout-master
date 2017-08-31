package www.moushao.com.vlayoutadapter;


import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;

/**
 * 类名: {@link Constants}
 * <br/> 功能描述: 存储全局数据的基本类
 * <br/> 作者: MouTao
 * <br/> 时间: 2017/5/19
 */
public class Constants {
    /**
     * 从哪儿来
     */
    public static String FROM = "FROM";
    /**
     * inflater 实例
     */
    private static LayoutInflater inflater;


    /**
     * view 实例
     *
     * @param context
     * @param parent
     * @param res
     * @return
     */
    public static View inflate(Context context, ViewGroup parent, int res) {
        if (inflater == null) {
            inflater = LayoutInflater.from(context);
        }
        return inflater.inflate(res, parent, false);

    }

    /**
     * 手机存储路径
     * Environment.getExternalStorageDirectory();
     */
    public static final String PHONE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File
            .separator + "LangBai" + File.separator;

    /**
     * 基础连接
     */
//    public static String BASE_URL = "http://192.168.1.190:8011/";
    public static String BASE_URL = "http://192.168.1.190:8088/";
    /**
     * DiskCache
     */
    public static final long CACHE_MAXSIZE = 10 * 1024 * 1024;

    public static final String CACHE_USER = "CACHE_USER";
}
