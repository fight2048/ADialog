package com.fight2048.adialog.demo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fight2048.adialog.androidx.ADialogListener;
import com.fight2048.adialog.androidx.dialog.BaseDialog;
import com.fight2048.adialog.androidx.dialog.LoadingDialog;
import com.fight2048.adialog.androidx.dialog.SelectorDialog;
import com.fight2048.adialog.common.BaseViewHolder;
import com.fight2048.adialog.demo.databinding.ActivityDialogBinding;

import java.util.ArrayList;
import java.util.List;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityDialogBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
    }

    private void initData() {
        binding.share.setOnClickListener(this);
        binding.selector.setOnClickListener(this);
        binding.editInput.setOnClickListener(this);
        binding.luckyMoney.setOnClickListener(this);
        binding.loading.setOnClickListener(this);
        binding.tips.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share:
                new BaseDialog(this)
                        .setLayoutId(R.layout.share_layout)//传入你的xml布局。
                        .setConvertListener(new ADialogListener.OnDialogConvertListener() {
                            @Override
                            public void convert(BaseViewHolder holder, final Dialog dialog) {
                                //通过ViewHolder对View进行一些定制化。
                                holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        showToast("点击关闭");
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setDimAmount(0.3F)//设置window的暗度。
                        .setGravity(Gravity.TOP)//位置有多种选择。
                        .setAnimStyle(com.fight2048.adialog.R.style.SlideAnimation)//进入和退出动画。
                        .show();//显示。
                break;
            case R.id.selector:
                final List<DataBean> mData = getData();
                new SelectorDialog(this)
                        .setItemLayoutId(R.layout.item_rv_selector)
                        .setData(mData)
                        .setOnItemConvertListener(new ADialogListener.OnItemConvertListener() {
                            @Override
                            public void onItemConvert(BaseViewHolder holder, int position, Dialog dialog) {
                                DataBean item = mData.get(position);
                                holder.setText(R.id.tv_name_item_rv_host_selector, item.name)
                                        .setText(R.id.tv_role_item_rv_host_selector, item.des)
                                        .setText(R.id.tv_current_item_rv_host_selector, item.des);
                            }
                        })
                        .setOnItemClickListener(new ADialogListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View v, BaseViewHolder holder, int position, Dialog dialog) {
                                showToast("position-->" + position);
                                dialog.dismiss();
                            }
                        })
                        .setTitle("请选择XXX")
                        .setHeight(250)
                        .setAnimStyle(com.fight2048.adialog.R.style.SlideAnimation)
                        .setGravity(Gravity.BOTTOM)
                        .show();
                break;
            case R.id.edit_input:
                new BaseDialog(this)
                        .setLayoutId(R.layout.commit_layout)
                        .setConvertListener(new ADialogListener.OnDialogConvertListener() {
                            @Override
                            public void convert(BaseViewHolder holder, final Dialog dialog) {
                                final EditText editText = holder.getView(R.id.edit_input);
                                editText.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                        imm.showSoftInput(editText, 0);
                                    }
                                });

                                holder.setOnClickListener(R.id.commit, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        showToast("点了");
                                    }
                                });
                            }
                        })
                        .setDimAmount(0.3f)
                        .setGravity(Gravity.BOTTOM)
                        .setAnimStyle(com.fight2048.adialog.R.style.SlideAnimation)
                        .show();
                break;
            case R.id.lucky_money:
                new BaseDialog(this)
                        .setLayoutId(R.layout.ad_layout)
                        .setConvertListener(new ADialogListener.OnDialogConvertListener() {
                            @Override
                            public void convert(BaseViewHolder holder, final Dialog dialog) {
                                holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        showToast("点了");
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setGravity(Gravity.CENTER)
                        .setAnimStyle(com.fight2048.adialog.R.style.SlideAnimation)
                        .show();
                break;
            case R.id.loading:
                BaseDialog loading = new LoadingDialog(this).setDimAmount(0);
                loading.show();
                loading.setCancelable(true);
                break;
            case R.id.tips:
                new BaseDialog(this)
                        .setLayoutId(R.layout.confirm_layout)
                        .setConvertListener(new ADialogListener.OnDialogConvertListener() {
                            @Override
                            public void convert(BaseViewHolder holder, final Dialog dialog) {
                                holder.setText(R.id.title, "提示")
                                        .setText(R.id.message, "您已支付成功！")
                                        .setOnClickListener(R.id.cancel, new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                showToast("点了");
                                                dialog.dismiss();
                                            }
                                        }).setOnClickListener(R.id.ok, new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                showToast("点了");
                                                dialog.dismiss();
                                            }
                                        });
                            }
                        })
                        .setDimAmount(0.3f)
                        .setMargin(30)
                        .show();
                break;

            default:
                break;
        }
    }

    private List<DataBean> getData() {
        List<DataBean> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new DataBean("第" + i + "个", "请选择"));
        }
        return data;
    }

    public Toast mToast;

    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
