package com.example.day_02_zuoye2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rlv;
    private ArrayList<DataDb> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initView() {
        ArrayList<DataDb> dataDbs = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            dataDbs.add(new DataDb(null,"标题标题标题标题标题"+i,"内容内容内容内容内容"));
        }
        Utils.getUtils().insert(dataDbs);
        list = new ArrayList<>();
        rlv = (RecyclerView) findViewById(R.id.rlv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv.setLayoutManager(linearLayoutManager);
        adapter = new MyAdapter(list, this);
        rlv.setAdapter(adapter);
    }

    private void initData() {
        List<DataDb> query = Utils.getUtils().query();
        list.addAll(query);
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }
}
