package com.vanthien113.recyclerview_demo;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SinhVienAdapter.SinhVienAdapterListener {
    private RecyclerView rvSinhVien;
    private SinhVienAdapter sinhVienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflateView();
        fakeData();
        initRV();
    }

    private List<SinhVienObj> fakeData() {
        List<SinhVienObj> sinhVienObjList = new ArrayList<>();

        sinhVienObjList.add(new SinhVienObj("Huy", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Huy", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Huyxx", "HN"));
        sinhVienObjList.add(new SinhVienObj("Huywww", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Huy22", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Hu333y", "QT"));
        sinhVienObjList.add(new SinhVienObj("Huy55", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Huy55", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Huy55", "HN"));
        sinhVienObjList.add(new SinhVienObj("Huy66", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Hop77", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Hop", "QT"));
        sinhVienObjList.add(new SinhVienObj("Hop", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Hop", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Hop888", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Thien", "QT"));
        sinhVienObjList.add(new SinhVienObj("Thien77", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Thien99", "Hue"));
        sinhVienObjList.add(new SinhVienObj("Thien99", "HN"));
        sinhVienObjList.add(new SinhVienObj("Thienoo", "Hue"));

        return sinhVienObjList;
    }

    private void initRV() {
        sinhVienAdapter = new SinhVienAdapter(this);

        rvSinhVien.setLayoutManager(new LinearLayoutManager(this));
        rvSinhVien.setAdapter(sinhVienAdapter);

        sinhVienAdapter.setSinhViens(fakeData());
    }

    private void inflateView() {
        rvSinhVien = findViewById(R.id.rvSinhVien);
    }

    @Override
    public void onLoadmore() {
        new Handler().postAtTime(new Runnable() {
            @Override
            public void run() {
                sinhVienAdapter.setSinhViens(fakeData());
            }
        }, 2000);
    }
}
