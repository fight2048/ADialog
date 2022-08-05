package com.fight2048.adialog.androidx.dialogfragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fight2048.adialog.androidx.ADialogListener;
import com.fight2048.adialog.androidx.dialog.SelectorDialog;

import java.util.List;

/**
 * @author: fight2048
 * @e-mail: fight2048@outlook.com
 * @blog: https://github.com/fight2048
 * @time: 2020-03-07 0007 下午 10:46
 * @version: v0.0.0
 * @description:
 */
public class SelectorDialogFragment extends BaseDialogFragment {
    private String title;
    private List mData;
    private RecyclerView.Adapter adapter;
    private int itemLayoutId;
    private ADialogListener.OnItemConvertListener itemConvertListener;
    private ADialogListener.OnItemClickListener itemClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new SelectorDialog(getContext())
                .setTitle(title)
                .setItemLayoutId(itemLayoutId)
                .setData(mData)
                .setAdapter(adapter)
                .setOnItemConvertListener(itemConvertListener)
                .setOnItemClickListener(itemClickListener);
    }

    public String getTitle() {
        return title;
    }

    public SelectorDialogFragment setTitle(String title) {
        this.title = title;
        return this;
    }

    public List getData() {
        return mData;
    }

    public SelectorDialogFragment setData(List mData) {
        this.mData = mData;
        return this;
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public SelectorDialogFragment setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
        return this;
    }

    public int getItemLayoutId() {
        return itemLayoutId;
    }

    public SelectorDialogFragment setItemLayoutId(int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
        return this;
    }

    public ADialogListener.OnItemConvertListener getOnItemConvertListener() {
        return itemConvertListener;
    }

    public SelectorDialogFragment setOnItemConvertListener(ADialogListener.OnItemConvertListener itemConvertListener) {
        this.itemConvertListener = itemConvertListener;
        return this;
    }

    public ADialogListener.OnItemClickListener getOnItemClickListener() {
        return itemClickListener;
    }

    public SelectorDialogFragment setOnItemClickListener(ADialogListener.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        return this;
    }
}
