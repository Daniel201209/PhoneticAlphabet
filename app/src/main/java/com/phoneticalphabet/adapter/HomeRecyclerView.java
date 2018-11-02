package com.phoneticalphabet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phoneticalphabet.R;
import com.phoneticalphabet.bean.VoiceBean;

import java.util.List;

/**
 * 首页定制适配器
 */
public class HomeRecyclerView extends RecyclerView.Adapter {

    private Context context = null;
    /**
     * 定制商品数据集
     */
    private List<VoiceBean> voiceBeans = null;

    private final static int HEAD_COUNT = 1;
    private final static int FOOT_COUNT = 1;

    private final static int TYPE_HEAD = 0;
    private final static int TYPE_CONTENT = 1;
    private final static int TYPE_FOOTER = 2;

    /**
     * 点击回调事件
     */
    private OnItemClickListener mClickListener;

    public int getContentSize() {
        return voiceBeans.size();
    }

    public boolean isHead(int position) {
        return HEAD_COUNT != 0 && position == 0;
    }

    public boolean isFoot(int position) {
        return FOOT_COUNT != 0 && position == getContentSize();
//        return FOOT_COUNT != 0 && position == getContentSize() + HEAD_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        int contentSize = getContentSize();
       if (FOOT_COUNT != 0 && position == contentSize) { // 尾部
            return TYPE_FOOTER;
        } else {
            return TYPE_CONTENT;
        }
    }


    public HomeRecyclerView(List<VoiceBean> voiceBeans) {
        super();
        this.voiceBeans = voiceBeans;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mClickListener = listener;
    }

        @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            context = viewGroup.getContext();
//        if (i == TYPE_CONTENT) {
            View view = LayoutInflater.from(context).inflate(R.layout.dz_itme, null);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(lp);
            return new H(view, mClickListener);
//        } else {
//            View footView = LayoutInflater.from(context).inflate(R.layout.dz_itme_foot, null);
//            return new FootH(footView, mClickListener);
//        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        if(getItemViewType(i) == TYPE_CONTENT){ // 内容
            H h = (H) holder;

            h.voiceText.setText(voiceBeans.get(i).getName());
        }else{ // 尾部
//            FootH fH = (FootH) holder;
        }
    }

    @Override
    public int getItemCount() {
        return voiceBeans.size() + FOOT_COUNT;
    }

    class H extends RecyclerView.ViewHolder implements View.OnClickListener{


        private TextView voiceText;
        private OnItemClickListener mListener;// 声明自定义的接口

        public H(View itemView, OnItemClickListener listener) {
            super(itemView);
            mListener = listener;
            voiceText = itemView.findViewById(R.id.voiceText);
            voiceText.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // getAdapterPosition()为Viewholder自带的一个方法，用来获取RecyclerView当前的位置，将此作为参数，传出去
            mListener.onItemClick(view, getAdapterPosition());
        }
    }
//    class FootH extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        private LinearLayout moreLinear;
//
//        private OnItemClickListener mListener;// 声明自定义的接口
//
//        public FootH(View itemView, OnItemClickListener listener) {
//            super(itemView);
//            mListener = listener;
//            moreLinear = itemView.findViewById(R.id.moreLinear);
//            moreLinear.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            // getAdapterPosition()为Viewholder自带的一个方法，用来获取RecyclerView当前的位置，将此作为参数，传出去
//            mListener.onItemClick(view, getAdapterPosition());
//        }
//    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int postion);
    }

}
