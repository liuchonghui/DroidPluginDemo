package com.plugin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by fuchao on 2016/3/23.
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.text);
        CharSequence content = text.getText();
        text.setText(content + "-TestActivity");
    }
}
