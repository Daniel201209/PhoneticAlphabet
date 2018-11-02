package com.phoneticalphabet.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.phoneticalphabet.R;
import com.phoneticalphabet.adapter.HomeRecyclerView;
import com.phoneticalphabet.bean.VoiceBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView recyclerView_1;
    private RecyclerView recyclerView_2;
    private RecyclerView recyclerView_3;
    private RecyclerView recyclerView_4;
    private List<VoiceBean> voiceBeansList1 = null;
    private List<VoiceBean> voiceBeansList2 = null;
    private List<VoiceBean> voiceBeansList3 = null;
    private List<VoiceBean> voiceBeansList4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    private void initView() {
        recyclerView_1 = findViewById(R.id.recyclerView_1);
        recyclerView_2 = findViewById(R.id.recyclerView_2);
        recyclerView_3 = findViewById(R.id.recyclerView_3);
        recyclerView_4 = findViewById(R.id.recyclerView_4);

        recyclerView_1.setHasFixedSize(true);
        recyclerView_2.setHasFixedSize(true);
        recyclerView_3.setHasFixedSize(true);
        recyclerView_4.setHasFixedSize(true);

        setRecyclerViewData(recyclerView_1);
        setRecyclerViewData(recyclerView_2);
        setRecyclerViewData(recyclerView_3);
        setRecyclerViewData(recyclerView_4);

        setRecylerAdapter(recyclerView_1, voiceBeansList1);
        setRecylerAdapter(recyclerView_2, voiceBeansList2);
        setRecylerAdapter(recyclerView_3, voiceBeansList3);
        setRecylerAdapter(recyclerView_4, voiceBeansList4);

    }


    private void setRecylerAdapter(RecyclerView recyclerView, List<VoiceBean> voiceBeansLists) {
        HomeRecyclerView homeRecyclerView = new HomeRecyclerView(voiceBeansLists);
        homeRecyclerView.setOnItemClickListener(new HomeRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {

            }
        });
        recyclerView.setAdapter(homeRecyclerView);
    }

    //设置分界线
    private void setRecyclerViewData(RecyclerView recyclerView){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置为水平布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.custom_divider));
        recyclerView.addItemDecoration(divider);

    }

    private void initData() {
        voiceBeansList1 = new ArrayList<>();
        VoiceBean voiceBean1 = new VoiceBean();
        voiceBean1.setName("i:");
        voiceBean1.setVoicePath("");
        voiceBeansList1.add(voiceBean1);
        VoiceBean voiceBean2 = new VoiceBean();
        voiceBean2.setName("i:");
        voiceBean2.setVoicePath("");
        voiceBeansList1.add(voiceBean2);
        VoiceBean voiceBean3 = new VoiceBean();
        voiceBean3.setName("i:");
        voiceBean3.setVoicePath("");
        voiceBeansList1.add(voiceBean3);
        VoiceBean voiceBean4 = new VoiceBean();
        voiceBean4.setName("i:");
        voiceBean4.setVoicePath("");
        voiceBeansList1.add(voiceBean4);
        VoiceBean voiceBean5 = new VoiceBean();
        voiceBean5.setName("i:");
        voiceBean5.setVoicePath("");
        voiceBeansList1.add(voiceBean5);
        VoiceBean voiceBean6 = new VoiceBean();
        voiceBean6.setName("i:");
        voiceBean6.setVoicePath("");
        voiceBeansList1.add(voiceBean6);
        VoiceBean voiceBean7 = new VoiceBean();
        voiceBean7.setName("i:");
        voiceBean7.setVoicePath("");
        voiceBeansList1.add(voiceBean7);
        VoiceBean voiceBean8 = new VoiceBean();
        voiceBean8.setName("i:");
        voiceBean8.setVoicePath("");
        voiceBeansList1.add(voiceBean8);
        VoiceBean voiceBean9 = new VoiceBean();
        voiceBean9.setName("i:");
        voiceBean9.setVoicePath("");
        voiceBeansList1.add(voiceBean9);
        VoiceBean voiceBean10 = new VoiceBean();
        voiceBean10.setName("i:");
        voiceBean10.setVoicePath("");
        voiceBeansList1.add(voiceBean10);
        VoiceBean voiceBean11 = new VoiceBean();
        voiceBean11.setName("i:");
        voiceBean11.setVoicePath("");
        voiceBeansList1.add(voiceBean11);
        VoiceBean voiceBean12 = new VoiceBean();
        voiceBean12.setName("i:");
        voiceBean12.setVoicePath("");
        voiceBeansList1.add(voiceBean12);
//============================================================
        voiceBeansList2 = new ArrayList<>();
        VoiceBean voiceBean13 = new VoiceBean();
        voiceBean13.setName("i:");
        voiceBean13.setVoicePath("");
        voiceBeansList2.add(voiceBean13);
        VoiceBean voiceBean14 = new VoiceBean();
        voiceBean14.setName("i:");
        voiceBean14.setVoicePath("");
        voiceBeansList2.add(voiceBean14);
        VoiceBean voiceBean15 = new VoiceBean();
        voiceBean15.setName("i:");
        voiceBean15.setVoicePath("");
        voiceBeansList2.add(voiceBean15);
        VoiceBean voiceBean16 = new VoiceBean();
        voiceBean16.setName("i:");
        voiceBean16.setVoicePath("");
        voiceBeansList2.add(voiceBean16);
        VoiceBean voiceBean17 = new VoiceBean();
        voiceBean17.setName("i:");
        voiceBean17.setVoicePath("");
        voiceBeansList2.add(voiceBean17);
        VoiceBean voiceBean18 = new VoiceBean();
        voiceBean18.setName("i:");
        voiceBean18.setVoicePath("");
        voiceBeansList2.add(voiceBean18);
        VoiceBean voiceBean19 = new VoiceBean();
        voiceBean19.setName("i:");
        voiceBean19.setVoicePath("");
        voiceBeansList2.add(voiceBean19);
        VoiceBean voiceBean20 = new VoiceBean();
        voiceBean20.setName("i:");
        voiceBean20.setVoicePath("");
        voiceBeansList2.add(voiceBean20);
//============================================================
        voiceBeansList3 = new ArrayList<>();
        VoiceBean voiceBean = new VoiceBean();
        voiceBean.setName("i:");
        voiceBean.setVoicePath("");
        voiceBeansList3.add(voiceBean);
        VoiceBean voiceBean21 = new VoiceBean();
        voiceBean21.setName("i:");
        voiceBean21.setVoicePath("");
        voiceBeansList3.add(voiceBean21);
        VoiceBean voiceBean22 = new VoiceBean();
        voiceBean22.setName("i:");
        voiceBean22.setVoicePath("");
        voiceBeansList3.add(voiceBean22);
        VoiceBean voiceBean23 = new VoiceBean();
        voiceBean23.setName("i:");
        voiceBean23.setVoicePath("");
        voiceBeansList3.add(voiceBean23);
        VoiceBean voiceBean24 = new VoiceBean();
        voiceBean24.setName("i:");
        voiceBean24.setVoicePath("");
        voiceBeansList3.add(voiceBean24);
        VoiceBean voiceBean25 = new VoiceBean();
        voiceBean25.setName("i:");
        voiceBean25.setVoicePath("");
        voiceBeansList3.add(voiceBean25);
        VoiceBean voiceBean26 = new VoiceBean();
        voiceBean26.setName("i:");
        voiceBean26.setVoicePath("");
        voiceBeansList3.add(voiceBean26);
        VoiceBean voiceBean27 = new VoiceBean();
        voiceBean27.setName("i:");
        voiceBean27.setVoicePath("");
        voiceBeansList3.add(voiceBean27);
        VoiceBean voiceBean28 = new VoiceBean();
        voiceBean28.setName("i:");
        voiceBean28.setVoicePath("");
        voiceBeansList3.add(voiceBean28);
        VoiceBean voiceBean29 = new VoiceBean();
        voiceBean29.setName("i:");
        voiceBean29.setVoicePath("");
        voiceBeansList3.add(voiceBean29);
        VoiceBean voiceBean30 = new VoiceBean();
        voiceBean30.setName("i:");
        voiceBean30.setVoicePath("");
        voiceBeansList3.add(voiceBean30);
//============================================================
        voiceBeansList4 = new ArrayList<>();
        VoiceBean voiceBean31 = new VoiceBean();
        voiceBean31.setName("i:");
        voiceBean31.setVoicePath("");
        voiceBeansList4.add(voiceBean31);
        VoiceBean voiceBean32 = new VoiceBean();
        voiceBean32.setName("i:");
        voiceBean32.setVoicePath("");
        voiceBeansList4.add(voiceBean32);
        VoiceBean voiceBean33 = new VoiceBean();
        voiceBean33.setName("i:");
        voiceBean33.setVoicePath("");
        voiceBeansList4.add(voiceBean33);
        VoiceBean voiceBean34 = new VoiceBean();
        voiceBean34.setName("i:");
        voiceBean34.setVoicePath("");
        voiceBeansList4.add(voiceBean34);
        VoiceBean voiceBean35 = new VoiceBean();
        voiceBean35.setName("i:");
        voiceBean35.setVoicePath("");
        voiceBeansList4.add(voiceBean35);
        VoiceBean voiceBean36 = new VoiceBean();
        voiceBean36.setName("i:");
        voiceBean36.setVoicePath("");
        voiceBeansList4.add(voiceBean36);
        VoiceBean voiceBean37 = new VoiceBean();
        voiceBean37.setName("i:");
        voiceBean37.setVoicePath("");
        voiceBeansList4.add(voiceBean37);
        VoiceBean voiceBean38 = new VoiceBean();
        voiceBean38.setName("i:");
        voiceBean38.setVoicePath("");
        voiceBeansList4.add(voiceBean38);
        VoiceBean voiceBean39 = new VoiceBean();
        voiceBean39.setName("i:");
        voiceBean39.setVoicePath("");
        voiceBeansList4.add(voiceBean39);
        VoiceBean voiceBean40 = new VoiceBean();
        voiceBean40.setName("i:");
        voiceBean40.setVoicePath("");
        voiceBeansList4.add(voiceBean40);
        VoiceBean voiceBean41 = new VoiceBean();
        voiceBean41.setName("i:");
        voiceBean41.setVoicePath("");
        voiceBeansList4.add(voiceBean41);
        VoiceBean voiceBean42 = new VoiceBean();
        voiceBean42.setName("i:");
        voiceBean42.setVoicePath("");
        voiceBeansList4.add(voiceBean42);
        VoiceBean voiceBean43 = new VoiceBean();
        voiceBean43.setName("i:");
        voiceBean43.setVoicePath("");
        voiceBeansList4.add(voiceBean43);
        VoiceBean voiceBean44 = new VoiceBean();
        voiceBean44.setName("i:");
        voiceBean44.setVoicePath("");
        voiceBeansList4.add(voiceBean44);
        VoiceBean voiceBean45 = new VoiceBean();
        voiceBean45.setName("i:");
        voiceBean45.setVoicePath("");
        voiceBeansList4.add(voiceBean45);
        VoiceBean voiceBean46 = new VoiceBean();
        voiceBean46.setName("i:");
        voiceBean46.setVoicePath("");
        voiceBeansList4.add(voiceBean46);
        VoiceBean voiceBean47 = new VoiceBean();
        voiceBean47.setName("i:");
        voiceBean47.setVoicePath("");
        voiceBeansList4.add(voiceBean47);
        VoiceBean voiceBean48 = new VoiceBean();
        voiceBean48.setName("i:");
        voiceBean48.setVoicePath("");
        voiceBeansList4.add(voiceBean48);
    }
}
