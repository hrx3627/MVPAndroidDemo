package bluesky.example.com.mvpdemo.listener;

/**
 * Created by Bluesky on 2015/8/27.
 */
public interface Listener {
    public void complete();

    public void onSuccess(Object o);

    public void onFailed(Exception e);
}
