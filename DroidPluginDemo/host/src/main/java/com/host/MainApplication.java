package com.host;

import android.content.Context;

import com.morgoo.droidplugin.PluginApplication;
import com.morgoo.droidplugin.PluginHelper;

/**
 * Created by liuchonghui on 2017/11/15.
 */
public class MainApplication extends PluginApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        PluginHelper.getInstance().applicationOnCreate(getBaseContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        PluginHelper.getInstance().applicationOnCreate(base);
        super.attachBaseContext(base);
    }
}
