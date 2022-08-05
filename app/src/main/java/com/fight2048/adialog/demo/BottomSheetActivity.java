package com.fight2048.adialog.demo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fight2048.adialog.androidx.ADialogListener;
import com.fight2048.adialog.bottomsheet.BaseBottomSheetDialog;
import com.fight2048.adialog.bottomsheet.BaseBottomSheetDialogFragment;
import com.fight2048.adialog.common.BaseViewHolder;
import com.fight2048.adialog.demo.databinding.ActivityBottomSheetBinding;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetActivity extends AppCompatActivity {
    private ActivityBottomSheetBinding binding;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomSheetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        binding.bottomSheetDialog.setOnClickListener(v -> {
            showBottomSheetDialog();
        });
        binding.bottomSheetDialogFragment.setOnClickListener(v -> {
            showBottomSheetDialogFragment();
        });
    }

    private void showBottomSheetDialog() {
        final List<DataBean> mData = getData();
        new BaseBottomSheetDialog(this)
                .setLayoutId(com.fight2048.adialog.R.layout.adialog_selector)//传入你的xml布局。
                .setConvertListener(new ADialogListener.OnDialogConvertListener() {
                    @Override
                    public void convert(BaseViewHolder holder, final Dialog dialog) {
                        holder.setText(com.fight2048.adialog.R.id.tv_title_selector, "标题")
                                .setOnClickListener(com.fight2048.adialog.R.id.iv_cancel_selector, v -> dialog.dismiss())
                                .setOnClickListener(com.fight2048.adialog.R.id.tv_cancel_selector, v -> dialog.dismiss());

                        RecyclerView recyclerView = holder.getView(com.fight2048.adialog.R.id.recyclerView_selector);
                        recyclerView.setLayoutManager(new LinearLayoutManager(dialog.getContext()));
                        if (adapter != null) {
                            recyclerView.setAdapter(adapter);
                        } else {
                            recyclerView.setAdapter(adapter = new RecyclerView.Adapter<BaseViewHolder>() {
                                @Override
                                public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                                    return new BaseViewHolder(getLayoutInflater().inflate(R.layout.item_rv_selector, parent, false));
                                }

                                @Override
                                public void onBindViewHolder(final BaseViewHolder holder, final int position) {
                                    holder.itemView.setOnClickListener(v -> showToast("1111"));

                                }

                                @Override
                                public int getItemCount() {
                                    return mData.size();
                                }
                            });
                        }
                    }
                })
                .setDimAmount(0.3F)
                .setPeekHeight(100)
                .show();
    }

    private void showBottomSheetDialogFragment() {
        final List<DataBean> mData = getData();

        new BaseBottomSheetDialogFragment()
                .setLayoutId(com.fight2048.adialog.R.layout.adialog_selector)//传入你的xml布局。
                .setConvertListener(new ADialogListener.OnDialogFragmentConvertListener() {

                    @Override
                    public void convert(BaseViewHolder holder, DialogFragment dialog) {
                        holder.setText(com.fight2048.adialog.R.id.tv_title_selector, "标题")
                                .setOnClickListener(com.fight2048.adialog.R.id.iv_cancel_selector, v -> dialog.dismiss())
                                .setOnClickListener(com.fight2048.adialog.R.id.tv_cancel_selector, v -> dialog.dismiss());

                        RecyclerView recyclerView = holder.getView(com.fight2048.adialog.R.id.recyclerView_selector);
                        recyclerView.setLayoutManager(new LinearLayoutManager(dialog.getContext()));
                        if (adapter != null) {
                            recyclerView.setAdapter(adapter);
                        } else {
                            recyclerView.setAdapter(adapter = new RecyclerView.Adapter<BaseViewHolder>() {
                                @Override
                                public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                                    return new BaseViewHolder(getLayoutInflater().inflate(R.layout.item_rv_selector, parent, false));
                                }

                                @Override
                                public void onBindViewHolder(final BaseViewHolder holder, final int position) {
                                    holder.itemView.setOnClickListener(v -> showToast("1111"));

                                }

                                @Override
                                public int getItemCount() {
                                    return mData.size();
                                }
                            });
                        }
                    }
                })
                .setPeekHeight(100)
                .show(getSupportFragmentManager());//显示。
    }

    public Toast mToast;

    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    private List<DataBean> getData() {
        List<DataBean> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new DataBean("第" + i + "个", "请选择"));
        }
        return data;
    }
}
