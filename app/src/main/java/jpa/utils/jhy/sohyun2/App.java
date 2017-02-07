package jpa.utils.jhy.sohyun2;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by hayoung on 2017. 1. 6..
 * gkduduu@naver.com
 */

public class App extends Application {
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
