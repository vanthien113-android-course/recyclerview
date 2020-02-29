package com.vanthien113.recyclerview_demo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by vanthien113 on 2/29/20.
 */
public class SinhVienViewHolderRight extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvAddress;

    public SinhVienViewHolderRight(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        tvAddress = itemView.findViewById(R.id.tvAddress);
    }

    public void bind(SinhVienObj sinhVienObj) {
        tvName.setText(sinhVienObj.getName());
        tvAddress.setText(sinhVienObj.getAddress());
    }
}
