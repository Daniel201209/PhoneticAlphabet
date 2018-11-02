package com.phoneticalphabet.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.phoneticalphabet.R;
import com.phoneticalphabet.adapter.HomeRecyclerView;
import com.phoneticalphabet.bean.VoiceBean;
import com.phoneticalphabet.view.HomeLayoutManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements MediaPlayer.OnCompletionListener {

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

        HomeRecyclerView homeRecyclerView1 = new HomeRecyclerView(voiceBeansList1);
        homeRecyclerView1.setOnItemClickListener(new HomeRecyclerView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onItemClick(View view, int postion) {
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    if (!mediaPlayer.isPlaying()) {
                        AssetFileDescriptor fd = getAssets().openFd(String.valueOf(voiceBeansList1.get(postion).getVoicePath()));
                        mediaPlayer.setDataSource(fd);
                        mediaPlayer.setOnCompletionListener(MainActivity.this);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        recyclerView_1.setAdapter(homeRecyclerView1);

        HomeRecyclerView homeRecyclerView2 = new HomeRecyclerView(voiceBeansList2);
        homeRecyclerView2.setOnItemClickListener(new HomeRecyclerView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onItemClick(View view, int postion) {
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    if (!mediaPlayer.isPlaying()) {
                        AssetFileDescriptor fd = getAssets().openFd(String.valueOf(voiceBeansList2.get(postion).getVoicePath()));
                        mediaPlayer.setDataSource(fd);
                        mediaPlayer.setOnCompletionListener(MainActivity.this);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        recyclerView_2.setAdapter(homeRecyclerView2);

        HomeRecyclerView homeRecyclerView3 = new HomeRecyclerView(voiceBeansList3);
        homeRecyclerView3.setOnItemClickListener(new HomeRecyclerView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onItemClick(View view, int postion) {
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    if (!mediaPlayer.isPlaying()) {
                        AssetFileDescriptor fd = getAssets().openFd(String.valueOf(voiceBeansList3.get(postion).getVoicePath()));
                        mediaPlayer.setDataSource(fd);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        recyclerView_3.setAdapter(homeRecyclerView3);

        HomeRecyclerView homeRecyclerView4 = new HomeRecyclerView(voiceBeansList4);
        homeRecyclerView4.setOnItemClickListener(new HomeRecyclerView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onItemClick(View view, int postion) {
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    if (!mediaPlayer.isPlaying()) {
                        AssetFileDescriptor fd = getAssets().openFd(String.valueOf(voiceBeansList4.get(postion).getVoicePath()));
                        mediaPlayer.setDataSource(fd);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        recyclerView_4.setAdapter(homeRecyclerView4);
    }

    //设置分界线
    private void setRecyclerViewData(RecyclerView recyclerView) {
        HomeLayoutManager layout = new HomeLayoutManager();
        layout.setAutoMeasureEnabled(true);
        //设置布局管理器
        recyclerView.setLayoutManager(layout);
//        //添加自定义分割线
//        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
//        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.custom_divider));
//        recyclerView.addItemDecoration(divider);

    }

    private void initData() {
//        https://i.xiao84.com/en-yinbiao/mp3/48yinbiaomp3/o-sound.mp3
        voiceBeansList1 = new ArrayList<>();
        VoiceBean voiceBean1 = new VoiceBean();
        voiceBean1.setName("ɪ");
        voiceBean1.setVoicePath("i-sound2.mp3");
        voiceBeansList1.add(voiceBean1);
        VoiceBean voiceBean2 = new VoiceBean();
        voiceBean2.setName("i:");
        voiceBean2.setVoicePath("i-sound.mp3");
        voiceBeansList1.add(voiceBean2);
        VoiceBean voiceBean3 = new VoiceBean();
        voiceBean3.setName("e");
        voiceBean3.setVoicePath("e-sound.mp3");
        voiceBeansList1.add(voiceBean3);
        VoiceBean voiceBean4 = new VoiceBean();
        voiceBean4.setName("æ");
        voiceBean4.setVoicePath("an-sound.mp3");
        voiceBeansList1.add(voiceBean4);
        VoiceBean voiceBean5 = new VoiceBean();
        voiceBean5.setName("ʌ");
        voiceBean5.setVoicePath("^-sound.mp3");
        voiceBeansList1.add(voiceBean5);
        VoiceBean voiceBean6 = new VoiceBean();
        voiceBean6.setName("ɑː");
        voiceBean6.setVoicePath("a-sound2.mp3");
        voiceBeansList1.add(voiceBean6);
        VoiceBean voiceBean7 = new VoiceBean();
        voiceBean7.setName("ə");
        voiceBean7.setVoicePath("e^-sound.mp3");
        voiceBeansList1.add(voiceBean7);
        VoiceBean voiceBean8 = new VoiceBean();
        voiceBean8.setName("ɜː");
        voiceBean8.setVoicePath("er-sound.mp3");
        voiceBeansList1.add(voiceBean8);
        VoiceBean voiceBean9 = new VoiceBean();
        voiceBean9.setName("ɒ");
        voiceBean9.setVoicePath("o-sound.mp3");
        voiceBeansList1.add(voiceBean9);
        VoiceBean voiceBean10 = new VoiceBean();
        voiceBean10.setName("ɔː");
        voiceBean10.setVoicePath("o-sound2.mp3");
        voiceBeansList1.add(voiceBean10);
        VoiceBean voiceBean11 = new VoiceBean();
        voiceBean11.setName("ʊ");
        voiceBean11.setVoicePath("u-sound.mp3");
        voiceBeansList1.add(voiceBean11);
        VoiceBean voiceBean12 = new VoiceBean();
        voiceBean12.setName("uː");
        voiceBean12.setVoicePath("u-sound2.mp3");
        voiceBeansList1.add(voiceBean12);
//============================================================
//        eɪ aɪ ɔɪ aʊ əʊ	ɪə eə ʊə
        voiceBeansList2 = new ArrayList<>();
        VoiceBean voiceBean13 = new VoiceBean();
        voiceBean13.setName("eɪ");
        voiceBean13.setVoicePath("ei.mp3");
        voiceBeansList2.add(voiceBean13);
        VoiceBean voiceBean14 = new VoiceBean();
        voiceBean14.setName("aɪ");
        voiceBean14.setVoicePath("ai.mp3");
        voiceBeansList2.add(voiceBean14);
        VoiceBean voiceBean15 = new VoiceBean();
        voiceBean15.setName("ɔɪ");
        voiceBean15.setVoicePath("oi.mp3");
        voiceBeansList2.add(voiceBean15);
        VoiceBean voiceBean16 = new VoiceBean();
        voiceBean16.setName("aʊ");
        voiceBean16.setVoicePath("ao.mp3");
        voiceBeansList2.add(voiceBean16);
        VoiceBean voiceBean17 = new VoiceBean();
        voiceBean17.setName("əʊ");
        voiceBean17.setVoicePath("eu.mp3");
        voiceBeansList2.add(voiceBean17);
        VoiceBean voiceBean18 = new VoiceBean();
        voiceBean18.setName("ɪə");
        voiceBean18.setVoicePath("ir.mp3");
        voiceBeansList2.add(voiceBean18);
        VoiceBean voiceBean19 = new VoiceBean();
        voiceBean19.setName("ʊə");
        voiceBean19.setVoicePath("uer.mp3");
        voiceBeansList2.add(voiceBean19);
        VoiceBean voiceBean20 = new VoiceBean();
        voiceBean20.setName("eə");
        voiceBean20.setVoicePath("er.mp3");
        voiceBeansList2.add(voiceBean20);
//============================================================
//        p t k b d ɡ f s ʃ θ h v z
        voiceBeansList3 = new ArrayList<>();
        VoiceBean voiceBean = new VoiceBean();
        voiceBean.setName("p");
        voiceBean.setVoicePath("p.mp3");
        voiceBeansList3.add(voiceBean);
        VoiceBean voiceBean21 = new VoiceBean();
        voiceBean21.setName("k");
        voiceBean21.setVoicePath("k.mp3");
        voiceBeansList3.add(voiceBean21);
        VoiceBean voiceBean22 = new VoiceBean();
        voiceBean22.setName("t");
        voiceBean22.setVoicePath("t.mp3");
        voiceBeansList3.add(voiceBean22);
        VoiceBean voiceBean23 = new VoiceBean();
        voiceBean23.setName("f");
        voiceBean23.setVoicePath("f.mp3");
        voiceBeansList3.add(voiceBean23);
        VoiceBean voiceBean24 = new VoiceBean();
        voiceBean24.setName("s");
        voiceBean24.setVoicePath("s.mp3");
        voiceBeansList3.add(voiceBean24);
        VoiceBean voiceBean25 = new VoiceBean();
        voiceBean25.setName("θ");
        voiceBean25.setVoicePath("si.mp3");
        voiceBeansList3.add(voiceBean25);
        VoiceBean voiceBean26 = new VoiceBean();
        voiceBean26.setName("ʃ");
        voiceBean26.setVoicePath("ss.mp3");
        voiceBeansList3.add(voiceBean26);
        VoiceBean voiceBean27 = new VoiceBean();
        voiceBean27.setName("h");
        voiceBean27.setVoicePath("h.mp3");
        voiceBeansList3.add(voiceBean27);
        VoiceBean voiceBean28 = new VoiceBean();
        voiceBean28.setName("tʃ");
        voiceBean28.setVoicePath("tss.mp3");
        voiceBeansList3.add(voiceBean28);
        VoiceBean voiceBean29 = new VoiceBean();
        voiceBean29.setName("ts");
        voiceBean29.setVoicePath("ts.mp3");
        voiceBeansList3.add(voiceBean29);
        VoiceBean voiceBean30 = new VoiceBean();
        voiceBean30.setName("tr");
        voiceBean30.setVoicePath("tr.mp3");
        voiceBeansList3.add(voiceBean30);
//============================================================
//        p t k b d ɡ f s ʃ θ h v z ʒ ð tʃ tr ts dʒ dr dz	m n ŋ	l r j w
        voiceBeansList4 = new ArrayList<>();
        VoiceBean voiceBean31 = new VoiceBean();
        voiceBean31.setName("b");
        voiceBean31.setVoicePath("b.mp3");
        voiceBeansList4.add(voiceBean31);
        VoiceBean voiceBean32 = new VoiceBean();
        voiceBean32.setName("ɡ");
        voiceBean32.setVoicePath("g.mp3");
        voiceBeansList4.add(voiceBean32);
        VoiceBean voiceBean33 = new VoiceBean();
        voiceBean33.setName("d");
        voiceBean33.setVoicePath("d.mp3");
        voiceBeansList4.add(voiceBean33);
        VoiceBean voiceBean34 = new VoiceBean();
        voiceBean34.setName("v");
        voiceBean34.setVoicePath("v.mp3");
        voiceBeansList4.add(voiceBean34);
        VoiceBean voiceBean35 = new VoiceBean();
        voiceBean35.setName("z");
        voiceBean35.setVoicePath("z.mp3");
        voiceBeansList4.add(voiceBean35);
        VoiceBean voiceBean36 = new VoiceBean();
        voiceBean36.setName("ð");
        voiceBean36.setVoicePath("qq.mp3");
        voiceBeansList4.add(voiceBean36);
        VoiceBean voiceBean37 = new VoiceBean();
        voiceBean37.setName("ʒ");
        voiceBean37.setVoicePath("n3.mp3");
        voiceBeansList4.add(voiceBean37);
        VoiceBean voiceBean38 = new VoiceBean();
        voiceBean38.setName("r");
        voiceBean38.setVoicePath("r.mp3");
        voiceBeansList4.add(voiceBean38);
        VoiceBean voiceBean39 = new VoiceBean();
        voiceBean39.setName("dʒ");
        voiceBean39.setVoicePath("d3.mp3");
        voiceBeansList4.add(voiceBean39);
        VoiceBean voiceBean40 = new VoiceBean();
        voiceBean40.setName("dz");
        voiceBean40.setVoicePath("dz.mp3");
        voiceBeansList4.add(voiceBean40);
        VoiceBean voiceBean41 = new VoiceBean();
        voiceBean41.setName("dr");
        voiceBean41.setVoicePath("dr.mp3");
        voiceBeansList4.add(voiceBean41);
        VoiceBean voiceBean42 = new VoiceBean();
        voiceBean42.setName("m");
        voiceBean42.setVoicePath("m.mp3");
        voiceBeansList4.add(voiceBean42);
        VoiceBean voiceBean43 = new VoiceBean();
        voiceBean43.setName("n");
        voiceBean43.setVoicePath("n.mp3");
        voiceBeansList4.add(voiceBean43);
        VoiceBean voiceBean44 = new VoiceBean();
        voiceBean44.setName("ŋ");
        voiceBean44.setVoicePath("ng.mp3");
        voiceBeansList4.add(voiceBean44);
        VoiceBean voiceBean45 = new VoiceBean();
        voiceBean45.setName("w");
        voiceBean45.setVoicePath("w.mp3");
        voiceBeansList4.add(voiceBean45);
        VoiceBean voiceBean46 = new VoiceBean();
        voiceBean46.setName("j");
        voiceBean46.setVoicePath("j.mp3");
        voiceBeansList4.add(voiceBean46);
        VoiceBean voiceBean47 = new VoiceBean();
        voiceBean47.setName("l");
        voiceBean47.setVoicePath("l.mp3");
        voiceBeansList4.add(voiceBean47);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.stop();
        mp.release();
        mp = null;
    }
}
