package bluesky.example.com.mvpdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bluesky.example.com.mvpdemo.UI.ILogin;
import bluesky.example.com.mvpdemo.domain.bean.User;
import bluesky.example.com.mvpdemo.presenter.LoginPresenter;

/**
 *登录页面Activity
 */
public class MainActivity extends Activity implements ILogin {
    private LoginPresenter mPresenter;
    private User mUser;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new LoginPresenter(this);
        mUser = new User();

        initVIew();
    }

    private void initVIew() {
        final EditText pwd = (EditText) findViewById(R.id.pwd);
        final EditText name = (EditText) findViewById(R.id.name);
        Button loginBtn= (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUser.setName(name.getText().toString());
                mUser.setPassword(pwd.getText().toString());
                mPresenter.login(mUser);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showSuccess(Object o) {
        User user= (User) o;
        Toast.makeText(this,"登录成功信息："+user.getName()+" /"+user.getPassword(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressPar() {
        mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setMessage("正在加载...");
        mDialog.show();
    }

    @Override
    public void hideProgressPar() {
        mDialog.hide();
    }

    @Override
    public void showError(Object o) {
        Toast.makeText(this,"异常："+((Exception)o).getMessage(),Toast.LENGTH_LONG).show();

    }
}
