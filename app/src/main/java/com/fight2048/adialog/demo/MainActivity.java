package com.fight2048.adialog.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.fight2048.adialog.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
    }

    private void initData() {
        binding.btDialog.setOnClickListener(v -> startActivity(new Intent(this, DialogActivity.class)));
        binding.btDialogFragment.setOnClickListener(v -> startActivity(new Intent(this, DialogFragmentActivity.class)));
        binding.btBottomSheet.setOnClickListener(v -> startActivity(new Intent(this, BottomSheetActivity.class)));
    }
}
