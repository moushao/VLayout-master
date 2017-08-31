package www.moushao.com.vlayoutadapter.mvp.view;

/**
 * MVP基础view
 */
public interface BaseView {

    void showProgressDialog(String loadMessage);

    void disProgressDialog();

    void showToast(String message);

}