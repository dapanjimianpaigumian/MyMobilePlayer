package com.dapanjimianpaigumian.mymobileplayer.base;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2017/5/15.
 * 封装基类 BasePager
 */

public abstract class BasePager {

    public final Context context;

    private View rootview;

    public BasePager(Context context){
        this.context=context;
        rootview=initView();
    }

    /**
     * 强制由子类实现，实现特定的效果
     * @return
     */
    public abstract View initView();

    /**
     * 当子页面需要初始化数据，联网请求数据，或者绑定数据的时候要重写该方法
     */
    public void initData(){

    }
}
