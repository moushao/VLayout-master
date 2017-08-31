package www.moushao.com.vlayoutadapter.event;

/**
 * 类名: {@link MVPCallBack}
 * <br/> 功能描述: mvp模式,解析层和原型层之间的回调借口
 * <br/> 作者: MouTao
 * <br/> 时间: 2017/5/16
 * <br/> 最后修改者:
 * <br/> 最后修改内容:
 */
public interface MVPCallBack<T> {
    void succeed(T mData);

    void failed(String message);
}