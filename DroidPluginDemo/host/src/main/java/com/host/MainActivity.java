package com.host;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.morgoo.droidplugin.pm.PluginManager;
import com.morgoo.helper.compat.PackageManagerCompat;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;
    private File[] plugins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvTest = (TextView) findViewById(R.id.tv_test);
        Button btnTest = (Button) findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("kuaiest://main/"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        //获取插件
        File file = new File("/data/data/com.host/Plugin");
        plugins = file.listFiles();
        //没有插件
        if (plugins == null || plugins.length == 0) {
            return;
        }
        //安装第一个插件
        else {
            try {
                PluginManager.getInstance().installPackage(plugins[0].getAbsolutePath(), PackageManagerCompat.INSTALL_REPLACE_EXISTING);
                tvTest.setText(plugins[0].getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
