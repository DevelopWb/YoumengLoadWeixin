package com.vegetablestrading;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * Author:wang_sir
 * Time:2018/7/1 21:30
 * Description:This is MyApp
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件化基础库, 统计SDK/推送SDK/分享SDK都必须调用此初始化接口
        UMConfigure.init(this, "5b3a1f97a40fa369ea000044",
                "", UMConfigure.DEVICE_TYPE_PHONE, "");
    }
    {
        PlatformConfig.setWeixin("wxdfeeca73484a5f0a", "cdba5aeeac2ea12d0072c79212a44233");
    }
}
