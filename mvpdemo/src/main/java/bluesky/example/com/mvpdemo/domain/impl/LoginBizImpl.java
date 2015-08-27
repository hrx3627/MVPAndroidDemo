package bluesky.example.com.mvpdemo.domain.impl;

import bluesky.example.com.mvpdemo.domain.ILoginBiz;
import bluesky.example.com.mvpdemo.domain.bean.User;
import bluesky.example.com.mvpdemo.listener.Listener;

/**
 * Created by Bluesky on 2015/8/27.
 */
public class LoginBizImpl implements ILoginBiz {
    @Override
    public void login(Object o, final Listener listener) {
        final User user = (User) o;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                listener.complete();
                if (user.getName().equals(user.getPassword())) {//成功
                    listener.onSuccess(user);
                } else {//失败
                    listener.onFailed(new Exception("运行异常..."));
                }
            }
        }).start();
    }
}
