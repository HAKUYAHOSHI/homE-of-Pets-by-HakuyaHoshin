package com.example.pets.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pets.R;

import butterknife.BindView;

public class fragmentForCheckXiala extends Fragment{

    private View baseView;

    @BindView(R.id.check_ok_button)
    Button buttonOk = null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseView = inflater.inflate(R.layout.check_xiala_layout,container,false);
        doSearchPOI();
        return baseView;

    }

    private void doSearchPOI() {
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
