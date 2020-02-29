package com.vanthien113.recyclerview_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanthien113 on 2/29/20.
 */
public class SinhVienAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SinhVienObj> sinhVienObjList;
    private final int TYPE_LEFT = 0;
    private final int TYPE_RIGHT = 1;
    private SinhVienAdapterListener listener;

    public SinhVienAdapter(SinhVienAdapterListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_LEFT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinh_vien, parent, false);
            return new SinhVienViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinh_vien_right, parent, false);
            return new SinhVienViewHolderRight(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SinhVienViewHolder) {
            ((SinhVienViewHolder) holder).bind(sinhVienObjList.get(position));
        } else if (holder instanceof SinhVienViewHolderRight) {
            ((SinhVienViewHolderRight) holder).bind(sinhVienObjList.get(position));
        }

        if (position == sinhVienObjList.size() - 2) {
            listener.onLoadmore();
        }
    }

    public void setSinhViens(List<SinhVienObj> sinhViens) {
        if (sinhVienObjList == null) {
            sinhVienObjList = new ArrayList<>();
        }

        int preSize = sinhVienObjList.size();

        sinhVienObjList.addAll(sinhViens);

        notifyItemRangeInserted(preSize, sinhViens.size());
    }

    @Override
    public int getItemViewType(int position) {
        if (sinhVienObjList.get(position).getAddress().equals("Hue")) {
            return TYPE_LEFT;
        }
        return TYPE_RIGHT;
    }

    @Override
    public int getItemCount() {
        return sinhVienObjList == null ? 0 : sinhVienObjList.size();
    }

    public interface SinhVienAdapterListener {
        void onLoadmore();
    }
}
