package com.dapanjimianpaigumian.mymobileplayer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.dapanjimianpaigumian.mymobileplayer.commons.ActivityUtils;

public class SplashActivity extends AppCompatActivity {

    private ActivityUtils mActivityUtils;
    private Handler mHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mActivityUtils = new ActivityUtils(this);
        //在主线程运行handler，handler就运行与主线程
        //在子线程运行handler，handler就运行与子线程
        //开屏页持续1.5s后跳转主界面
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mActivityUtils.startActivity(MainActivity.class);
                finish();
            }
        },1500);
    }

    /**
     * 只要触摸屏幕就会触发此方法，
     * 解决需求：开屏页等待时间过长，用户在等待进入主界面过程中，如果点击屏幕就会立刻
     *          进入主界面。
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mActivityUtils.startActivity(MainActivity.class);
        finish();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        //移除所有的回调和消息
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();

    }
}
