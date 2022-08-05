package com.fight2048.adialog.androidx.dialog;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.fight2048.adialog.R;

/**
 * @author: fight2048
 * @e-mail: fight2048@outlook.com
 * @blog: https://github.com/fight2048
 * @time: 2020-03-07 0007 下午 10:46
 * @version: v0.0.0
 * @description: 加载中loading
 */
public class LoadingDialog extends BaseDialog {
    public static final String TAG = com.fight2048.adialog.dialog.LoadingDialog.class.getSimpleName();

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adialog_loading;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWidth(-2);
        setHeight(-2);
        setDimAmount(0.1F);
    }
}
