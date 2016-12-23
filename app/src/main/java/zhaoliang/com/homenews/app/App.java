package zhaoliang.com.homenews.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 国内新闻
 * Created by zhaoliang on 2016/12/22.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
