package com.example.dell.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.myapplication.databinding.TestLayoutBinding;


public class MainActivity extends AppCompatActivity {
    private UserModel viewModel;
    TextView result;
    Button addBtn, subtractBtn;
    TestLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.test_layout);
        result = (TextView) findViewById(R.id.result);
        addBtn = (Button) findViewById(R.id.addBtn);
        subtractBtn = (Button) findViewById(R.id.subtractBtn);

        viewModel = ViewModelProviders.of(this).get(UserModel.class);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setValue(true);
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setValue(false);
            }
        });

        viewModel.getValue().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer dutyTypes) {
                result.setText(String.valueOf(dutyTypes));
            }
        });
    }

}

