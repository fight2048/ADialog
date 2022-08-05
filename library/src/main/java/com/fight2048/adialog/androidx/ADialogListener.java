package com.fight2048.adialog.androidx;

import android.app.Dialog;
import android.view.View;

import androidx.fragment.app.DialogFragment;

import com.fight2048.adialog.common.BaseViewHolder;

/**
 * @author: fight2048
 * @e-mail: fight2048@outlook.com
 * @blog: https://github.com/fight2048
 * @time: 2020-03-07 0007 下午 10:46
 * @version: v0.0.0
 * @description: 页面状态点击事件监听器
 */
public interface ADialogListener {

    interface OnDialogConvertListener {

        void convert(BaseViewHolder holder, Dialog dialog);
    }

    interface OnDialogFragmentConvertListener {

        void convert(BaseViewHolder holder, DialogFragment dialog);
    }

//    interface OnBottomSheetDialogConvertListener {
//
//        void convert(BaseViewHolder holder, BottomSheetDialog dialog);
//    }
//
//    interface OnBottomSheetDialogFragmentConvertListener {
//
//        void convert(BaseViewHolder holder, BottomSheetDialogFragment dialog);
//    }

    interface OnItemConvertListener {

        void onItemConvert(BaseViewHolder holder, int position, Dialog dialog);
    }

    interface OnItemClickListener {

        void onItemClick(View v, BaseViewHolder holder, int position, Dialog dialog);
    }
}