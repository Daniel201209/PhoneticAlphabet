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
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.phoneticalphabet.R;
import com.phoneticalphabet.adapter.HomeRecyclerView;
import com.phoneticalphabet.bean.VoiceBean;
import com.phoneticalphabet.view.HomeLayoutManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private RecyclerView recyclerView_1;
    private RecyclerView recyclerView_2;
    private RecyclerView recyclerView_3;
    private RecyclerView recyclerView_4;
    private List<VoiceBean> voiceBeansList1 = null;
    private List<VoiceBean> voiceBeansList2 = null;
    private List<VoiceBean> voiceBeansList3 = null;
    private List<VoiceBean> voiceBeansList4 = null;

    private TextView contentYB;

    private boolean isPlaying = true;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    private void initView() {
        contentYB = findViewById(R.id.contentYB);

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
                    contentYB.setText(voiceBeansList1.get(postion).getContext());
                    if (isPlaying) {
                        isPlaying = false;
                        AssetFileDescriptor fd = getAssets().openFd(String.valueOf(voiceBeansList1.get(postion).getVoicePath()));
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(fd);
                        mediaPlayer.setOnPreparedListener(MainActivity.this);
                        mediaPlayer.setOnCompletionListener(MainActivity.this);
                        mediaPlayer.prepareAsync();
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
                    contentYB.setText(voiceBeansList2.get(postion).getContext());
//MediaPlayer mediaPlayer = new MediaPlayer();
                    if (isPlaying) {
                        isPlaying = false;
                        AssetFileDescriptor fd = getAssets().openFd(String.valueOf(voiceBeansList2.get(postion).getVoicePath()));
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(fd);
                        mediaPlayer.setOnPreparedListener(MainActivity.this);
                        mediaPlayer.setOnCompletionListener(MainActivity.this);
                        mediaPlayer.prepareAsync();
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
                    contentYB.setText(voiceBeansList3.get(postion).getContext());
//MediaPlayer mediaPlayer = new MediaPlayer();
                    if (isPlaying) {
                        isPlaying = false;
                        AssetFileDescriptor fd = getAssets().openFd(String.valueOf(voiceBeansList3.get(postion).getVoicePath()));
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(fd);
                        mediaPlayer.setOnPreparedListener(MainActivity.this);
                        mediaPlayer.setOnCompletionListener(MainActivity.this);
                        mediaPlayer.prepareAsync();
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
                    contentYB.setText(voiceBeansList4.get(postion).getContext());
//MediaPlayer mediaPlayer = new MediaPlayer();
                    if (isPlaying) {
                        isPlaying = false;
                        AssetFileDescriptor fd = getAssets().openFd(String.valueOf(voiceBeansList4.get(postion).getVoicePath()));
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(fd);
                        mediaPlayer.setOnPreparedListener(MainActivity.this);
                        mediaPlayer.setOnCompletionListener(MainActivity.this);
                        mediaPlayer.prepareAsync();
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
////添加自定义分割线
//DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
//divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.custom_divider));
//recyclerView.addItemDecoration(divider);

    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.stop();
        isPlaying = true;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    private void initData() {
//https://i.xiao84.com/en-yinbiao/mp3/48yinbiaomp3/o-sound.mp3
        voiceBeansList1 = new ArrayList<>();
        VoiceBean voiceBean1 = new VoiceBean();
        voiceBean1.setName("ɪ");
        voiceBean1.setContext("1、嘴微微张开，嘴唇放松，上齿和下齿之间约一个小指尖距离。\n" + "2、舌尖抵下齿，舌硬腭抬起，舌位稍低，稍后，舌头肌肉松弛。\n" + "3、嘴唇向两旁伸开，声带震动发出声音\n" + "\n" + "注意：/ɪ/与长元音/iː/的区别。");
        voiceBean1.setVoicePath("i-sound.mp3");
        voiceBeansList1.add(voiceBean1);
        VoiceBean voiceBean2 = new VoiceBean();
        voiceBean2.setName("i:");
        voiceBean2.setContext("1、张开你的嘴巴，好像你在微笑，露出你的牙齿，嘴唇向两边伸开，成扁平形。\n" + "2、将舌前部向硬腭尽量抬起。舌头轻微接触下齿背部。\n" + "3、嘴唇绷紧，舌头肌肉保持紧张，震动声带，发出/iː/音。\n" + "\n" + "注意：/iː/个长元音，发音的时候要尽量拉长。");
        voiceBean2.setVoicePath("i-sound2.mp3");
        voiceBeansList1.add(voiceBean2);
        VoiceBean voiceBean3 = new VoiceBean();
        voiceBean3.setName("e");
        voiceBean3.setContext("1、嘴唇向两侧微微分开，上下齿之间大约可容纳一个小指头尖的距离。\n" + "2、舌前部在发音过程中抬起，舌尖稍微接触下齿背。\n" + "3、发音时下巴逐渐向下移动，震动声带，发出/e/音。\n" + "\n" + "注意：/e/个短元音，注意与/ɜː/、/ə/的区别。");
        voiceBean3.setVoicePath("e-sound.mp3");
        voiceBeansList1.add(voiceBean3);
        VoiceBean voiceBean4 = new VoiceBean();
        voiceBean4.setName("æ");
        voiceBean4.setContext("1、嘴唇向两侧尽量分开，嘴巴张开较大，上下齿之间大约可容纳两个手指的宽度。\n" + "2、舌前部在发音过程中抬起，舌尖稍微接触下齿背。\n" + "3、发音时逐渐压低舌头和下颚，尽可能夸张，震动声带，发出/æ/音。\n" + "\n" + 
                "注意：/æ/个短元音，但在实际发音中有一定的长度。 要注意与/e/的区别");
        voiceBean4.setVoicePath("an-sound.mp3");
        voiceBeansList1.add(voiceBean4);
        VoiceBean voiceBean5 = new VoiceBean();
        voiceBean5.setName("ʌ");
        voiceBean5.setContext("1、嘴巴张开一半左百，牙齿分开，下嘴唇略向下。\n" + "2、舌中部向硬颚抬起，不要接触到硬颚，舌尖和舌端两侧贴在下。\n" + "3、双唇向两边平展形成扁平状，震动声带，短促有力推出气流发出/ʌ/音。\n" + "\n" + 
                "注意：/ʌ/个短元音，要诀是发音时收小腹，注意与/æ/的区别。");
        voiceBean5.setVoicePath("^-sound.mp3");
        voiceBeansList1.add(voiceBean5);
        VoiceBean voiceBean6 = new VoiceBean();
        voiceBean6.setName("ɑː");
        voiceBean6.setContext("1、嘴巴放松张大，上下牙齿全部张开，双唇呈圆形。\n" + "2、舌身后缩，舌尖离开下齿，舌后部稍抬高。\n" + "3、震动声带，推出气流发出/ɑː/音。像说：\"啊\"\n" + "\n" + "注意：/ɑː/是个长元音，发音要稍长一些。");
        voiceBean6.setVoicePath("a-sound2.mp3");
        voiceBeansList1.add(voiceBean6);
        VoiceBean voiceBean7 = new VoiceBean();
        voiceBean7.setName("ə");
        voiceBean7.setContext("1、嘴微微张开，嘴唇放松，舌身平放。\n" + "2、舌中部伸向硬颚，不要与之接触。\n" + "3、口部肌肉和舌头放松，震动声带，气流向外发出/ə/音。\n" + "\n" + "注意：/ə/是中央、不圆唇、非重读元音。");
        voiceBean7.setVoicePath("e^-sound.mp3");
        voiceBeansList1.add(voiceBean7);
        VoiceBean voiceBean8 = new VoiceBean();
        voiceBean8.setName("ɜː");
        voiceBean8.setContext("1、半张开嘴巴，双唇略扁平，向嘴角两边略拉开。\n" + "2、舌身平放，舌中部伸向硬颚，但不要接触到硬颚，舌部肌肉紧张。\n" + "3、震动声带，发出/ɜː/音。\n" + "\n" + 
                "注意：/ɜː/个长元音，这个音听起来和汉语的\"饿\"相似，要注意的是在美国英语中该音后常常加上一个r的音，类似北京方言的儿发音。");
        voiceBean8.setVoicePath("er-sound.mp3");
        voiceBeansList1.add(voiceBean8);
        VoiceBean voiceBean9 = new VoiceBean();
        voiceBean9.setName("ɒ");
        voiceBean9.setContext("1、将嘴张大，上下齿分开。\n" + "2、舌身降低后缩，双唇稍稍收圆。\n" + "3、震动声带，短促有力的发出/ɒ/音。\n" + "\n" + "注意：/ɒ/发音特点是低舌位、后舌位、圆唇。");
        voiceBean9.setVoicePath("o-sound.mp3");
        voiceBeansList1.add(voiceBean9);
        VoiceBean voiceBean10 = new VoiceBean();
        voiceBean10.setName("ɔː");
        voiceBean10.setContext("1、张开嘴双唇收圆，并向前突出。\n" + "2、舌身低平后缩，舌后部抬起。\n" + "3、震动声带，发出/ɔː/音。\n" + "\n" + "注意：/ɔː/是个长元音，发音要稍长一些。");
        voiceBean10.setVoicePath("o-sound2.mp3");
        voiceBeansList1.add(voiceBean10);
        VoiceBean voiceBean11 = new VoiceBean();
        voiceBean11.setName("ʊ");
        voiceBean11.setContext("1、双唇收圆，稍稍向外突出，嘴形小而圆，嘴角肌肉放松。\n" + "2、舍身后缩，舌尖离开下齿。\n" + "3、舌后部向软颚抬起，震动声带，短促有力发出/ʊ/音。\n" + "\n" + "注意：/ʊ/个短元音，要诀是发音时收小腹，牙床半合，短促有力。");
        voiceBean11.setVoicePath("u-sound.mp3");
        voiceBeansList1.add(voiceBean11);
        VoiceBean voiceBean12 = new VoiceBean();
        voiceBean12.setName("uː");
        voiceBean12.setContext("1、双唇收圆而且小，并向前突出，牙齿接近闭合。\n" + "2、舌身后缩，舌尖离开下齿，舌后部向软颚抬起，但不要接触到软颚。\n" + "3、嘴部肌肉是收紧，震动声带，发出/uː/音。\n" + "\n" + "注意：/uː/是个长元音，发音要稍长一些。");
        voiceBean12.setVoicePath("u-sound2.mp3");
        voiceBeansList1.add(voiceBean12);
//============================================================
//eɪ aɪ ɔɪ aʊ əʊ	ɪə eə ʊə
        voiceBeansList2 = new ArrayList<>();
        VoiceBean voiceBean13 = new VoiceBean();
        voiceBean13.setName("eɪ");
        voiceBean13.setContext("1、学习该音发音方法请先学习/e/和/ɪ/这两个单元音。\n" + "2、嘴巴张开成半圆形，开始发/e/音。\n" + "3、然后颚部慢慢抬起滑向/ɪ/音，嘴唇慢慢合上。\n" + "\n" + 
                "注意：/eɪ/是个\"合口双元音\"，即牙床由半开到接近半合，由大到小。发音时音量从强到弱，前长后短，前重后轻。");
        voiceBean13.setVoicePath("ei.mp3");
        voiceBeansList2.add(voiceBean13);
        VoiceBean voiceBean14 = new VoiceBean();
        voiceBean14.setName("aɪ");
        voiceBean14.setContext("1、学习该音发音方法请先学习/ɑː/和/ɪ/这两个单元音。\n" + "2、双唇张开，开始发/ɑː/音。\n" + "3、舌部肌肉放松，然后颚部慢慢抬起滑向/ɪ/音，嘴唇慢慢合上。\n" + "\n" + 
                "注意：/aɪ/是个\"开合双元音\"，即牙床由半开到接近半合，口形由大到小。发音时舌位由低到高，音量由强到弱，由长到短，由清晰到含糊。");
        voiceBean14.setVoicePath("ai.mp3");
        voiceBeansList2.add(voiceBean14);
        VoiceBean voiceBean15 = new VoiceBean();
        voiceBean15.setName("ɔɪ");
        voiceBean15.setContext("1、学习该音发音方法请先学习/ɔː/和/ɪ/这两个单元音。\n" + "2、发音时下颌张开，嘴唇略呈圆形，稍稍向外突出。\n" + "3、舌前部收缩，舌后部向软颚抬起，但不要接触到软颚。\n" + 
                "4、舌身放松前探，舌尖轻触下齿，舌前部微微抬起。整个过程就是从/ɔː/音慢慢滑向/ɪ/。\n" + "\n" + "注意：/ɔɪ/是个\"开合双元音\"，即牙床由半开到接近半合，口形由稍大而圆变为小而扁。发音时舌位由低到高，由舌后部抬高滑向舌前部抬高，音量由强到弱，由长到短，由清晰到含糊。");
        voiceBean15.setVoicePath("oi.mp3");
        voiceBeansList2.add(voiceBean15);
        VoiceBean voiceBean16 = new VoiceBean();
        voiceBean16.setName("aʊ");
        voiceBean16.setContext("1、学习该音发音方法请先学习/ɑː/和/ʊ/这两个单元音。\n" + "2、嘴巴放松张大，嘴唇向两侧分开。舌身放平，舌尖轻抵下齿，发/ɑː/。\n" + "3、然后嘴巴收圆合拢。舌尖离开下齿，舌身后缩，舌后部身软颚抬起，发音慢慢滑向[ʊ]。\n" + "\n" + 
                "注意：/aʊ/是个\"开合双元音\"，发音时口形由大变为小。音量由强到弱，由长到短，由清晰到含糊。");
        voiceBean16.setVoicePath("ao.mp3");
        voiceBeansList2.add(voiceBean16);
        VoiceBean voiceBean17 = new VoiceBean();
        voiceBean17.setName("əʊ");
        voiceBean17.setContext("1、学习该音发音方法请先学习/ə/和/ʊ/这两个单元音。\n" + "2、首先嘴型呈半圆并稍向前突出，舌后部向软颚抬起，不要与之接触,发出/ə/。\n" + "3、然后很快的滑向/ʊ/音，发音结束时，颚部慢慢抬起，嘴唇慢慢合上。\n" + "\n" + 
                "注意：/əʊ/是个\"开合双元音\"，发音时口型由略微呈圆形较大到收圆缩小，音量由强到弱，该音是字母\"o\"的读音。");
        voiceBean17.setVoicePath("eu.mp3");
        voiceBeansList2.add(voiceBean17);
        VoiceBean voiceBean18 = new VoiceBean();
        voiceBean18.setName("ɪə");
        voiceBean18.setContext("1、学习该音发音方法请先学习/ɪ/和/ə/这两个单元音。\n" + "2、首先短发/ɪ/的音，嘴唇扁平，嘴不要张得太大。\n" + "3、然后很快的滑向/ə/音，发音过程中口型始终是半开的。\n" + "\n" + 
                "注意：/ɪə/是个\"集中双元音\"，发音时口型由小到大，从合到开。前一个成分要短一些，模糊一点，而后一个成分要长一些，清晰一点。英式音标中/ə/要扁平，没有卷舌音。美式音标/r/要卷舌。");
        voiceBean18.setVoicePath("ir.mp3");
        voiceBeansList2.add(voiceBean18);
        VoiceBean voiceBean19 = new VoiceBean();
        voiceBean19.setName("ʊə");
        voiceBean19.setContext("1、学习该音的发音方法请先学习/ʊ/和/ə/这两个单元音。\n" + "2、首先/ʊ/的音，然后慢慢滑向/ə/的音就可以了。\n" + "3、口型由收圆变化为最后半开。\n" + "\n" + 
                "注意：/ʊə/是个\"集中双元音\"，发音时前长后短，前强后弱，音式发音发/ə/部分不卷舌，美式发音卷舌。");
        voiceBean19.setVoicePath("uer.mp3");
        voiceBeansList2.add(voiceBean19);
        VoiceBean voiceBean20 = new VoiceBean();
        voiceBean20.setName("eə");
        voiceBean20.setContext("1、学习该音的发音方法请先学习/e/和/ə/这两个单元音。\n" + "2、首先先发前元音/e/，同时舌尖轻触下齿。\n" + "3、然后很快滑向/ə/音，发音过程中双唇半开。\n" + "\n" + 
                "注意：/eə/是个\"集中双元音\"，发音/e/时嘴角向两边拉，滑向/ə/音收小，口型由大变小。");
        voiceBean20.setVoicePath("er.mp3");
        voiceBeansList2.add(voiceBean20);
        //============================================================
        //p t k b d ɡ f s ʃ θ h v z
        voiceBeansList3 = new ArrayList<>();
        VoiceBean voiceBean = new VoiceBean();
        voiceBean.setName("p");
        voiceBean.setContext("1、首先紧闭双唇，阻止气流流出。\n" + "2、突然分开双唇，气流冲出口腔，气流受嘴唇阻碍被爆破产生气流声。\n" + "\n" + "注意：/p/是个清辅音，声带不震动，产生的声音不是声带而是气流，要注意与/b/的区别。");
        voiceBean.setVoicePath("p.mp3");
        voiceBeansList3.add(voiceBean);
        VoiceBean voiceBean21 = new VoiceBean();
        voiceBean21.setName("k");
        voiceBean21.setContext("1、首先舌后部隆起，紧贴上颚软腭，憋住气,使气流通道完全阻塞。\n" + "2、嘴巴张开,舌后部迅速降低,抵住软颚的舌离开软颚，气流突然冲出口腔。\n" + "\n" + "注意：/k/是个清辅音，声带不震动，产生的声音不是声带而是气流，要注意与/g/的区别。");
        voiceBean21.setVoicePath("k.mp3");
        voiceBeansList3.add(voiceBean21);
        VoiceBean voiceBean22 = new VoiceBean();
        voiceBean22.setName("t");
        voiceBean22.setContext("1、/t/是爆破音，嘴巴微微张开，舌尖先紧贴上齿龈，憋住气。\n" + "2、舌尖迅速下降，使气流冲出口腔，形成爆破音。\n" + "3、/t/是清辅音，声带不震动，只能听到气流的声音。\n" + "\n" +
                "纠错：不要用汉语拼音中的\"t（特、\"来代替这个发音。在词尾出现时，千万不要加上一个弱读的元音/ə/！这是中国人最容易犯的错误之一！");
        voiceBean22.setVoicePath("t.mp3");
        voiceBeansList3.add(voiceBean22);
        VoiceBean voiceBean23 = new VoiceBean();
        voiceBean23.setName("f");
        voiceBean23.setContext("1、上齿轻轻接触在下唇上。\n" + "2、把口腔中的空气透过唇齿间的缝隙，挤压出来引起气流和牙齿摩擦。\n" + "\n" + "注意：/k/是个清辅音，声带不震动，产生的声音不是声带而是气流，要注意与浊辅音/v/的区别。");
        voiceBean23.setVoicePath("f.mp3");
        voiceBeansList3.add(voiceBean23);
        VoiceBean voiceBean24 = new VoiceBean();
        voiceBean24.setName("s");
        voiceBean24.setContext("1、上下齿自然合拢，嘴唇张开不要太大。\n" + "2、将舌前端抬起，靠近齿龈，但不要贴住，将气流所通过的气流通道收窄。\n" + "2、将口腔的空气形成气流由舌端与齿龈之间的窄缝中泄出，伴有嘶嘶声。\n" + "\n" + "注意：/s/是个清辅音，声带不震动。要注意与/ð/," +
                "" + "/θ/,/z/的区别。");
        voiceBean24.setVoicePath("s.mp3");
        voiceBeansList3.add(voiceBean24);
        VoiceBean voiceBean25 = new VoiceBean();
        voiceBean25.setName("θ");
        voiceBean25.setContext("1、舌尖微微伸出，置于上下门齿之间，舌身成扁平。\n" + "2、气流由舌齿间泻出，摩擦成音，舌尖和下齿之间的气流通道非常窄小，气流从舌齿间的窄缝中泄出。\n" + "\n" + "注意：/θ/是个清辅音，声带不震动。要注意与/ð/,/s/," +
                "/z/的区别，发这个音主要是舌尖与上齿之间的摩擦，所以千万不要紧紧咬住舌尖，应该是上齿轻触舌尖。");
        voiceBean25.setVoicePath("si.mp3");
        voiceBeansList3.add(voiceBean25);
        VoiceBean voiceBean26 = new VoiceBean();
        voiceBean26.setName("ʃ");
        voiceBean26.setContext("1、上下齿自然合拢，嘴唇张开不要太大，稍微收圆。\n" + "2、舌端抬起，靠近齿龈后部，但不要贴住。\n" + "3、舌身抬起，靠近上腭，形成一条狭长的通道。气流通过通道时摩擦成音。\n" + "\n" +
                "注意：/∫/是个清辅音，声带不震动。/ʃ/和汉语中的声母sh很相近，但要注意的是/ʃ/不卷舌，是个平舌音。");
        voiceBean26.setVoicePath("ss.mp3");
        voiceBeansList3.add(voiceBean26);
        VoiceBean voiceBean27 = new VoiceBean();
        voiceBean27.setName("h");
        voiceBean27.setContext("1、张开嘴巴，让气流自由逸出口腔，不受阻碍。\n" + "2、只在通过声门时形成轻微的摩擦，舌头和嘴唇的位置随其后的元音而变化。\n" + "3、发音时，声带不震动。\n" + "\n" +
                "注意：/h/是个清辅音，声音不震动，送气很大，可以拿一张白纸放在嘴前，感受一下气流。不要发成汉语中的\"喝\"。");
        voiceBean27.setVoicePath("h.mp3");
        voiceBeansList3.add(voiceBean27);
        VoiceBean voiceBean28 = new VoiceBean();
        voiceBean28.setName("tʃ");
        voiceBean28.setContext("1、双唇微张向前突出，略成圆形。\n" + "2、舌尖和舌端抬起贴住上齿龈后部，憋住气。\n" + "3、然后舌尖稍稍下降，气流从舌和齿龈间的狭缝中冲出，摩擦成音。\n" + "\n" +
                "注意：/t∫/是个清辅音，声带不震动。/tʃ/这个音和汉语拼音中的声母ch很相近，很多北方同学会用\"吃\"代替/tʃ/是不正确的，一些南方同学会把/tʃ/和汉语拼音中的声母q混淆，也是极不正确的，应注意区分它们的异同。");
        voiceBean28.setVoicePath("tss.mp3");
        voiceBeansList3.add(voiceBean28);
        VoiceBean voiceBean29 = new VoiceBean();
        voiceBean29.setName("ts");
        voiceBean29.setContext("1、上下齿自然合拢，嘴唇张开不要太大。\n" + "2、舌端贴住齿龈，堵住气流。\n" + "2、然后舌尖略微下降，气流随之泄出。\n" + "\n" + "注意：/ts/是个清辅音，声带不震动。/ts/,/dz/,/dr/," +
                "/tr/是传统的音标符号，新课本中美式、英式读音都没将其包括在内。");
        voiceBean29.setVoicePath("ts.mp3");
        voiceBeansList3.add(voiceBean29);
        VoiceBean voiceBean30 = new VoiceBean();
        voiceBean30.setName("tr");
        voiceBean30.setContext("1、上下齿自然合拢，嘴唇张开不要太大。\n" + "2、舌端贴住齿龈，堵住气流。\n" + "2、然后舌尖略微下降，气流随之泄出。\n" + "\n" + "注意：/tr/是个清辅音，声带不震动。/ts/,/dz/,/dr/," +
                "/tr/是传统的音标符号，新课本中美式、英式读音都没将其包括在内。");
        voiceBean30.setVoicePath("tr.mp3");
        voiceBeansList3.add(voiceBean30);
//============================================================
//p t k b d ɡ f s ʃ θ h v z ʒ ð tʃ tr ts dʒ dr dz	m n ŋ	l r j w
        voiceBeansList4 = new ArrayList<>();
        VoiceBean voiceBean31 = new VoiceBean();
        voiceBean31.setName("b");
        voiceBean31.setContext("1、首先紧闭双唇，憋住气。\n" + "2、舌头平放，突然分开双唇，牙齿会随双唇运动，气流冲出口腔同时发出爆破的音。\n" + "3、声音由声带震动发出，送气力量较弱。\n" + "\n" + "注意：/b/是个浊辅音，声带震动发声。一些学生会用声带不震动的轻辅音p来代替b,"
                + "或在b的面添加元音ə把单音节变成双音节，例如把cab /kæb/错发成/kæbə/、/kæp/，这些问题应在平时练习多加注意。");
        voiceBean31.setVoicePath("b.mp3");
        voiceBeansList4.add(voiceBean31);
        VoiceBean voiceBean32 = new VoiceBean();
        voiceBean32.setName("ɡ");
        voiceBean32.setContext("1、嘴巴张开,将舌后部隆起，紧贴软腭，憋住气。\n" + "2、然后舌后部迅速降低，使气流冲出口腔。\n" + "3、同时声带震动发出声音，送气力量较弱。\n" + "\n" + "注意：/g/是个浊辅音，声带震动发声。注意不要用汉语拼音中的\"g（哥、\"来代替," +
                "汉语拼音的g是口腔发音，音标是声带震动发音。");
        voiceBean32.setVoicePath("g.mp3");
        voiceBeansList4.add(voiceBean32);
        VoiceBean voiceBean33 = new VoiceBean();
        voiceBean33.setName("d");
        voiceBean33.setContext("1、嘴巴张开,舌尖紧贴上齿龈，憋住气。\n" + "2、舌尖迅速下降，使气流冲出口腔。\n" + "3、同时声带震动发出声音，送气力量较弱。\n" + "\n" +
                "注意：/d/是个浊辅音，声带震动发声。注意与轻辅音/t/的区别。不要用汉语拼音中的\"d（的、\"来代替，英语发声比较靠后，是由声带震动发声。");
        voiceBean33.setVoicePath("d.mp3");
        voiceBeansList4.add(voiceBean33);
        VoiceBean voiceBean34 = new VoiceBean();
        voiceBean34.setName("v");
        voiceBean34.setContext("1、上齿轻触下嘴唇，发音和/f/口型基本相同。\n" + "2、气流从口腔通过唇齿间的缝隙，引起摩擦。\n" + "3、同时声带震动发出声音，送气力量较弱。\n" + "\n" +
                "注意：/v/是个浊辅音，声带震动发声。要注意上齿与下唇的咬合，气流通过唇齿间，不要发成/w/的音。不要把love /lʌv/错发成lʌw/。只要发/v/养成咬唇的习惯，就可以发好该音。");
        voiceBean34.setVoicePath("v.mp3");
        voiceBeansList4.add(voiceBean34);
        VoiceBean voiceBean35 = new VoiceBean();
        voiceBean35.setName("z");
        voiceBean35.setContext("1、微微张开嘴巴，口形不要张得太大，上下齿自然合拢。\n" + "2、舌端抬起，靠近齿龈，但不要贴住。\n" + "3、气流由舌端与齿龈之间的窄缝中泄出，空气泄出时伴有嘶嘶声，同时声带震动发音。\n" + "\n" +
                "注意：/dz/是个浊辅音，要振动声带发音，气流较强。注意用汉语的\"资\"来代替/z/的发音是不正确的。");
        voiceBean35.setVoicePath("z.mp3");
        voiceBeansList4.add(voiceBean35);
        VoiceBean voiceBean36 = new VoiceBean();
        voiceBean36.setName("ð");
        voiceBean36.setContext("1、首先将舌尖微微伸出略微露出齿外，置于上下门齿之间，舌身成扁平。\n" + "2、气流从舌齿间的窄缝中泄出，同时声带震动发出/ð/这个音。\n" + "\n" +
                "注意：/ð/是舌齿、浊辅音，舌尖和下齿之间的气流通道非常窄小。发这个音主要是舌尖与上齿之间的摩擦，所以千万不要紧紧咬住舌尖，只要轻轻咬一咬就行了！");
        voiceBean36.setVoicePath("qq.mp3");
        voiceBeansList4.add(voiceBean36);
        VoiceBean voiceBean37 = new VoiceBean();
        voiceBean37.setName("ʒ");
        voiceBean37.setContext("1、双唇略微向前突出，略成长方形。\n" + "2、将舌端抬起，靠近齿龈后部，但不要贴住。\n" + "3、舌身抬起，靠近上腭，形成狭长的通道，气流通过通道时摩擦，同时声带震动发声。\n" + "\n" +
                "注意：/ʒ/是个浊辅音，发音时只有微弱气流泻出，这是一个较难发准的音，要注意声带的震动。");
        voiceBean37.setVoicePath("n3.mp3");
        voiceBeansList4.add(voiceBean37);
        VoiceBean voiceBean38 = new VoiceBean();
        voiceBean38.setName("r");
        voiceBean38.setContext("1、双唇略张开并收圆，稍突出。\n" + "2、舌尖卷起，靠近上齿龈后部,舌两侧贴住上齿龈两侧。\n" + "3、气流通过舌端及上齿龈后背部形成轻微的摩擦，同时震动声带发出/r/音。\n" + "\n" +
                "注意：/r/是个浊辅音，声音是由声带震动发出，有些学生会把汉语中的声母r的发音来代替/r/的发音，于是把rose读成\"肉丝\"，把road读成\"肉的\"，但实际上两者有很大的差别。");
        voiceBean38.setVoicePath("r.mp3");
        voiceBeansList4.add(voiceBean38);
        VoiceBean voiceBean39 = new VoiceBean();
        voiceBean39.setName("dʒ");
        voiceBean39.setContext("1、双唇向前突出，略成圆形，牙齿基本闭合。\n" + "2、舌尖和舌端抬起贴住上齿龈后部，憋住气。\n" + "3、舌尖稍稍下降，气流从舌和齿龈间的狭缝冲出，同时声带震动发声。\n" + "\n" +
                "注意：/dʒ/是个浊辅音，发音时只有微弱气流泻出，摩擦在舌端，声音是由声音震动发出。不要读在汉语中的“基”，“基”字发音舌位靠前，而/dʒ/是用舌尖去顶齿龈，整体舌位不靠前。");
        voiceBean39.setVoicePath("d3.mp3");
        voiceBeansList4.add(voiceBean39);
        VoiceBean voiceBean40 = new VoiceBean();
        voiceBean40.setName("dz");
        voiceBean40.setContext("1、舌端贴住齿龈，堵住气流。\n" + "2、舌尖略微下降，气流随之泄出形成先破擦，同时声带震动发出/dz/音。\n" + "\n" + "注意：/dz/是个浊辅音，发音时声带震动。/dz/有点类似于汉语中的\"子\"（轻音、，但发音时有爆破的感觉，而且声带振动较强。");
        voiceBean40.setVoicePath("dz.mp3");
        voiceBeansList4.add(voiceBean40);
        VoiceBean voiceBean41 = new VoiceBean();
        voiceBean41.setName("dr");
        voiceBean41.setContext("1、双唇稍稍突出，略成圆形\n" + "2、舌身保持发/r/的姿势，舌尖贴在齿龈后部，堵住气流。\n" + "3、舌头放开，让气流从舌尖和齿龈间冲出，冲破阻碍发出短促的/d/后立即发/r/。\n" + "\n" +
                "注意：/dr/是个浊辅音，发音时声带震动。有些学生分不清/dr/和/dʒ/的区别，其实发/dʒ/时嘴唇需收圆，同时舌头闭气的部位也比/dʒ/靠前。也有人容易把这个音念成汉语中的\"朱\"，要注意不要在这个音的后面加上元音/u/。/ts/,/dz/,/dr/," +
                "/tr/是传统的音标符号，新课本中美式、英式读音都没将其包括在内。");
        voiceBean41.setVoicePath("dr.mp3");
        voiceBeansList4.add(voiceBean41);
        VoiceBean voiceBean42 = new VoiceBean();
        voiceBean42.setName("m");
        voiceBean42.setContext("1、这个音发音很简音，首先双唇闭拢，舌头自然放平，软颚下垂。\n" + "2、气流从鼻腔泻出，同时振动声带。\n" + "\n" + "注意：/m/是个鼻音、浊辅音，发音时一定是闭拢双唇。发音时会感觉到嘴唇也会一起振动。");
        voiceBean42.setVoicePath("m.mp3");
        voiceBeansList4.add(voiceBean42);
        VoiceBean voiceBean43 = new VoiceBean();
        voiceBean43.setName("n");
        voiceBean43.setContext("1、微微张开嘴巴，舌尖紧贴上齿龈，形成阻碍。\n" + "2、气流从鼻腔泄出，同时声带震动发出声音。\n" + "\n" + "注意：/n/是个鼻音、浊辅音，依靠声音震动发声，当/n/出现在音节结尾处时要略微延长，以防止吞没末尾的/n/,把ten " +
                "/ten/错发成/te/是不正确的。/n/和/m/是同一组浊辅音，所不同的是/m/是\"闭嘴音\"，而/n/是\"开口音\"。");
        voiceBean43.setVoicePath("n.mp3");
        voiceBeansList4.add(voiceBean43);
        VoiceBean voiceBean44 = new VoiceBean();
        voiceBean44.setName("ŋ");
        voiceBean44.setContext("1、嘴唇张开，舌后部抬起贴住软腭，阻止气流从口腔泄出。\n" + "2、软腭下垂，气流从鼻腔泄出，同时震动声带发音。\n" + "\n" +
                "注意：/ŋ/是个浊辅音，声音震动。很多人会把/ŋ/发成/n/，/ŋ/和我们汉语拼音中的ng音非常相似，它和音标/n/的关系就像汉语拼音中an-ang,en-eng,in-ing的关系。");
        voiceBean44.setVoicePath("ng.mp3");
        voiceBeansList4.add(voiceBean44);
        VoiceBean voiceBean45 = new VoiceBean();
        voiceBean45.setName("w");
        voiceBean45.setContext("1、双唇收得很圆很小，嘴唇张开到刚好可以含住一根吸管的程度，并向前突出，上下齿分开贴住嘴唇。\n" + "2、舌后部向软腭抬起，但不要抵住。\n" + "3、气流从双唇间摩擦而过，同时声带需震动，发音短促，立刻向后面的元音滑动。\n" + "\n" +
                "注意：/w/是个半元音，和元音/uː/很相似，但元音可以单独成音可以延长，半元音不能单独成音，不可以延长，更不能在它后面附加元音。");
        voiceBean45.setVoicePath("w.mp3");
        voiceBeansList4.add(voiceBean45);
        VoiceBean voiceBean46 = new VoiceBean();
        voiceBean46.setName("j");
        voiceBean46.setContext("1、双唇向两旁伸展成扁平形。\n" + "2、舌前部向硬腭尽量抬起，不要抵住硬腭。\n" + "3、气流从舌和硬腭的缝隙间通过，同时声带需震动，发音短促，立刻向后面的元音滑动。\n" + "\n" +
                "注意：/j/是个半元音，发音时口型和元音/iː/有点相似，但它仍是个辅音，元音可以单独成音可以延长，半元音不可以单独成音不可以延长。");
        voiceBean46.setVoicePath("j.mp3");
        voiceBeansList4.add(voiceBean46);
        VoiceBean voiceBean47 = new VoiceBean();
        voiceBean47.setName("l");
        voiceBean47.setContext("1、双唇略张开，牙齿自然张开。\n" + "2、舌尖紧贴上齿龈，舌前部抬起靠近硬腭。\n" + "3、气流从舌的两侧泄出，声带震动发音。\n" + "\n" +
                "/l/发音有两种情况，根据它所出现的位置不同发出两种不太完全一样的音。/l/+其它音节、/l/+元音、/l/+/j/称它为清晰/l/，发清晰/l/音时，在下一个音即将出出时舌头离开上齿龈，迅速下落；当其它音节+/l/或/l/+辅音时舌头不需要下落，称它为含糊音。\n" + "\n" + 
                "注意：/l/是个浊辅音，声音是由声带震动发出。这个音有一定的长度，和元音一样可以延长。另外要注意清晰音和含糊音两种情况的区别。");
        voiceBean47.setVoicePath("l.mp3");
        voiceBeansList4.add(voiceBean47);
    }

}
