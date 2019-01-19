package com.example.administrator.thirdyuekaotest.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.thirdyuekaotest.R;
import com.example.administrator.thirdyuekaotest.data.bean.DetailBean;

import java.util.List;

public class DetailAdapter extends BaseQuickAdapter<DetailBean.DataBean, BaseViewHolder> {
    public DetailAdapter(int layoutResId, @Nullable List<DetailBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailBean.DataBean item) {
        helper.setText(R.id.tv_detail_title, item.getName());
        RecyclerView rv_goods = helper.getView(R.id.rv_goods);
        //商品条目
        List<DetailBean.DataBean.ListBean> beanList = item.getList();
        Log.e(TAG, "beanList.size():" + beanList.size());
        //布局管理器
        GridLayoutManager manager = new GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false);
        rv_goods.setLayoutManager(manager);
        //设置适配器
        GoodsAdapter adapter = new GoodsAdapter(R.layout.goods_item, beanList);
        rv_goods.setAdapter(adapter);
    }
}
