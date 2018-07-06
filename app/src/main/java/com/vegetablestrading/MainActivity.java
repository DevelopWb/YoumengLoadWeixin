package com.vegetablestrading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Hello World!
     */
    private TextView mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mLogin = (TextView) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login:
                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.WEIXIN, authListener);

//                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener);
//
//                if (isauth) {
//                    UMShareAPI.get(this).deleteOauth(mActivity, list.get(position).mPlatform, authListener);
//                } else {
//                    UMShareAPI.get(this).doOauthVerify(mActivity, SHARE_MEDIA.WEIXIN, authListener);
//                }
                break;
        }
    }

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, "开始", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(MainActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
}
