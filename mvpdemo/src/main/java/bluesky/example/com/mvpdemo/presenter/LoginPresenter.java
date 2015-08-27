package bluesky.example.com.mvpdemo.presenter;

import android.os.Handler;

import bluesky.example.com.mvpdemo.UI.ILogin;
import bluesky.example.com.mvpdemo.domain.ILoginBiz;
import bluesky.example.com.mvpdemo.domain.impl.LoginBizImpl;
import bluesky.example.com.mvpdemo.listener.Listener;

/**
 * Created by Bluesky on 2015/8/27.
 */
public class LoginPresenter implements Presenter {
    private ILogin mLoginView;
    private ILoginBiz mLoginBiz;
    private Handler mHandler = new Handler();

    public LoginPresenter(ILogin mLoginView) {
        this.mLoginView = mLoginView;
        this.mLoginBiz = new LoginBizImpl();
    }

    /**
     * 登录
     *
     * @param o
     */
    public void login(Object o) {
        mLoginView.showProgressPar();
        mLoginBiz.login(o, new Listener() {
            @Override
            public void complete() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.hideProgressPar();
                    }
                });
            }

            @Override
            public void onSuccess(final Object o) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.showSuccess(o);
                    }

                });
            }

            @Override
            public void onFailed(final Exception e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.showError(e);
                    }
                });

            }
        });
    }
}
