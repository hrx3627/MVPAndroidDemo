package bluesky.example.com.mvpdemo.UI;

/**
 * Created by Bluesky on 2015/8/27.
 * MVP中V层的公共接口
 */
public interface IView {
    public void showProgressPar();

    public void hideProgressPar();

    public void showError(Object o);
}
