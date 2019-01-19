package com.example.administrator.thirdyuekaotest.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.thirdyuekaotest.R;
import com.example.administrator.thirdyuekaotest.data.bean.DetailBean;

import java.util.List;

public class GoodsAdapter extends BaseQuickAdapter<DetailBean.DataBean.ListBean, BaseViewHolder> {
    public GoodsAdapter(int layoutResId, @Nullable List<DetailBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailBean.DataBean.ListBean item) {
        helper.setText(R.id.tv_goods_title, item.getName());
        //Glide加载显示图片
        ImageView iv_goods_icon = helper.getView(R.id.iv_goods_icon);
        Glide.with(mContext).load(item.getIcon()).into(iv_goods_icon);
    }
}